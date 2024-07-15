package com.pragma.microservicetraceabilityfoodcourt.infrastructure.driving.http.controller;

import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.CreateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.request.UpdateTraceabilityRequest;
import com.pragma.microservicetraceabilityfoodcourt.application.dto.response.GetTraceabilityResponse;
import com.pragma.microservicetraceabilityfoodcourt.application.handler.TraceabilityHandler;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/traceability")
@RequiredArgsConstructor
@Tag(name = "Traceability", description = "The Traceability Endpoint")
public class TraceabilityControllerAdapter {
    private final TraceabilityHandler traceabilityHandler;

    @PostMapping("/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Traceability created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> createTraceability(@RequestBody @Valid CreateTraceabilityRequest request) {
        traceabilityHandler.saveTraceability(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{orderId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Traceability updated"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> updateTraceability(@PathVariable Long orderId, @RequestBody @Valid UpdateTraceabilityRequest request) {
        traceabilityHandler.updateTraceability(orderId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Traceability found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Traceability not found")
    })
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<GetTraceabilityResponse> getTraceabilityByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(traceabilityHandler.getTraceabilityByOrderId(orderId));
    }

}
