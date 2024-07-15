package com.pragma.microservicetraceabilityfoodcourt.application.dto.response;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.OrderStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetTraceabilityResponse(
        String id,
        Long orderId,
        String clientId,
        String clientEmail,
        String employeeId,
        String employeeEmail,
        LocalDateTime startTime,
        LocalDateTime endTime,
        OrderStatus lastStatus,
        OrderStatus newStatus
) {
}
