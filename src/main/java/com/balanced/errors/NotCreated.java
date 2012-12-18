package com.balanced.errors;

public class NotCreated extends Exception {

	public NotCreated(Class<?> cls) {
		super(String.format("%s resource has not been created", cls.getName()));
	}
	
}
