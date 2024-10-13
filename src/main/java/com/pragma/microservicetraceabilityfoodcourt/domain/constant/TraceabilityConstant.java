package com.pragma.microservicetraceabilityfoodcourt.domain.constant;

public class TraceabilityConstant {
    private TraceabilityConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TRACEABILITY_NOT_FOUND = "Traceability with order id %s not found";
    public static final String TRACEABILITIES_FROM_RESTAURANT_WITH_NIT_S_NOT_FOUND = "Traceabilities from restaurant with nit %s not found";
    public static final String PERMISSION_DENIED = "You don't have permission to view this traceability";
}
