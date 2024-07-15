package com.pragma.microservicetraceabilityfoodcourt.domain.model;

import com.pragma.microservicetraceabilityfoodcourt.domain.enums.OrderStatus;

import java.time.LocalDate;

public class Traceability {
    private LocalDate date;
    private String employeeId;
    private String id;
    private Long orderId;
    private OrderStatus lastStatus;
    private OrderStatus newStatus;
    private String clientEmail;
    private String clientId;
    private String employeeEmail;

    public Traceability(LocalDate date, String employeeId, String id, Long orderId, OrderStatus lastStatus, OrderStatus newStatus, String clientEmail, String clientId, String employeeEmail) {
        this.date = date;
        this.employeeId = employeeId;
        this.id = id;
        this.orderId = orderId;
        this.lastStatus = lastStatus;
        this.newStatus = newStatus;
        this.clientEmail = clientEmail;
        this.clientId = clientId;
        this.employeeEmail = employeeEmail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(OrderStatus lastStatus) {
        this.lastStatus = lastStatus;
    }

    public OrderStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(OrderStatus newStatus) {
        this.newStatus = newStatus;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
