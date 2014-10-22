package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import com.balancedpayments.errors.*;
import org.junit.Test;


public class CallbackTest extends BaseTest {

    @Test
    public void testCallbackCreate() throws HTTPError, NotCreated, NoResultsFound, MultipleResultsFound {
        Callback.Collection callbacks = mp.callbacks;
        int total = callbacks.total();
        assertEquals(0, total);

        HashMap<String, Object> callbackPayload = new HashMap<String, Object>();
        callbackPayload.put("url", "http://www.example.com/cb");
        callbackPayload.put("method", "post");

        Callback callback = new Callback(callbackPayload);
        callback.save();

        callback.reload();
        mp.reload();

        assertEquals(mp.callbacks.total(), 1);
        assertEquals("http://www.example.com/cb", callback.url);
        assertEquals("post", callback.method);

        callback.delete();
        mp.reload();

        assertEquals(mp.callbacks.total(), 0);
    }

    @Test
    public void testCallbacksResourceFields() throws HTTPError {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("url", "http://www.example.com/callback");
        payload.put("method", "post");

        Callback callback = new Callback(payload);
        callback.save();

        assertTrue(callback.href.contains("/callbacks/CB"));
        assertTrue(callback.id.contains("CB"));
        assertEquals(callback.method, "post");
        assertEquals(callback.revision, "1.1");
        assertEquals(callback.url, "http://www.example.com/callback");
    }
}
