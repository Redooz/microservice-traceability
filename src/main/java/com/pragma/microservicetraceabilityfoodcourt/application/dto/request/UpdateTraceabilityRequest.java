package com.pragma.microservicetraceabilityfoodcourt.application.dto.request;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.OrderStatus;

public record UpdateTraceabilityRequest(
        String employeeId,

        String employeeEmail,

        OrderStatus lastStatus,

        OrderStatus newStatus
) {
}
