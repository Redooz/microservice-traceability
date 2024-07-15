package com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.adapter;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import com.pragma.microservicetraceabilityfoodcourt.domain.spi.ITraceabilityPersistencePort;
import com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.document.TraceabilityDocument;
import com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.mapper.ITraceabilityDocumentMapper;
import com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.repository.ITraceabilityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TraceabilityPersistenceAdapter implements ITraceabilityPersistencePort {
    private final ITraceabilityRepository traceabilityRepository;
    private final ITraceabilityDocumentMapper traceabilityDocumentMapper;

    @Override
    public void saveTraceability(Traceability traceability) {
        traceabilityRepository.save(traceabilityDocumentMapper.toDocument(traceability));
    }

    @Override
    public void updateTraceability(Traceability traceability) {
        traceabilityRepository.save(traceabilityDocumentMapper.toDocument(traceability));
    }

    @Override
    public Optional<Traceability> getTraceabilityByOrderId(Long orderId) {
        TraceabilityDocument traceabilityDocument = traceabilityRepository.findByOrderId(orderId);

        return Optional.ofNullable(traceabilityDocumentMapper.toModel(traceabilityDocument));
    }

    @Override
    public List<Traceability> getTraceabilitiesByOrderIdAndClientId(Long orderId, String clientId) {
        List<TraceabilityDocument> traceabilityDocuments = traceabilityRepository.findAllByOrderIdAndClientId(orderId, clientId);

        return traceabilityDocumentMapper.toModelList(traceabilityDocuments);
    }
}
