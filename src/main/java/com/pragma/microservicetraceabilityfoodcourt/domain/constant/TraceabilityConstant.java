package com.pragma.microservicetraceabilityfoodcourt.domain.constant;

public class TraceabilityConstant {
    private TraceabilityConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TRACEABILITY_NOT_FOUND = "Traceability with order id %s not found";
    public static final String TRACEABILITY_NOT_FOUND_BY_ORDER_ID_AND_CLIENT_ID = "Traceabilities with order id %s and client id %s not found";
    public static final String PERMISSION_DENIED = "You don't have permission to view this traceability";
}
