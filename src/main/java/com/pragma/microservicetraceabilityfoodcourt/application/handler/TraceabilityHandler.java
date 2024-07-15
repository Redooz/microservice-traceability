package com.pragma.microservicetraceabilityfoodcourt.application.handler;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.mapper.ITraceabilityDtoMapper;
import com.pragma.microservicetraceabilityfoodcourt.domain.api.ITraceabilityServicePort;
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

    public void updateTraceability(CreateTraceabilityRequest request) {
        traceabilityServicePort.updateTraceability(traceabilityDtoMapper.toModelFromCreate(request));
    }

    public void getTraceabilityByOrderId(Long orderId) {
        traceabilityServicePort.getTraceabilityByOrderId(orderId);
    }
}
