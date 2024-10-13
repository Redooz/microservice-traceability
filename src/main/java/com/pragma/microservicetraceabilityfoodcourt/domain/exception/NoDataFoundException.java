package com.pragma.microservicetraceabilityfoodcourt.domain.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String message) {
        super(message);
    }
}
