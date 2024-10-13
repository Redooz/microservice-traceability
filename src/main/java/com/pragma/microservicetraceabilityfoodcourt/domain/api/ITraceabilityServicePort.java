package com.pragma.microservicetraceabilityfoodcourt.domain.api;


import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.User;

import java.util.List;

public interface ITraceabilityServicePort {
    void saveTraceability(Traceability traceability);

    void updateTraceability(Traceability traceability);

    Traceability getTraceabilityByOrderId(User loggedUser, Long orderId);

    List<Traceability> getTraceabilitiesByRestaurantNit(String restaurantNit);

    List<Traceability> getTraceabilitiesSortByBestEmployees(String restaurantNit);
}
