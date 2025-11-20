package com.skillbridge.exception;

public class TrilhaNotFoundException extends RuntimeException {
    public TrilhaNotFoundException(Long id) {
        super("Trilha não encontrada com id: " + id);
    }
}
