package com.example.fooddeliveryapp.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddeliveryapp.Domain.CategoryDomain;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains){
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.category_name.setText(categoryDomains.get(position).getTitle());
    String picUrl = "";
    switch (position){
        case 0: {
            picUrl = "pimzza";
            break;
        }
        case 1: {
            picUrl = "borgar";
            break;
        }
        case 2: {
            picUrl = "shaorma";
            break;
        }
        case 3: {
            picUrl = "ramen";
            break;
        }
    }
    int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
    Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.category_pic);
    }
    @Override
    public int getItemCount() {return categoryDomains.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView category_name;
        ImageView category_pic;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View foodView){
            super(foodView);
            category_name= itemView.findViewById(R.id.MealTitle);
            category_pic= itemView.findViewById(R.id.CategoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }

}