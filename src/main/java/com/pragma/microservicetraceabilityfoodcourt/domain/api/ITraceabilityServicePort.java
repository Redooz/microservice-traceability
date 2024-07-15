package com.pragma.microservicetraceabilityfoodcourt.domain.api;


import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;

import java.util.List;

public interface ITraceabilityServicePort {
    void saveTraceability(Traceability traceability);

    void updateTraceability(Traceability traceability);

    Traceability getTraceabilityByOrderId(Long orderId);

    List<Traceability> getTraceabilitiesByOrderIdAndClientId(Long orderId, String clientId);
}
