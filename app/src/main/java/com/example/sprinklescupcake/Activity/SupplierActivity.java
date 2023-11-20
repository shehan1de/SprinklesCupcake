package com.example.sprinklescupcake.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sprinklescupcake.Adapters.CupcakeClass;
import com.example.sprinklescupcake.Adapters.ProductClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

public class SupplierActivity extends AppCompatActivity {
ImageButton ButtonBack;
Button ButtonAddProduct;
EditText EditTextProductId, EditTextProductName,EditTextQuantity, EditTextUnitPrice;
private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextProductId=(EditText) findViewById(R.id.txt_Pro_Id);
        EditTextProductName=(EditText) findViewById(R.id.txt_Pro_Name);
        EditTextQuantity=(EditText) findViewById(R.id.txt_Pro_Quantity);
        EditTextUnitPrice=(EditText) findViewById(R.id.txt_pro_Price);
        ButtonBack=(ImageButton) findViewById(R.id.btn_Pro_Back);
        ButtonAddProduct=(Button) findViewById(R.id.btn_Pro_Add);
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(SupplierActivity.this, LoginActivity.class);
                startActivity(intentLogin);
            }

        });

        ButtonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productId = EditTextProductId.getText().toString();
                String productName = EditTextProductName.getText().toString();
                String TextQuantity = EditTextQuantity.getText().toString();
                String TextUnitPrice = EditTextUnitPrice.getText().toString();

                if (productId.isEmpty() || productName.isEmpty() || TextQuantity.isEmpty() ||
                        TextUnitPrice.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be Empty!!", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        int quantity = Integer.parseInt(TextQuantity);
                        int unitPrice = Integer.parseInt(TextUnitPrice);

                        ProductClass productClass = new ProductClass(productId, productName, quantity, unitPrice);

                        if (dbHelper.CreateNewProduct(productClass)) {
                            Toast.makeText(getApplicationContext(), "Product created", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Product Creation Failed", Toast.LENGTH_LONG).show();
                        }
                    } catch (NumberFormatException e) {

                        Toast.makeText(getApplicationContext(), "Invalid input .", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        }
}
