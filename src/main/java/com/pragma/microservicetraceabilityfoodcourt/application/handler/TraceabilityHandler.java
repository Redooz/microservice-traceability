package com.pragma.microservicetraceabilityfoodcourt.application.handler;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.UpdateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.response.GetTraceabilityResponse;
import com.pragma.microservicetraceabilityfoodcourt.application.mapper.ITraceabilityDtoMapper;
import com.pragma.microservicetraceabilityfoodcourt.domain.api.ITraceabilityServicePort;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TraceabilityHandler {
    private final ITraceabilityServicePort traceabilityServicePort;
    private final ITraceabilityDtoMapper traceabilityDtoMapper;

    public void saveTraceability(CreateTraceabilityRequest request) {
        traceabilityServicePort.saveTraceability(traceabilityDtoMapper.toModelFromCreate(request));
    }

    public void updateTraceability(Long orderId, UpdateTraceabilityRequest request) {
        Traceability traceability = traceabilityServicePort.getTraceabilityByOrderId(orderId);

        traceability.setOrderId(orderId);

        traceability.setEmployeeId(request.employeeId());
        traceability.setEmployeeEmail(request.employeeEmail());
        traceability.setLastStatus(request.lastStatus());
        traceability.setNewStatus(request.newStatus());

        if (request.endTime() != null) {
            traceability.setEndTime(request.endTime());
        }

        traceabilityServicePort.updateTraceability(traceability);
    }

    public GetTraceabilityResponse getTraceabilityByOrderId(Long orderId) {
        Traceability traceability = traceabilityServicePort.getTraceabilityByOrderId(orderId);
        return traceabilityDtoMapper.toResponse(traceability);
    }
}
