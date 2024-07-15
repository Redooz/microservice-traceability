package com.pragma.microservicetraceabilityfoodcourt.domain.api.usecase;

import com.pragma.microservicetraceabilityfoodcourt.domain.api.ITraceabilityServicePort;
import com.pragma.microservicetraceabilityfoodcourt.domain.constant.TraceabilityConstant;
import com.pragma.microservicetraceabilityfoodcourt.domain.exception.NoDataFoundException;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import com.pragma.microservicetraceabilityfoodcourt.domain.spi.ITraceabilityPersistencePort;

import java.util.List;

public class TraceabilityUseCase implements ITraceabilityServicePort {
    private final ITraceabilityPersistencePort traceabilityPersistencePort;

    public TraceabilityUseCase(ITraceabilityPersistencePort traceabilityPersistencePort) {
        this.traceabilityPersistencePort = traceabilityPersistencePort;
    }

    @Override
    public void saveTraceability(Traceability traceability) {
        traceabilityPersistencePort.saveTraceability(traceability);
    }

    @Override
    public void updateTraceability(Traceability traceability) {
        traceabilityPersistencePort.updateTraceability(traceability);
    }

    @Override
    public Traceability getTraceabilityByOrderId(Long orderId) {
        return traceabilityPersistencePort.getTraceabilityByOrderId(orderId).orElseThrow(
                () -> new NoDataFoundException(
                        String.format(TraceabilityConstant.TRACEABILITY_NOT_FOUND, orderId)
                ));
    }

    @Override
    public List<Traceability> getTraceabilitiesByOrderIdAndClientId(Long orderId, String clientId) {
        return traceabilityPersistencePort.getTraceabilitiesByOrderIdAndClientId(orderId, clientId);
    }
}
