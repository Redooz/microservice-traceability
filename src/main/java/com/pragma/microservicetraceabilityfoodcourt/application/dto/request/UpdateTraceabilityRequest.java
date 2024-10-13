package com.pragma.microservicetraceabilityfoodcourt.application.dto.request;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.OrderStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UpdateTraceabilityRequest(
        String employeeId,

        String employeeEmail,

        OrderStatus lastStatus,

        OrderStatus newStatus,

        LocalDateTime endTime
) {
}
