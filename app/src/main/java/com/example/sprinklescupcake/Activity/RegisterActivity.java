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

import com.example.sprinklescupcake.Adapters.UserClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

public class RegisterActivity extends AppCompatActivity {
    EditText EditTextUserId, EditTextUserName, EditTextPassword, EditTextConfirmPassword;
    Button ButtonRegister,ButtonLogin;
    ImageButton ButtonBack;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextUserId = (EditText) findViewById(R.id.txt_L_UserId);
        EditTextUserName = (EditText) findViewById(R.id.txt_R_UserName);
        EditTextPassword = (EditText) findViewById(R.id.txt_L_Password);
        EditTextConfirmPassword = (EditText) findViewById(R.id.txt_R_ConfirmPassword);
        ButtonRegister = (Button) findViewById(R.id.btn_L_Login);
        ButtonBack = (ImageButton) findViewById(R.id.btn_Cup_Back);
        ButtonLogin = (Button) findViewById(R.id.btn_L_Register);

        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(RegisterActivity.this, StartActivity.class);
                startActivity(intentLogin);
            }
        });

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EditTextUserId.getText().toString().isEmpty() || EditTextUserName.getText().toString().isEmpty() ||
                        EditTextPassword.getText().toString().isEmpty() || EditTextConfirmPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be Empty!!", Toast.LENGTH_LONG).show();
                } else if (EditTextPassword.getText().toString().length() < 5) {
                    Toast.makeText(getApplicationContext(), "Password must have more than 5 characters", Toast.LENGTH_LONG).show();

                } else if (!EditTextPassword.getText().toString().equals(EditTextConfirmPassword.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Password and confirm password should match", Toast.LENGTH_LONG).show();
                } else {
                    UserClass userClass = new UserClass(EditTextUserId.getText().toString(), EditTextUserName.getText().toString(),
                            EditTextPassword.getText().toString());

                    if (dbHelper.CreateNewUser(userClass)) {
                        Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(),
                                EditTextUserId.getText().toString() + "has login as User", Toast.LENGTH_LONG).show();
                        Intent intentUser = new Intent(RegisterActivity.this, UserActivity.class);
                        startActivity(intentUser);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "User Creation Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
