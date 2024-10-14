package com.bryan.backend.usersapp.backendusersapp.ErrorManagment;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
