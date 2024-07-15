package com.pragma.microservicetraceabilityfoodcourt.domain.api.usecase;

import com.pragma.microservicetraceabilityfoodcourt.domain.builder.TraceabilityBuilder;
import com.pragma.microservicetraceabilityfoodcourt.domain.builder.UserBuilder;
import com.pragma.microservicetraceabilityfoodcourt.domain.exception.NoDataFoundException;
import com.pragma.microservicetraceabilityfoodcourt.domain.exception.PermissionDeniedException;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.Traceability;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.User;
import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.Role;
import com.pragma.microservicetraceabilityfoodcourt.domain.spi.ITraceabilityPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TraceabilityUseCaseTest {

    @Mock
    private ITraceabilityPersistencePort traceabilityPersistencePort;

    @InjectMocks
    private TraceabilityUseCase traceabilityUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should save traceability")
    void saveTraceability() {
        Traceability traceability = new TraceabilityBuilder().createTraceability();

        traceabilityUseCase.saveTraceability(traceability);

        verify(traceabilityPersistencePort, times(1)).saveTraceability(traceability);
    }

    @Test
    @DisplayName("Should update traceability")
    void updateTraceability() {
        Traceability traceability = new TraceabilityBuilder().createTraceability();

        traceabilityUseCase.updateTraceability(traceability);

        verify(traceabilityPersistencePort, times(1)).updateTraceability(traceability);
    }

    @Test
    @DisplayName("Should get traceability by order id")
    void getTraceabilityByOrderId() {
        Long orderId = 1L;
        Traceability traceability = new TraceabilityBuilder()
                .setOrderId(orderId)
                .createTraceability();

        when(traceabilityPersistencePort.getTraceabilityByOrderId(orderId)).thenReturn(Optional.of(traceability));

        traceabilityUseCase.getTraceabilityByOrderId(any(User.class),orderId);

        verify(traceabilityPersistencePort, times(1)).getTraceabilityByOrderId(orderId);
    }

    @Test
    @DisplayName("Should throw exception when traceability not found by order id")
    void getTraceabilityByOrderIdNotFound() {
        Long orderId = 1L;

        assertThrows(NoDataFoundException.class, () -> traceabilityUseCase.getTraceabilityByOrderId(any(User.class),orderId));
    }

    @Test
    @DisplayName("Should throw exception when permission denied")
    void getTraceabilityByOrderIdPermissionDenied() {
        Long orderId = 1L;
        Traceability traceability = new TraceabilityBuilder()
                .setOrderId(orderId)
                .setClientId("1")
                .createTraceability();

        User user = new UserBuilder()
                .setDocumentId("2")
                .setRole(Role.CUSTOMER)
                .createUser();

        when(traceabilityPersistencePort.getTraceabilityByOrderId(orderId)).thenReturn(Optional.of(traceability));

        assertThrows(PermissionDeniedException.class, () -> traceabilityUseCase.getTraceabilityByOrderId(user, orderId));
    }

    @Test
    @DisplayName("Should get traceabilities by order id and client id")
    void getTraceabilitiesByOrderIdAndClientId() {
        Long orderId = 1L;
        String clientId = "1";

        when(traceabilityPersistencePort.getTraceabilitiesByOrderIdAndRestaurantNit(orderId, clientId)).thenReturn(List.of(new TraceabilityBuilder().createTraceability()));

        traceabilityUseCase.getTraceabilitiesByOrderIdAndClientId(orderId, clientId);

        verify(traceabilityPersistencePort, times(1)).getTraceabilitiesByOrderIdAndRestaurantNit(orderId, clientId);
    }

    @Test
    @DisplayName("Should throw exception when traceabilities not found by order id and client id")
    void getTraceabilitiesByOrderIdAndClientIdNotFound() {
        Long orderId = 1L;
        String clientId = "1";

        when(traceabilityPersistencePort.getTraceabilitiesByOrderIdAndRestaurantNit(orderId, clientId)).thenReturn(List.of());

        assertThrows(NoDataFoundException.class, () -> traceabilityUseCase.getTraceabilitiesByOrderIdAndClientId(orderId, clientId));
    }
}