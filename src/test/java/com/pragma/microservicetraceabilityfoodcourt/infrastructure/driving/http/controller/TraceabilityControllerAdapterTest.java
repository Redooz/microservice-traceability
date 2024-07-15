package com.pragma.microservicetraceabilityfoodcourt.infrastructure.driving.http.controller;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.UpdateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.response.GetTraceabilityResponse;
import com.pragma.microservicetraceabilityfoodcourt.application.handler.TraceabilityHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class TraceabilityControllerAdapterTest {
    @Mock
    private TraceabilityHandler traceabilityHandler;

    @InjectMocks
    private TraceabilityControllerAdapter traceabilityControllerAdapter;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @DisplayName("Creating traceability successfully returns status CREATED")
    void creatingTraceabilitySuccessfullyReturnsStatusCreated() {
        CreateTraceabilityRequest request = CreateTraceabilityRequest.builder().build();
        doNothing().when(traceabilityHandler).saveTraceability(request);

        ResponseEntity<Void> response = traceabilityControllerAdapter.createTraceability(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("Updating traceability successfully returns status OK")
    void updatingTraceabilitySuccessfullyReturnsStatusOk() {
        Long orderId = 1L;
        UpdateTraceabilityRequest request = UpdateTraceabilityRequest.builder().build();
        doNothing().when(traceabilityHandler).updateTraceability(orderId, request);

        ResponseEntity<Void> response = traceabilityControllerAdapter.updateTraceability(orderId, request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Getting traceability by order id successfully returns status OK")
    void gettingTraceabilityByOrderIdSuccessfullyReturnsStatusOk() {
        Long orderId = 1L;
        when(traceabilityHandler.getTraceabilityByOrderId(orderId)).thenReturn(GetTraceabilityResponse.builder().build());

        ResponseEntity<GetTraceabilityResponse> response = traceabilityControllerAdapter.getTraceabilityByOrderId(orderId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}