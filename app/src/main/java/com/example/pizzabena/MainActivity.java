package com.example.pizzabena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pizzabena.Addapters.orderAddapters;
import com.example.pizzabena.Classes.order;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<order> orderArray= new ArrayList<>();
    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    private RecyclerView.Adapter RecyclerViewAdap;
    private RecyclerView.LayoutManager RecyclerViewLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /********************************************/
        /**************init pizzas Array*************/
        /********************************************/
        initArray();
        /********************************************/
        /**init recyleview with array of pizzas******/
        /********************************************/
        initRecView();
    }
    public void initRecView(){
        RecyclerView = findViewById(R.id.recViewContainer);
        RecyclerViewLayoutManager = new LinearLayoutManager(this);
        RecyclerViewAdap= new orderAddapters(orderArray);
        RecyclerView.setLayoutManager(RecyclerViewLayoutManager);
        RecyclerView.setAdapter(RecyclerViewAdap);
        RecyclerView.addItemDecoration(new DividerItemDecoration(RecyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }
    public  void initArray(){
        orderArray.add(new order("Neapolitan Pizza","Neapolitan is the original pizza. This delicious pie dates all the way back to 18th century in Naples, Italy. During this time, the poorer citizens of this seaside city frequently purchased food that was cheap and could be eaten quickly. Luckily for them ", "15.3"));
        orderArray.add(new order("Chicago Pizza","Chicago pizza, also commonly referred to as deep-dish pizza, gets its name from the city it was invented in. During the early 1900’s, Italian immigrants in the windy city were searching for something similar to the Neapolitan pizza that they knew and loved. Instead of imitating the notoriously thin pie, Ike Sewell had something else in mind ", "9.3"));
        orderArray.add(new order("New York-Style","With its characteristic large, foldable slices and crispy outer crust, New York-style pizza is one of America’s most famous regional pizza types. Originally a variation of Neapolitan-style pizzagzegez egze zergzeg zerg zg ", "10.3"));
        orderArray.add(new order("Sicilian Pizza","Sicilian pizza, also known as \"sfincione,\" provides a thick cut of pizza with pillowy dough, a crunchy crust, and robust tomato sauce. This square-cut pizza is served with or without cheese ", "20.3"));
        orderArray.add(new order("Greek Pizza","Greek pizza was created by Greek immigrants who came to America and were introduced to Italian pizza. Greek-style pizza, especially popular in the New England stat ", "24.3"));
        orderArray.add(new order("Greek Pizza Traditional","California pizza, or gourmet pizza, is known for its unusual ingredients. This pizza got its start back in the late 1970’s when Chef Ed LaDou began experimenting with pizza recipes in the classic Italian restaurant ", "30.3"));
    }
}