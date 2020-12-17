package com.example.pizzabena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailOfPizza extends AppCompatActivity {
    TextView pizzaName,pizzaPrice,pizzaDetail;
    Button goBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of_pizza);
        /********************************************/
        /**************init var***********************/
        /********************************************/
        init();
        /********************************************/
        /**set detail data for one order ************/
        /********************************************/
        setText();
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailOfPizza.this,MainActivity.class));
                finish();
            }
        });

    }
    public void setText(){
        Intent intent = getIntent();
        String pizzaDetailExtra = intent.getStringExtra("pizzaDetail");
        String pizzaPriceExtra = intent.getStringExtra("pizzaPrice");
        String pizzaNameExtra = intent.getStringExtra("pizzaName");
        pizzaName.setText(pizzaNameExtra);
        pizzaPrice.setText(pizzaPriceExtra);
        pizzaDetail.setText(pizzaDetailExtra);
    }
    public void init() {
        pizzaName=findViewById(R.id.pizzaName);
        pizzaPrice=findViewById(R.id.pizzaPrice);
        pizzaDetail=findViewById(R.id.pizzaDetail);
        goBackBtn=findViewById(R.id.goBackBtn);
    }
}