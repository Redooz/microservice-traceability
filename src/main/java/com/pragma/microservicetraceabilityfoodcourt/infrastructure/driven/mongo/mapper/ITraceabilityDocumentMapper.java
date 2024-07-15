package com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.mapper;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.document.TraceabilityDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITraceabilityDocumentMapper {
    TraceabilityDocument toDocument(Traceability traceability);
    Traceability toModel(TraceabilityDocument traceabilityDocument);
    List<Traceability> toModelList(List<TraceabilityDocument> traceabilityDocuments);
}
