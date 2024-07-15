package com.pragma.microservicetraceabilityfoodcourt.application.handler;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.UpdateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.response.GetTraceabilityResponse;
import com.pragma.microservicetraceabilityfoodcourt.application.mapper.ITraceabilityDtoMapper;
import com.pragma.microservicetraceabilityfoodcourt.domain.api.ITraceabilityServicePort;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        traceabilityServicePort.updateTraceability(traceability);
    }

    public GetTraceabilityResponse getTraceabilityByOrderId(Long orderId) {
        return traceabilityDtoMapper.toResponse(traceabilityServicePort.getTraceabilityByOrderId(orderId));
    }
}
