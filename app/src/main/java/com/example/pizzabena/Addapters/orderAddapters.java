package com.example.pizzabena.Addapters;

import android.content.Intent;
import android.content.res.Resources;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzabena.Classes.order;
import com.example.pizzabena.DetailOfPizza;
import com.example.pizzabena.MainActivity;
import com.example.pizzabena.R;
import com.example.pizzabena.login;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class orderAddapters extends  RecyclerView.Adapter<orderAddapters.ViewHolder>
{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView NameOfOrder;
        public TextView priceOfOrder;
        public Button btnShowDetail,btnOrder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NameOfOrder = itemView.findViewById(R.id.nameOfOrder);
            priceOfOrder = itemView.findViewById(R.id.priceOfOrder);
            btnShowDetail = itemView.findViewById(R.id.showMoredetailsBtn);
            btnOrder = itemView.findViewById(R.id.placeOrderBtn);

        }

    }
    private ArrayList<order> orders;
    public orderAddapters(ArrayList<order> listOfOrders) {
        orders=listOfOrders;
    }
    @NonNull
    @Override
    public orderAddapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.oneorder,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull orderAddapters.ViewHolder holder, int position) {
        order p = orders.get(position);
        holder.NameOfOrder.setText(p.getPizzaName());
        holder.priceOfOrder.setText("Price "+p.getPizzaPrice()+" Dt");
        holder.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Sorry we are close now came back later" + p.getPizzaName(), Toast.LENGTH_LONG).show();

            }
        });
        holder.btnShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailOfPizza.class);
                intent.putExtra("pizzaDetail",p.getPizzaDescription());
                intent.putExtra("pizzaPrice",p.getPizzaPrice());
                intent.putExtra("pizzaName",p.getPizzaName());

                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}

