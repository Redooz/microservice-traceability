package com.pragma.microservicetraceabilityfoodcourt.domain.model.enums;

public enum OrderStatus {
    PENDING,
    IN_PROGRESS,
    CANCELLED,
    // Ready means that the order is ready to be delivered, not that it is already delivered
    READY,
    DELIVERED
}
