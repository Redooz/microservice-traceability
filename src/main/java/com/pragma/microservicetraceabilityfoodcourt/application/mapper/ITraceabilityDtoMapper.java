package com.pragma.microservicetraceabilityfoodcourt.application.mapper;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.UpdateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.response.GetTraceabilityResponse;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITraceabilityDtoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastStatus", ignore = true)
    @Mapping(target = "employeeId", ignore = true)
    @Mapping(target = "employeeEmail", ignore = true)
    Traceability toModelFromCreate(CreateTraceabilityRequest createTraceabilityRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "clientEmail", ignore = true)
    @Mapping(target = "clientId", ignore = true)
    Traceability toModelFromUpdate(UpdateTraceabilityRequest updateTraceabilityRequest);

    GetTraceabilityResponse toResponse(Traceability traceability);

    List<GetTraceabilityResponse> toResponseList(List<Traceability> traceabilities);
}
