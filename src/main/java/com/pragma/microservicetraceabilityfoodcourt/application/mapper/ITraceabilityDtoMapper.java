package com.pragma.microservicetraceabilityfoodcourt.application.mapper;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
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
    Traceability toModel(CreateTraceabilityRequest createTraceabilityRequest);

    GetTraceabilityResponse toResponse(Traceability traceability);

    List<GetTraceabilityResponse> toResponseList(List<Traceability> traceabilities);
}
