package com.pragma.microservicetraceabilityfoodcourt.domain.constant;

public class TraceabilityConstant {
    private TraceabilityConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TRACEABILITY_NOT_FOUND = "Traceability with order id %s not found";
}
