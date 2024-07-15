package com.pragma.microservicetraceabilityfoodcourt.application.handler;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.UpdateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.response.GetTraceabilityResponse;
import com.pragma.microservicetraceabilityfoodcourt.application.mapper.ITraceabilityDtoMapper;
import com.pragma.microservicetraceabilityfoodcourt.domain.api.ITraceabilityServicePort;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceabilityHandler {
    private final ITraceabilityServicePort traceabilityServicePort;
    private final ITraceabilityDtoMapper traceabilityDtoMapper;

    public void saveTraceability(CreateTraceabilityRequest request) {
        traceabilityServicePort.saveTraceability(traceabilityDtoMapper.toModelFromCreate(request));
    }

    public void updateTraceability(Long orderId, UpdateTraceabilityRequest request) {
        User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Traceability traceability = traceabilityServicePort.getTraceabilityByOrderId(loggedUser, orderId);

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
        User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Traceability traceability = traceabilityServicePort.getTraceabilityByOrderId(loggedUser, orderId);
        return traceabilityDtoMapper.toResponse(traceability);
    }

    public List<GetTraceabilityResponse> getTraceabilitiesByRestaurantNit(String nit) {
        List<Traceability> traceabilities = traceabilityServicePort.getTraceabilitiesByRestaurantNit(nit);
        return traceabilityDtoMapper.toResponseList(traceabilities);
    }
}
