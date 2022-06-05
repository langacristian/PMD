package com.example.fooddeliveryapp.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddeliveryapp.Activity.ShowDetailActivity;
import com.example.fooddeliveryapp.Domain.FoodDomain;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    ArrayList<FoodDomain> foodDomains;

    public FoodAdapter(ArrayList<FoodDomain> foodDomains){
        this.foodDomains = foodDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_food,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.title.setText(foodDomains.get(position).getTitle());
    holder.fee.setText(String.valueOf(foodDomains.get(position).getFee()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.foodpic);

        holder.Add.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object", foodDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }
    @Override
    public int getItemCount() {return foodDomains.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,fee;
        ImageView foodpic;
        ImageView Add;
        ConstraintLayout FoodLayout;
        public ViewHolder(@NonNull View foodView){
            super(foodView);
            title = itemView.findViewById(R.id.MealTitle);
            foodpic = itemView.findViewById(R.id.pic);
            FoodLayout = itemView.findViewById(R.id.FoodLayout);
            Add = itemView.findViewById(R.id.AddBtn);
            fee = itemView.findViewById(R.id.fee);
        }

    }

}