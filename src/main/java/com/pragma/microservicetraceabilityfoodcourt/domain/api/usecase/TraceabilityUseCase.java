package com.pragma.microservicetraceabilityfoodcourt.domain.api.usecase;

import com.pragma.microservicetraceabilityfoodcourt.domain.api.ITraceabilityServicePort;
import com.pragma.microservicetraceabilityfoodcourt.domain.constant.TraceabilityConstant;
import com.pragma.microservicetraceabilityfoodcourt.domain.exception.NoDataFoundException;
import com.pragma.microservicetraceabilityfoodcourt.domain.exception.PermissionDeniedException;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.User;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.Role;
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
    public Traceability getTraceabilityByOrderId(User loggedUser, Long orderId) {
        Traceability traceability = traceabilityPersistencePort.getTraceabilityByOrderId(orderId).orElseThrow(
                () -> new NoDataFoundException(
                        String.format(TraceabilityConstant.TRACEABILITY_NOT_FOUND, orderId)
                ));

        if (loggedUser.getRole() == Role.CUSTOMER && !traceability.getClientId().equals(loggedUser.getDocumentId())) {
            throw new PermissionDeniedException(TraceabilityConstant.PERMISSION_DENIED);
        }

        return traceability;
    }

    @Override
    public List<Traceability> getTraceabilitiesByOrderIdAndClientId(Long orderId, String clientId) {
        List<Traceability> traceabilities = traceabilityPersistencePort.getTraceabilitiesByOrderIdAndClientId(orderId, clientId);

        if (traceabilities.isEmpty()) {
            throw new NoDataFoundException(
                    String.format(TraceabilityConstant.TRACEABILITY_NOT_FOUND_BY_ORDER_ID_AND_CLIENT_ID, orderId, clientId)
            );
        }

        return traceabilities;
    }
}
