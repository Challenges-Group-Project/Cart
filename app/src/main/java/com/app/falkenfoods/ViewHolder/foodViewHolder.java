package com.app.falkenfoods.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.falkenfoods.ClickListner.ItemClickListner;
import com.app.falkenfoods.R;

public class foodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView FoodNameTxt, FoodDescriptionTxt, FoodPriceTxt;
    public ImageView foodImageView;
    public ItemClickListner itemClickListner;

    public foodViewHolder(@NonNull View itemView) {
        super(itemView);

        foodImageView = itemView.findViewById(R.id.foodListImage);
        FoodNameTxt = itemView.findViewById(R.id.foodListName);
        FoodDescriptionTxt = itemView.findViewById(R.id.foodListDescription);
        FoodPriceTxt = itemView.findViewById(R.id.foodListPrice);

    }

    public void setItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner = itemClickListner;
    }



    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view, getAdapterPosition(), false);
    }
}