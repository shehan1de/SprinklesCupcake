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

import com.example.sprinklescupcake.Adapters.AdminClass;
import com.example.sprinklescupcake.Adapters.SessionManager;
import com.example.sprinklescupcake.Adapters.SupplierClass;
import com.example.sprinklescupcake.Adapters.UserClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText EditTextUserId, EditTextPassword;
    Button ButtonLogin, ButtonRegister;
    ImageButton ButtonBack;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextUserId = (EditText) findViewById(R.id.txt_L_UserId);
        EditTextPassword = (EditText) findViewById(R.id.txt_L_Password);
        ButtonLogin = (Button) findViewById(R.id.btn_L_Login);
        ButtonRegister = (Button) findViewById(R.id.btn_L_Register);
        ButtonBack = (ImageButton) findViewById(R.id.btn_Cup_Back);

        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intentLogin);
            }
        });

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentLogin);
            }
        });
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<UserClass> userLogin = dbHelper.UserValidLogin(EditTextUserId.getText().toString(),
                        EditTextPassword.getText().toString());
                ArrayList<AdminClass> adminLogin = dbHelper.AdminValidLogin(EditTextUserId.getText().toString(),
                        EditTextPassword.getText().toString());
                ArrayList<SupplierClass> supplierLogin = dbHelper.SupplierValidLogin(EditTextUserId.getText().toString(),
                        EditTextPassword.getText().toString());

                if (!userLogin.isEmpty()) {

                    String userId = userLogin.get(0).getUserId();
                    SessionManager sessionManager = new SessionManager(LoginActivity.this);
                    sessionManager.setLoggedInUser("User", userId);

                    Toast.makeText(getApplicationContext(), "User login successful", Toast.LENGTH_LONG).show();
                    Intent intentUser = new Intent(LoginActivity.this, UserActivity.class);
                    startActivity(intentUser);
                }
                else if (!adminLogin.isEmpty()) {

                    String adminId = adminLogin.get(0).getAdminId();
                    SessionManager sessionManager = new SessionManager(LoginActivity.this);
                    sessionManager.setLoggedInUser("Admin", adminId);

                    Toast.makeText(getApplicationContext(), "Admin login successful", Toast.LENGTH_LONG).show();
                    Intent intentAdmin = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(intentAdmin);
                } else if (!supplierLogin.isEmpty()) {

                    String supplierId = supplierLogin.get(0).getSupplierId();
                    SessionManager sessionManager = new SessionManager(LoginActivity.this);
                    sessionManager.setLoggedInUser("Supplier", supplierId);

                    Toast.makeText(getApplicationContext(), "Supplier login successful", Toast.LENGTH_LONG).show();
                    Intent intentSupplier = new Intent(LoginActivity.this, SupplierActivity.class);
                    startActivity(intentSupplier);
                } else {

                    Toast.makeText(getApplicationContext(), "Invalid login", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
