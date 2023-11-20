package com.example.sprinklescupcake.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sprinklescupcake.R;

public class AdminActivity extends AppCompatActivity {

    ImageView ImageSup, ImageCupcake, ImageOrder, ImageCategory;
    ImageButton AdminBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        AdminBack = (ImageButton) findViewById(R.id.btn_A_Back);


        AdminBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(AdminActivity.this,LoginActivity.class);
                startActivity(intentHome);
            }
        });

        ImageSup = (ImageView) findViewById(R.id.ivSup);


        ImageSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(AdminActivity.this,ManageSupplierActivity.class);
                startActivity(intentHome);
            }
        });
        ImageCupcake = (ImageView) findViewById(R.id.ivCup);


        ImageCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(AdminActivity.this,ManageCupcakeActivity.class);
                startActivity(intentHome);
            }
        });

        ImageOrder = (ImageView) findViewById(R.id.ivOrder);


        ImageOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(AdminActivity.this,ManageOrderActivity.class);
                startActivity(intentHome);
            }
        });

        ImageCategory = (ImageView) findViewById(R.id.ivCat);


        ImageCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(AdminActivity.this,ManageCategoryActivity.class);
                startActivity(intentHome);
            }
        });
    }
}