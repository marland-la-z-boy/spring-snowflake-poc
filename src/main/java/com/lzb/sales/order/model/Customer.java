package com.lzb.sales.order.model;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private Address[] addresses; 
    private Order[] orders;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public Address[] getAddresses() {
        return addresses;
    }
    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }
    public Order[] getOrders() {
        return orders;
    }
    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public String toString(){
        return "customerId: "+getId()+"\n first name: "+getFirstName();
    }
}
