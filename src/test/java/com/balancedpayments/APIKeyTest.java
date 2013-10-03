package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

public class APIKeyTest extends BaseTest {

    @Test
    public void testCreateAnonyous() throws CannotCreate, HTTPError {
        APIKey key = new APIKey();
        key.save();
        assertNotNull(key.secret);
    }
    
    @Test
    public void testCreate() throws CannotCreate, HTTPError {
        APIKey key = new APIKey();
        key.save();
        assertNotNull(key.secret);
    }
    
    @Test
    public void testDelete() throws CannotCreate, NotCreated, HTTPError {
        APIKey key = new APIKey();
        key.save();
        Balanced.configure(key.secret);
        key.delete();
    }
    
    @Test
    public void testQueryAll() throws CannotCreate, NotCreated, HTTPError {
        APIKey key1 = new APIKey();
        key1.saveToExistingMarketplace();
        
        APIKey key2 = new APIKey();
        key2.saveToExistingMarketplace();
        
        APIKey key3 = new APIKey();
        key3.saveToExistingMarketplace();
        
        ArrayList<APIKey> keys = APIKey.query().all();
        assertEquals(4, keys.size());
        ArrayList<String> key_guids = new ArrayList<String>();
        for(APIKey key: keys) {
            key_guids.add(key.id);
        }
        assertTrue(key_guids.contains(key1.id));
        assertTrue(key_guids.contains(key2.id));
        assertTrue(key_guids.contains(key3.id));
    }
}
