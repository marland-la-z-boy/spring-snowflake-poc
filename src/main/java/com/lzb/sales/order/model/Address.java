package com.lzb.sales.order.model;


public class Address {
    
    public static enum Type {BILLING, SHIPPING, BILLING_SHIPPING};
    private Long addressId;
    private String name;
    private String addressLine;
    private String city;
    private String state;
    private String zipCode;
    private Type addressType;

    
    public Long getAddressId() {
        return addressId;
    }
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public Type getAddressType() {
        return addressType;
    }
    public void setAddressType(Type addressType) {
        this.addressType = addressType;
    }

}
