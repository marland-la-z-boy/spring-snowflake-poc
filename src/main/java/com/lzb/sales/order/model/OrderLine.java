package com.lzb.sales.order.model;

public class OrderLine {
    
    public static enum Type {INTERNAL, EXTERNAL}
    private Integer orderLineId;
    private String partnumber;
    private Integer quanity;
    private Type type;

    public Integer getOrderLineId() {
        return orderLineId;
    }
    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }
    public String getPartnumber() {
        return partnumber;
    }
    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }
    public Integer getQuanity() {
        return quanity;
    }
    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    
}
