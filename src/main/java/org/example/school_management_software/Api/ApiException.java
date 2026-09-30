package org.example.school_management_software.Api;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}