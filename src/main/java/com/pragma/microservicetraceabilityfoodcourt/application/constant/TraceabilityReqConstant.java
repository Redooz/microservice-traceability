package com.pragma.microservicetraceabilityfoodcourt.application.constant;

public class TraceabilityReqConstant {
    private TraceabilityReqConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String MSG_ORDER_ID_IS_POSITIVE = "Order ID must be a positive number";
    public static final String MSG_CLIENT_ID_IS_REQUIRED = "Client ID is required";
    public static final String MSG_CLIENT_EMAIL_IS_REQUIRED = "Client email is required";
    public static final String MSG_CLIENT_EMAIL_FORMAT = "Client email format is invalid";
}
