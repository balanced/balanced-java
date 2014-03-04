package com.balancedpayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.balancedpayments.errors.CannotCreate;
import com.balancedpayments.errors.HTTPError;
import com.balancedpayments.errors.NotCreated;

public class ApiKeyTest {
    @Test
    public void testCreate() throws CannotCreate, HTTPError {
        ApiKey key = new ApiKey();
        key.save();
        assertNotNull(key.secret);
    }
    
    @Test
    public void testDelete() throws CannotCreate, NotCreated, HTTPError {
        ApiKey key = new ApiKey();
        key.save();
        Balanced.configure(key.secret);
        key.delete();
    }
    
    @Test
    public void testQueryAll() throws CannotCreate, NotCreated, HTTPError {
        ApiKey key = new ApiKey();
        key.save();
        Balanced.configure(key.secret);
        Marketplace marketplace = new Marketplace();
        marketplace.save();

        ApiKey key1 = new ApiKey();
        key1.saveToExistingMarketplace();
        
        ApiKey key2 = new ApiKey();
        key2.saveToExistingMarketplace();
        
        ApiKey key3 = new ApiKey();
        key3.saveToExistingMarketplace();
        
        ArrayList<ApiKey> keys = ApiKey.query().all();
        assertEquals(4, keys.size());
        ArrayList<String> key_guids = new ArrayList<String>();
        for (ApiKey k: keys) {
            key_guids.add(k.id);
        }
        assertTrue(key_guids.contains(key1.id));
        assertTrue(key_guids.contains(key2.id));
        assertTrue(key_guids.contains(key3.id));
    }
}
