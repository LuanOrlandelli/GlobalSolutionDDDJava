package com.skillbridge.exception;

public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException(String email) {
        super("Email já cadastrado: " + email);
    }
}
