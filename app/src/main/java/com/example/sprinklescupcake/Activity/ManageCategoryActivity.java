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
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

public class ManageCategoryActivity extends AppCompatActivity {
    ImageButton ButtonBack;
    EditText EditTextCategoryId,EditTextCategoryName,EditTextDeleteCategoryId;
    Button ButtonCategoryAdd, ButtonCategoryDelete;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_category);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();
        EditTextCategoryId=(EditText) findViewById(R.id.txt_Cat_Id);
        EditTextCategoryName=(EditText) findViewById(R.id.txt_Cat_CatId);
        EditTextDeleteCategoryId=(EditText) findViewById(R.id.txt_DelCat_id);
        ButtonBack=(ImageButton) findViewById(R.id.btn_Cat_Back);
        ButtonCategoryAdd=(Button) findViewById(R.id.btn_Cat_Add);
        ButtonCategoryDelete=(Button) findViewById(R.id.btn_DelCat_Delete);

        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(ManageCategoryActivity.this, AdminActivity.class);
                startActivity(intentLogin);
            }
        });

        ButtonCategoryAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EditTextCategoryId.getText().toString().isEmpty() || EditTextCategoryName.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be Empty!!", Toast.LENGTH_LONG).show();
                } else {
                    CategoryClass categoryClass = new CategoryClass(EditTextCategoryId.getText().toString(),
                            EditTextCategoryName.getText().toString());

                    if (dbHelper.CreateNewCategory(categoryClass)) {
                        Toast.makeText(getApplicationContext(), "Category created", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Category Creation Failed", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        ButtonCategoryDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoryId = EditTextDeleteCategoryId.getText().toString();


                if (!categoryId.isEmpty()) {
                    boolean deletionSuccessful = dbHelper.CategoryDelete(categoryId);

                    if (deletionSuccessful) {
                        Toast.makeText(getApplicationContext(), "Category Deletion successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Category Deletion failed", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a Category ID", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}