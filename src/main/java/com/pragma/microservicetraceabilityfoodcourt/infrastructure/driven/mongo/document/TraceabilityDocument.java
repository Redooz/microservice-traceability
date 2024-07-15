package com.pragma.microservicetraceabilityfoodcourt.infrastructure.driven.mongo.document;

import com.pragma.microservicetraceabilityfoodcourt.domain.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "traceability")
@Getter
@Setter
@AllArgsConstructor
public class TraceabilityDocument {
    @Id
    private String id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String employeeId;

    private Long orderId;

    private OrderStatus lastStatus;

    private OrderStatus newStatus;

    private String clientEmail;

    private String clientId;

    private String employeeEmail;

    private String restaurantNit;
}
