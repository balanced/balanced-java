package com.balanced.errors;

import java.util.Map;

import org.apache.http.HttpResponse;


public class HTTPError extends Exception {

	public HTTPError(HttpResponse response, Map<String, Object> payload) {
	}

}
