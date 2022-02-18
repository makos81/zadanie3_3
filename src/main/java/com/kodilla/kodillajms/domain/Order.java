package com.kodilla.kodillajms.domain;

public class Order {
    private String orderId;
    private String itemName;

    public Order(String orderId, String itemName) {
        this.orderId = orderId;
        this.itemName = itemName;
    }

    public Order() {

    }

    public String getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
