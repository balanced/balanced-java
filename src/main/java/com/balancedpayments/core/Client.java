package com.balancedpayments.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.balancedpayments.Settings;
import com.balancedpayments.errors.APIError;
import com.balancedpayments.errors.Declined;
import com.balancedpayments.errors.DuplicateAccountEmailAddress;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.InsufficientFunds;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client {
    
    private static final String AGENT = "balanced-java";
    private static final int CONNECTION_TIMEOUT = 60 * 1000;
    
    private String root;
    private String key;
    private HttpClient httpClient; 
    
    public Client(String location, String key) {
        this.key = (key != null) ? key : Settings.key;
        this.root = (location != null) ? location : Settings.location;
        
        PoolingClientConnectionManager connMgr = new PoolingClientConnectionManager();
        this.httpClient = new DefaultHttpClient(connMgr);
        
        this.httpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        this.httpClient.getParams().setParameter("http.socket.timeout", new Integer(CONNECTION_TIMEOUT));
        this.httpClient.getParams().setParameter("http.connection.timeout", new Integer(CONNECTION_TIMEOUT));
        this.httpClient.getParams().setParameter("http.protocol.content-charset", "UTF-8");
    }
    
    public Client() {
        this(null, null);
    }

    public Map<String, Object> get(String path, Map<String, String> params) throws HTTPError {
        URI uri = buildUri(path, params);
        HttpGet request = new HttpGet(uri);
        addHeaders(request);
        return op(request);
    }
    
    public Map<String, Object> get(String path) throws HTTPError {
        return get(path, new HashMap<String, String>());
    }

    public void delete(String path, Map<String, String> params) throws HTTPError {
        URI uri = buildUri(path, params);
        HttpDelete request = new HttpDelete(uri);
        addHeaders(request);
        op(request);
    }
    
    public void delete(String path) throws HTTPError {
        delete(path, new HashMap<String, String>());
    }
    
    public Map<String, Object> put(String path, Object payload) throws HTTPError {
        URI uri = buildUri(path);
        HttpPut request = new HttpPut(uri);
        addHeaders(request);
        request.setEntity(new StringEntity(
                serialize(payload), 
                ContentType.APPLICATION_JSON));
        return op(request);
    }
    
    public Map<String, Object> post(String path, Object payload) throws HTTPError {
        URI uri = buildUri(path);
        HttpPost request = new HttpPost(uri);
        addHeaders(request);
        request.setEntity(new StringEntity(
                serialize(payload), 
                ContentType.APPLICATION_JSON));
        return op(request);
    }
    
    private String buildQueryString(Map<String, String> params) {
        ArrayList<NameValuePair> nvs = new ArrayList<NameValuePair>(params.size()); 
        for (Map.Entry<String, String> entry : params.entrySet()) {
            NameValuePair nv = new BasicNameValuePair(entry.getKey(), entry.getValue());
            nvs.add(nv);
        }
        String queryString = URLEncodedUtils.format(nvs, "UTF-8");
        return queryString; 
    }
    
    private URI buildUri(String path, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(root);
        sb.append(path);
        if (params != null && params.size() > 0) {
            sb.append("?");
            sb.append(buildQueryString(params));
        }
        try {
            return new URI(sb.toString());
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    
    private URI buildUri(String path) {
        return buildUri(path, null);
    }
    
    private void addHeaders(HttpUriRequest request) {
        String version = getClass().getPackage().getImplementationVersion();
        request.addHeader(new BasicHeader("User-Agent", AGENT + '/' + version));
        request.addHeader(new BasicHeader("Accept", "application/json"));
    }
    
    private Map<String, Object> op(HttpUriRequest request) throws HTTPError {
        if (key != null) {
            byte auth[];
            try {
                auth = (key + ":").getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            String authEncoding = Base64.encodeBase64URLSafeString(auth);
            request.setHeader("Authorization", "Basic " + authEncoding);
        }
        
        HttpResponse response;
        try {
            response = httpClient.execute(request);
        }
        catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        String body = null;
        Map<String, Object> payload = null;
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                body = EntityUtils.toString(entity);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (ContentType.APPLICATION_JSON.getMimeType().equals(entity.getContentType().getValue()))
                payload = deserialize(body);
        }

        StatusLine status = response.getStatusLine();
        if (status.getStatusCode() >= 299) {
            if (payload != null && status.getStatusCode() != 300)
                error(response, body, payload);
            else
                throw new HTTPError(response, body);
        }

        return payload;
    }
    
    private String serialize(Object payload) {
        Gson gson = new Gson();
        return gson.toJson(payload);
    }
    
    private Map<String, Object> deserialize(String body) {
        Gson gson = new Gson();
        return gson.fromJson(body, new TypeToken<Map<String, Object>>() {}.getType());
    }
    
    private static void error(
            HttpResponse response,
            String body,
            Map<String, Object> payload) throws APIError {
        String category_code = (String) payload.get("category_code");
        
        // http://stackoverflow.com/questions/3434466/creating-a-factory-method-in-java-that-doesnt-rely-on-if-else
        if (InsufficientFunds.CODES.contains(category_code))
            throw new InsufficientFunds(response, body, payload);
        else if (Declined.CODES.contains(category_code))
            throw new Declined(response, body, payload);
        else if (DuplicateAccountEmailAddress.CODES.contains(category_code))
            throw new DuplicateAccountEmailAddress(response, body, payload);
        
        throw new APIError(response, body, payload);
    }
}
