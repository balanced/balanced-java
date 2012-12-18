package com.balanced.errors;

public class CannotCreate extends Exception {
    
    public CannotCreate(Class<?> cls) {
        super(String.format("Cannot directly create %s resources", cls.getName()));
    }
}
