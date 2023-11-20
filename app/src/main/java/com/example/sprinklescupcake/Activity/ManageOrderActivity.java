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

import com.example.sprinklescupcake.Adapters.OrderClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

import java.util.ArrayList;
public class ManageOrderActivity extends AppCompatActivity {
    ImageButton ButtonOrderBack;
    Button ButtonView;
    EditText EditTextOrderId, EditTextUserId, EditTextCupcakeId, EditTextQuantity, EditTextTotal;
private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_order);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextOrderId=(EditText) findViewById(R.id.txt_O_Id);
        EditTextUserId=(EditText) findViewById(R.id.txt_O_UserId);
        EditTextCupcakeId=(EditText) findViewById(R.id.txt_O_CupId);
        EditTextQuantity=(EditText) findViewById(R.id.txt_O_Quantity);
        EditTextTotal=(EditText) findViewById(R.id.txt_O_Total);
        ButtonOrderBack=(ImageButton) findViewById(R.id.btn_O_Back);
        ButtonView=(Button) findViewById(R.id.btn_O_View);
        ButtonOrderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(ManageOrderActivity.this, AdminActivity.class);
                startActivity(intentLogin);
            }
        });

        ButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pid=EditTextOrderId.getText().toString();
                ArrayList<OrderClass> orderList=dbHelper.SearchOrder(Pid);
                if (orderList.size()!=0)
                {
                    OrderClass order=orderList.get(0);
                    EditTextUserId.setText(order.getUserId());
                    EditTextCupcakeId.setText(order.getCupcakeId());
                    EditTextQuantity.setText(String.valueOf(order.getQuantity()));
                    EditTextTotal.setText(String.valueOf(order.getTotal()));
                    Toast.makeText(getApplicationContext(), "Order Found", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Order Not Found", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}


