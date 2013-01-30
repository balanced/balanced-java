package com.balanced.errors;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class HTTPError extends Exception {
    
    public int status_code;
    public String status;
    public String raw;
    

    public HTTPError(HttpResponse response, String raw) {
        StatusLine status_line = response.getStatusLine();
        this.status_code = status_line.getStatusCode();
        this.status = status_line.getReasonPhrase();
        this.raw = raw; 
    }

}
