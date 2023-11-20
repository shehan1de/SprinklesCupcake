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

import com.example.sprinklescupcake.Adapters.CupcakeClass;
import com.example.sprinklescupcake.Adapters.OrderClass;
import com.example.sprinklescupcake.DBClass.DBHelper;
import com.example.sprinklescupcake.R;

import java.util.ArrayList;

public class BuyActivity extends AppCompatActivity {
ImageButton ButtonBack;
EditText EditTextCupcakeId, EditTextCategory, EditTextCupcakeName, EditTextPrice, EditTextDiscount, EditTextQuantity, EditTextOrderId,
        EditTextBuyQuantity;
Button ButtonSearch, ButtonBuy;
private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextCupcakeId=(EditText) findViewById(R.id.txt_S_Id);
        EditTextCategory=(EditText) findViewById(R.id.txt_S_Category);
        EditTextPrice=(EditText) findViewById(R.id.txt_S_Price);
        EditTextDiscount=(EditText) findViewById(R.id.txt_S_Discount);
        EditTextCupcakeName=(EditText) findViewById(R.id.txt_S_CupName);
        EditTextQuantity=(EditText) findViewById(R.id.txt_S_Quantity);
        EditTextOrderId=(EditText) findViewById(R.id.txt_B_OrderId);
        EditTextBuyQuantity=(EditText) findViewById(R.id.txt_B_Quantity);
        ButtonBack=(ImageButton) findViewById(R.id.btn_B_Back);
        ButtonSearch=(Button) findViewById(R.id.btn_S_Search);
        ButtonBuy=(Button) findViewById(R.id.btn_B_Buy);


        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(BuyActivity.this, CupcakeActivity.class);
                startActivity(intentLogin);
            }
        });
ButtonSearch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String Pid=EditTextCupcakeId.getText().toString();
        ArrayList<CupcakeClass> cupcakeList=dbHelper.SearchCupcake(Pid);
        if (cupcakeList.size()!=0)
        {
            CupcakeClass cupcake=cupcakeList.get(0);
            EditTextCupcakeName.setText(cupcake.getCupcakeName());
            EditTextCategory.setText(cupcake.getCategoryId());
            EditTextPrice.setText(String.valueOf(cupcake.getCupcakePrice()));
            EditTextDiscount.setText(String.valueOf(cupcake.getDiscount()));
            EditTextQuantity.setText(String.valueOf(cupcake.getQuantity()));
            Toast.makeText(getApplicationContext(), "Cupcake Found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No Cupcake found", Toast.LENGTH_SHORT).show();
        }
    }

});
ButtonBuy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dbHelper.BuyProduct(EditTextOrderId.getText().toString(),
                Integer.parseInt(EditTextBuyQuantity.getText().toString()));

        int Total=Integer.parseInt(EditTextBuyQuantity.getText().toString())* Integer.parseInt(EditTextPrice.getText().toString());

        int quantity=Integer.parseInt(EditTextBuyQuantity.getText().toString());

        OrderClass order=new OrderClass(EditTextOrderId.getText().toString(), EditTextCupcakeId.getText().toString(),quantity,Total);
        if (dbHelper.InsertOrder(order))
        {
            Toast.makeText(getApplicationContext(), "Buy:"+EditTextCupcakeId.getText().toString()+"Total"+Total,
                    Toast.LENGTH_LONG).show();
        }
    }
});;
    }
}