package com.pragma.microservicetraceabilityfoodcourt.domain.exception;

public class PermissionDeniedException extends RuntimeException {
    public PermissionDeniedException(String message) {
        super(message);
    }
}
