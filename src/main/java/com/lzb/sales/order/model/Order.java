package com.lzb.sales.order.model;

public class Order {
    
    public static enum Status{IN_PROGRESS, CANCELLED, COMPLETED, SHIPPED};
    private Long orderId;
    private Customer customer;
    private Address address;
    private java.sql.Timestamp orderDate;
    private Status status;
    private String description;
    private OrderLine[] orderLines;

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public OrderLine[] getOrderLines() {
        return orderLines;
    }
    public void setOrderLines(OrderLine[] orderLines) {
        this.orderLines = orderLines;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public java.sql.Timestamp getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(java.sql.Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    

}
