package com.example.sprinklescupcake.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sprinklescupcake.R;

public class MainActivity extends AppCompatActivity {
    Button ButtonLetsGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButtonLetsGo = (Button) findViewById(R.id.btn_Lets_Go);


        ButtonLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intentRegister);
            }
    });
}
}

