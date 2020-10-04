package com.app.falkenfoods.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.falkenfoods.ClickListner.ItemClickListner;
import com.app.falkenfoods.R;

public class cartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView foodName, foodPrice, cartImag;
    private ItemClickListner listner;

    public cartViewHolder(@NonNull View foodView){
        super(foodView);

        foodName=foodView.findViewById(R.id.cart_array_name);
        foodPrice=foodView.findViewById(R.id.cart_array_price);
        //cartImag = foodView.findViewById(R.id.cartImageView);
    }

    @Override
    public void onClick(View view) {
        listner.onClick(view,getAdapterPosition(), false);
    }

    public void setListner(ItemClickListner listner){
        this.listner=listner;
    }
}
