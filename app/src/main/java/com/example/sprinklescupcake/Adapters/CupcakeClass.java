package com.example.sprinklescupcake.Adapters;

public class CupcakeClass {

    private String CupcakeId;
    private String CategoryId;
    private String CupcakeName;
    private int CupcakePrice;
    private int Discount;
    private int Quantity;

    public CupcakeClass(String cupcakeId, String categoryId, String cupcakeName, int cupcakePrice, int discount, int quantity) {
        CupcakeId = cupcakeId;
        CategoryId = categoryId;
        CupcakeName = cupcakeName;
        CupcakePrice = cupcakePrice;
        Discount = discount;
        Quantity = quantity;
    }

    public CupcakeClass() {

    }


    public String getCupcakeId() {
        return CupcakeId;
    }

    public void setCupcakeId(String cupcakeId) {
        CupcakeId = cupcakeId;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getCupcakeName() {
        return CupcakeName;
    }

    public void setCupcakeName(String cupcakeName) {
        CupcakeName = cupcakeName;
    }

    public int getCupcakePrice() {
        return CupcakePrice;
    }

    public void setCupcakePrice(int cupcakePrice) {
        CupcakePrice = cupcakePrice;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
