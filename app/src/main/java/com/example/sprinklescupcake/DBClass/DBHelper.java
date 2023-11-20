package com.example.sprinklescupcake.DBClass;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import com.example.sprinklescupcake.Adapters.AdminClass;
import com.example.sprinklescupcake.Adapters.CategoryClass;
import com.example.sprinklescupcake.Adapters.CupcakeClass;
import com.example.sprinklescupcake.Adapters.FeedbackClass;
import com.example.sprinklescupcake.Adapters.OrderClass;
import com.example.sprinklescupcake.Adapters.ProductClass;
import com.example.sprinklescupcake.Adapters.SessionManager;
import com.example.sprinklescupcake.Adapters.SupplierClass;
import com.example.sprinklescupcake.Adapters.UserClass;

import java.util.ArrayList;
public class DBHelper {
    private Context con;
    private SQLiteDatabase db;

    public DBHelper(Context con) {
        this.con = con;
    }

    public DBHelper OpenDB() {
        DBConnector dbCon = new DBConnector(con);
        db = dbCon.getWritableDatabase();
        return this;
    }
    public boolean CreateNewUser(UserClass userClass) {
        try {
            db.execSQL("insert into User values('" + userClass.getUserId() + "','" + userClass.getUserName() + "','" +
                    userClass.getPassword() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public ArrayList<UserClass> UserValidLogin(String UserId, String Password) {
        ArrayList<UserClass> userList = new ArrayList<UserClass>();
        try {
            Cursor cursor = db.rawQuery("Select * from User where UserID='" + UserId + "'" + "and Password='" + Password + "'",
                    null);
            if (cursor.moveToFirst()) {
                do {
                    UserClass user = new UserClass();
                    user.setUserId(cursor.getString(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    public ArrayList<AdminClass> AdminValidLogin(String AdminId, String Password) {
        ArrayList<AdminClass> userList = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery("Select * from Admin where AdminId='" + AdminId + "'" + "and Password='" + Password + "'",
                    null);
            if (cursor.moveToFirst()) {
                do {
                    AdminClass admin = new AdminClass();
                    admin.setAdminId(cursor.getString(0));
                    admin.setAdminName(cursor.getString(1));
                    admin.setPassword(cursor.getString(2));
                    userList.add(admin);
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    public ArrayList<SupplierClass> SupplierValidLogin(String SupplierId, String Password) {
        ArrayList<SupplierClass> userList = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery("Select * from Supplier where SupplierId='" + SupplierId + "'" + "and Password='" +
                            Password + "'",
                    null);
            if (cursor.moveToFirst()) {
                do {
                    SupplierClass supplier = new SupplierClass();
                    supplier.setSupplierId(cursor.getString(0));
                    supplier.setSupplierName(cursor.getString(1));
                    supplier.setPassword(cursor.getString(2));


                    userList.add(supplier);
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    public boolean CreateNewSupplier(SupplierClass supplierClass) {
        try {
            String adminId = SessionManager.getUserId();
            db.execSQL("insert into Supplier values('" + supplierClass.getSupplierId() + "','" + SessionManager.getUserId() + "','" +
                    supplierClass.getSupplierName() + "','" + supplierClass.getPassword() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
    public boolean SupplierDelete(String SupplierId) {

        try {
            String sql = "DELETE FROM Supplier WHERE SupplierId = ?";
            
            db.execSQL(sql, new String[] {SupplierId});
            return true;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean CreateNewCategory(CategoryClass categoryClass) {
        try {
            String adminId = SessionManager.getUserId();
            db.execSQL("insert into Category values('" + categoryClass.getCategoryId() + "','" + SessionManager.getUserId() + "','" + categoryClass.getCategoryName() +
                    "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
    public boolean CategoryDelete(String CategoryId) {
        try {
            String sql = "DELETE FROM Category WHERE CategoryId = ?";

            db.execSQL(sql, new String[] {CategoryId});
            return true;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean CreateNewCupcake(CupcakeClass cupcakeClass) {
        try {
            String adminId = SessionManager.getUserId();
            db.execSQL("insert into Cupcake values('" + cupcakeClass.getCupcakeId() + "','" + cupcakeClass.getCategoryId() + "'," +
                    "'" +cupcakeClass.getCupcakeName() + "','" + cupcakeClass.getCupcakePrice() + "'," +
                    "'" + cupcakeClass.getDiscount() + "','" + cupcakeClass.getQuantity() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
    public boolean CupcakeDelete(String CupcakeId) {


     try {
        String sql = "DELETE FROM Cupcake WHERE CupcakeId = ?";

        db.execSQL(sql, new String[] {CupcakeId});
        return true;
    }
        catch (SQLException ex) {
        ex.printStackTrace();
    }
        return false;
}
    public ArrayList<OrderClass> SearchOrder(String OrderID) {
        ArrayList<OrderClass> orderList = new ArrayList<OrderClass>();
        try {
            Cursor cursor = db.rawQuery("Select * from Oder where OrderId='" +
                    OrderID + "' ", null);
            if (cursor.moveToFirst()) {
                do {
                    OrderClass order = new OrderClass();
                    order.setOrderId(cursor.getString(0));
                    order.setUserId(cursor.getString(1));
                    order.setCupcakeId(cursor.getString(2));
                    order.setQuantity(cursor.getInt(3));
                    order.setTotal(cursor.getInt(4));
                    orderList.add(order);
                }
                while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orderList;
    }

    public boolean CreateNewProduct(ProductClass productClass) {
        try {
            String supplierId = SessionManager.getUserId();
            db.execSQL("insert into SupplierProduct values('" + productClass.getProductId() + "','" + SessionManager.getUserId() + "','" +
                    productClass.getProductName() + "','" + productClass.getUnitPrice() + "','" + productClass.getQuantity() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    public boolean CreateNewFeedback(FeedbackClass feedbackClass) {
        try {
            String userId = SessionManager.getUserId();
            db.execSQL("insert into Feedback values('" + feedbackClass.getFeedbackId() + "','" + SessionManager.getUserId() + "','" + feedbackClass.getFeedbackTitle() + "')");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
    public ArrayList<CupcakeClass> SearchCupcake(String CupcakeId) {
        ArrayList<CupcakeClass> cupcakeList = new ArrayList<CupcakeClass>();
        try {
            Cursor cursor = db.rawQuery("Select * from Cupcake where CupcakeId='" +
                    CupcakeId + "' ", null);
            if (cursor.moveToFirst()) {
                do {
                    CupcakeClass cupcake = new CupcakeClass();
                    cupcake.setCupcakeId(cursor.getString(0));
                    cupcake.setCategoryId(cursor.getString(1));
                    cupcake.setCupcakeName(cursor.getString(2));
                    cupcake.setCupcakePrice(cursor.getInt(3));
                    cupcake.setDiscount(cursor.getInt(4));
                    cupcake.setQuantity(cursor.getInt(5));
                    cupcakeList.add(cupcake);
                }
                while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cupcakeList;
    }
    public void BuyProduct(String CupcakeId, int Qty)
    {
        try {

            db.execSQL("update Cupcake set Quantity=Quantity-" + Qty +
                    " where CupcakeId='" + CupcakeId + "'");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean InsertOrder(OrderClass order)
    {
        try {
            String userId = SessionManager.getUserId();
            db.execSQL("insert into Oder values('" + order.getOrderId() + "','" + SessionManager.getUserId() + "','" +
                    order.getCupcakeId() + "'," + order.getQuantity() + "," + order.getTotal() + ")");

            return true;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
}