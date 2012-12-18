package com.balanced;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.balanced.errors.CannotCreate;
import com.balanced.errors.HTTPError;
import com.balanced.errors.NotCreated;

public class APIKeyTest extends BaseTest {

	@Test
	public void testCreateAnonyous() throws CannotCreate, HTTPError {
		Settings.key = null;
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
		key.delete();
	}
	
	@Test
	public void testQueryAll() throws CannotCreate, NotCreated, HTTPError {
		Settings.key = null;
		
		APIKey key1 = new APIKey();
		key1.save();
		
		Settings.key = key1.secret;
		
		APIKey key2 = new APIKey();
		key2.save();
		
		APIKey key3 = new APIKey();
		key3.save();
		
		ArrayList<APIKey> keys = APIKey.query().all();
		assertEquals(keys.size(), 3);
		ArrayList<String> key_guids = new ArrayList<String>();
		for(APIKey key: keys) {
			key_guids.add(key.id);
		}
		assertTrue(key_guids.contains(key1.id));
		assertTrue(key_guids.contains(key2.id));
		assertTrue(key_guids.contains(key3.id));
	}
}
