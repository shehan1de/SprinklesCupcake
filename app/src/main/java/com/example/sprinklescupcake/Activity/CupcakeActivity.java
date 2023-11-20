package com.example.sprinklescupcake.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sprinklescupcake.R;

public class CupcakeActivity extends AppCompatActivity {

    Button ButtonByProduct;
    ImageButton ButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcake);

        ButtonBack=(ImageButton) findViewById(R.id.btn_C_Back);
        ButtonByProduct=(Button) findViewById(R.id.btn_C_Buy);


        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(CupcakeActivity.this, UserActivity.class);
                startActivity(intentLogin);
            }
        });

        ButtonByProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(CupcakeActivity.this, BuyActivity.class);
                startActivity(intentLogin);

            }
        });
    }
}