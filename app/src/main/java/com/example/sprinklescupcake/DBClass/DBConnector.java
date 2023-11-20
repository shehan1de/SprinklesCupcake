package com.example.sprinklescupcake.DBClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBConnector extends SQLiteOpenHelper {
    public DBConnector(Context context) {
        super(context, "DBEg4", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table User (userId VARCHAR PRIMARY KEY NOT NULL, userName VARCHAR, password VARCHAR)");
        sqLiteDatabase.execSQL("create table Admin (adminId VARCHAR PRIMARY KEY NOT NULL, adminName VARCHAR, password VARCHAR)");
        sqLiteDatabase.execSQL("create table Supplier (supplierId VARCHAR PRIMARY KEY NOT NULL, adminId VARCHAR, supplierName VARCHAR, " +
                "password VARCHAR, FOREIGN KEY(adminId) REFERENCES Admin(adminId))");
        sqLiteDatabase.execSQL("create table Category (categoryId VARCHAR PRIMARY KEY NOT NULL, adminId VARCHAR, categoryName VARCHAR, " +
                "FOREIGN KEY(adminId) REFERENCES Admin(adminId))");
        sqLiteDatabase.execSQL("create table Cupcake (cupcakeId VARCHAR PRIMARY KEY NOT NULL, categoryId VARCHAR, cupcakeName VARCHAR," +
                " price INTEGER, discount INTEGER, quantity INTEGER, FOREIGN KEY(categoryId) REFERENCES Category(categoryId))");
        sqLiteDatabase.execSQL("create table Oder (orderId VARCHAR PRIMARY KEY NOT NULL, userId VARCHAR, cupcakeId VARCHAR, quantity INTEGER, " +
                "total INTEGER, FOREIGN KEY(userId) REFERENCES User(userId))");
        sqLiteDatabase.execSQL("create table Feedback (feedbackId INT PRIMARY KEY NOT NULL, userId VARCHAR, title VARCHAR, " +
                "FOREIGN KEY(userId) REFERENCES User(userId))");
        sqLiteDatabase.execSQL("create table SupplierProduct (suppProductId VARCHAR PRIMARY KEY NOT NULL, supplierId VARCHAR," +
                " productName VARCHAR, quantity INTEGER, unitPrice DOUBLE, FOREIGN KEY(supplierId) REFERENCES Supplier(supplierId))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}



