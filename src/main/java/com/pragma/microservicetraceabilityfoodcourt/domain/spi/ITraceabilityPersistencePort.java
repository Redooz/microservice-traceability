package com.pragma.microservicetraceabilityfoodcourt.domain.spi;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;

import java.util.List;
import java.util.Optional;

public interface ITraceabilityPersistencePort {
    void saveTraceability(Traceability traceability);
    void updateTraceability(Traceability traceability);
    Optional<Traceability> getTraceabilityByOrderId(Long orderId);
    List<Traceability> getTraceabilitiesByRestaurantNit(String restaurantNit);
}
