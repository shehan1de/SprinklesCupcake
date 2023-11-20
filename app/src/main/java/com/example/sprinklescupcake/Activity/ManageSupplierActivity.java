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

import com.example.sprinklescupcake.Adapters.SupplierClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;
public class ManageSupplierActivity extends AppCompatActivity {
    EditText EditTextSupplierId,EditTextSupplierName,EditTextSupplierPassword;
    EditText EditTextDeleteSupplierId;
    ImageButton ButtonSupplierBack;
    Button ButtonSupplierRegister, ButtonSupplierDelete;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_supplier);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextSupplierId = (EditText) findViewById(R.id.txt_Cat_Id);
        EditTextSupplierName = (EditText) findViewById(R.id.txt_Cat_CatId);
        EditTextSupplierPassword = (EditText) findViewById(R.id.txt_Sup_Password);
        EditTextDeleteSupplierId = (EditText) findViewById(R.id.txt_DelCat_id);
        ButtonSupplierBack = (ImageButton) findViewById(R.id.btn_Cup_Back);
        ButtonSupplierRegister = (Button) findViewById(R.id.btn_Cat_Add);
        ButtonSupplierDelete = (Button) findViewById(R.id.btn_DelCat_Delete);

        ButtonSupplierBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(ManageSupplierActivity.this, AdminActivity.class);
                startActivity(intentLogin);
            }
        });
        ButtonSupplierRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EditTextSupplierId.getText().toString().isEmpty() || EditTextSupplierName.getText().toString().isEmpty() ||
                        EditTextSupplierPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be Empty!!", Toast.LENGTH_LONG).show();
                } else {
                    SupplierClass supplierClass = new SupplierClass(EditTextSupplierId.getText().toString(),
                            EditTextSupplierName.getText().toString(), EditTextSupplierPassword.getText().toString());

                    if (dbHelper.CreateNewSupplier(supplierClass)) {
                        Toast.makeText(getApplicationContext(), "Supplier created", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Supplier Creation Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ButtonSupplierDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String supplierId = EditTextDeleteSupplierId.getText().toString();


                if (!supplierId.isEmpty()) {
                    boolean deletionSuccessful = dbHelper.SupplierDelete(supplierId);

                    if (deletionSuccessful) {
                        Toast.makeText(getApplicationContext(), "Supplier Deletion successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Supplier Deletion failed", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a Supplier ID", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    }

