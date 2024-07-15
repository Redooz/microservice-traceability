package com.pragma.microservicetraceabilityfoodcourt.configuration;

import com.pragma.microservicetraceabilityfoodcourt.domain.api.ITraceabilityServicePort;
import com.pragma.microservicetraceabilityfoodcourt.domain.api.usecase.TraceabilityUseCase;
import com.pragma.microservicetraceabilityfoodcourt.domain.spi.ITraceabilityPersistencePort;
import com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.adapter.TraceabilityPersistenceAdapter;
import com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.mapper.ITraceabilityDocumentMapper;
import com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.repository.ITraceabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TraceabilityBeanConfiguration {
    private final ITraceabilityRepository traceabilityRepository;
    private final ITraceabilityDocumentMapper traceabilityDocumentMapper;

    @Bean
    public ITraceabilityPersistencePort traceabilityPersistencePort() {
        return new TraceabilityPersistenceAdapter(traceabilityRepository, traceabilityDocumentMapper);
    }

    @Bean
    public ITraceabilityServicePort traceabilityServicePort() {
        return new TraceabilityUseCase(traceabilityPersistencePort());
    }
}
