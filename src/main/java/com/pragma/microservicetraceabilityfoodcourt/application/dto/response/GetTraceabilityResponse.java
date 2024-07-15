package com.pragma.microservicetraceabilityfoodcourt.application.dto.response;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.OrderStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GetTraceabilityResponse(
        String id,
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
