package com.example.sprinklescupcake.Adapters;

public class SupplierClass {

    private String SupplierId;
    private String SupplierName;
    private String Password;

    public SupplierClass(String supplierId, String supplierName, String password) {
        SupplierId = supplierId;
        SupplierName = supplierName;
        Password = password;
    }

    public SupplierClass() {

    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
