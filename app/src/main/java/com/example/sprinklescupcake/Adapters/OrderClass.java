package com.example.sprinklescupcake.Adapters;

public class OrderClass {
    private String OrderId;
    private String UserId;
    private String CupcakeId;
    private int Quantity;
    private int Total;

    public OrderClass(String orderId, String userId, String cupcakeId, int quantity, int total) {
        OrderId = orderId;
        UserId = userId;
        CupcakeId = cupcakeId;
        Quantity = quantity;
        Total = total;
    }

    public OrderClass(String orderId, String cupcakeId,  int quantity, int total) {
        OrderId = orderId;
        CupcakeId = cupcakeId;
        Quantity = quantity;
        Total = total;

    }

    public OrderClass() {

    }


    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {UserId = userId; }

    public String getCupcakeId() {
        return CupcakeId;
    }

    public void setCupcakeId(String cupcakeId) {
        CupcakeId = cupcakeId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}