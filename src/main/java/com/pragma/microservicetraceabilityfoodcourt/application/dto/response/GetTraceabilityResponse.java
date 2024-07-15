package com.pragma.microservicetraceabilityfoodcourt.application.dto.response;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.OrderStatus;

import java.time.LocalDate;

public record GetTraceabilityResponse(
        Long id,
        Long orderId,
        String clientId,
        String clientEmail,
        String employeeId,
        String employeeEmail,
        LocalDate date,
        OrderStatus lastStatus,
        OrderStatus newStatus
) {
}
