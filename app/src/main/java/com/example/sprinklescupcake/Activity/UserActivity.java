package com.example.sprinklescupcake.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sprinklescupcake.Adapters.CategoryClass;
import com.example.sprinklescupcake.Adapters.FeedbackClass;
import com.example.sprinklescupcake.Adapters.UserClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

public class UserActivity extends AppCompatActivity {

    CardView CardViewOreo,CardViewCreamy, CardViewCherry,CardViewSeason;
    ImageButton ButtonBack;
    ImageView ImageProfile;

    Button ButtonSubmit;
    EditText EditTextFeedbackTitle;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        ButtonBack = (ImageButton) findViewById(R.id.btn_U_Back);
        ImageProfile = (ImageView) findViewById(R.id.ivProfile);

        CardViewOreo = (CardView) findViewById(R.id.cdOreo);
        CardViewCreamy = (CardView) findViewById(R.id.cdCreamy);
        CardViewCherry = (CardView) findViewById(R.id.cdCherry);
        CardViewSeason = (CardView) findViewById(R.id.cdSeason);

        EditTextFeedbackTitle = (EditText) findViewById(R.id.txt_U_Feedback);
        ButtonSubmit = (Button) findViewById(R.id.btn_U_Submit);

        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(intentHome);
            }
        });
        ImageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(UserActivity.this, ProfileActivity.class);
                startActivity(intentHome);
            }
        });
        CardViewOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(UserActivity.this, CupcakeActivity.class);
                startActivity(intentHome);
            }
        });

        CardViewCreamy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(UserActivity.this, CupcakeActivity.class);
                startActivity(intentHome);
            }
        });

        CardViewCherry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(UserActivity.this, CupcakeActivity.class);
                startActivity(intentHome);
            }
        });

        CardViewSeason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(UserActivity.this, CupcakeActivity.class);
                startActivity(intentHome);
            }
        });

        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FeedbackTitle = EditTextFeedbackTitle.getText().toString();

                if (FeedbackTitle.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Feedback cannot be empty!", Toast.LENGTH_LONG).show();
                } else {

                    FeedbackClass feedbackClass = new FeedbackClass(FeedbackTitle);


                    if (dbHelper.CreateNewFeedback(feedbackClass)) {
                        Toast.makeText(getApplicationContext(), "Feedback created", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Feedback Submission Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        }
    }
