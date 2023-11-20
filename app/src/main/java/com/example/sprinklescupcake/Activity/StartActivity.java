package com.example.sprinklescupcake.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sprinklescupcake.R;

public class StartActivity extends AppCompatActivity {
    Button ButtonLogin,ButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ButtonLogin=(Button) findViewById(R.id.btn_Login);
        ButtonRegister=(Button) findViewById(R.id.btn_Register);

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
            }
        });

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intentRegister);
            }
        });
    }
}