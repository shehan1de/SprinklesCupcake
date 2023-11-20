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

import com.example.sprinklescupcake.Adapters.CategoryClass;
import com.example.sprinklescupcake.Adapters.CupcakeClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

public class ManageCupcakeActivity extends AppCompatActivity {
    ImageButton ButtonBack;

    EditText EditTextCupcakeId,EditTextCategoryId,EditTextCupcakeName,EditTextCupcakePrice,
            EditTextDiscount,EditTextQuantity,EditTextDeleteCupcakeId;
    Button ButtonCupcakeAdd, ButtonCupcakeDelete;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_cupcake);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextCupcakeId=(EditText) findViewById(R.id.txt_Cup_Id);
        EditTextCategoryId=(EditText) findViewById(R.id.txt_Cup_CatId);
        EditTextCupcakeName=(EditText) findViewById(R.id.txt_Cup_Name);
        EditTextCupcakePrice=(EditText) findViewById(R.id.txt_Cup_Price);
        EditTextDiscount=(EditText) findViewById(R.id.txt_Cup_Discount);
        EditTextQuantity=(EditText) findViewById(R.id.txt_Cup_Quantity);
        EditTextDeleteCupcakeId=(EditText) findViewById(R.id.txt_DelCup_Id);
        ButtonBack=(ImageButton)  findViewById(R.id.btn_Cup_Back);
        ButtonCupcakeAdd=(Button) findViewById(R.id.btn_Cup_Add);
        ButtonCupcakeDelete=(Button) findViewById(R.id.btn_DelCup_Delete);

        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(ManageCupcakeActivity.this, AdminActivity.class);
                startActivity(intentLogin);
            }
        });

        ButtonCupcakeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cupcakeId = EditTextCupcakeId.getText().toString();
                String categoryId = EditTextCategoryId.getText().toString();
                String cupcakeName = EditTextCupcakeName.getText().toString();
                String priceText = EditTextCupcakePrice.getText().toString();
                String discountText = EditTextDiscount.getText().toString();
                String quantityText = EditTextQuantity.getText().toString();

                if (cupcakeId.isEmpty() || categoryId.isEmpty() || cupcakeName.isEmpty() ||
                        priceText.isEmpty() || discountText.isEmpty() || quantityText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be Empty!!", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        int price = Integer.parseInt(priceText);
                        int discount = Integer.parseInt(discountText);
                        int quantity = Integer.parseInt(quantityText);

                        CupcakeClass cupcakeClass = new CupcakeClass(cupcakeId, categoryId, cupcakeName, price, discount, quantity);

                        if (dbHelper.CreateNewCupcake(cupcakeClass)) {
                            Toast.makeText(getApplicationContext(), "Cupcake created", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Cupcake Creation Failed", Toast.LENGTH_LONG).show();
                        }
                    } catch (NumberFormatException e) {

                        Toast.makeText(getApplicationContext(), "Invalid input for price, discount, or quantity.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ButtonCupcakeDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cupcakeId = EditTextDeleteCupcakeId.getText().toString();


                if (!cupcakeId.isEmpty()) {
                    boolean deletionSuccessful = dbHelper.CupcakeDelete(cupcakeId);

                    if (deletionSuccessful) {
                        Toast.makeText(getApplicationContext(), "Cupcake Deletion successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Cupcake Deletion failed", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a Cupcake ID", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}