package com.app.falkenfoods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.falkenfoods.Required.Cart;
import com.app.falkenfoods.UserCommon.UserCommon;
import com.app.falkenfoods.ViewHolder.cartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.io.LineReader;
import com.app.falkenfoods.Required.Foods;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class cartList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView cartImage;
    private  RecyclerView.LayoutManager layoutManager;
    String getPrice="20000";
    private TextView totalPrice;
    private Button processBtn;
    private int lastTotal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        processBtn = (Button) findViewById(R.id.process_btn);
        totalPrice = (TextView) findViewById(R.id.total_price);
        cartImage = (ImageView) findViewById(R.id.cartImageView);

        processBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPrice.setText("Total price = Rs " + String.valueOf(lastTotal));

                Intent intent = new Intent(cartList.this, order.class);
                intent.putExtra("Total Amount", String.valueOf(lastTotal));
                startActivity(intent);
                finish();
            }
        });
    }

    protected  void  onStart() {
        super.onStart();

    final DatabaseReference cartListRef= FirebaseDatabase.getInstance().getReference().child("Cart Array");

        FirebaseRecyclerOptions<Cart> options =
                new FirebaseRecyclerOptions.Builder<Cart>()
                .setQuery(cartListRef.child("UserSee")
                        .child(UserCommon.ActiveUser.getPhoneNumber())
                        .child("Foods"),Cart.class)
                        .build();

        FirebaseRecyclerAdapter<Cart, cartViewHolder> adapter
                = new FirebaseRecyclerAdapter<Cart,cartViewHolder>(options){
            @Override
            protected void onBindViewHolder(@NonNull cartViewHolder holder, int spot, @NonNull final Cart required){
                holder.foodPrice.setText("Rs : " + required.getPrice());
                holder.foodName.setText(required.getFname());
                //modified

                int onTypefoodPrice = (Integer.valueOf(getPrice));
                lastTotal = lastTotal+onTypefoodPrice;

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CharSequence options[]=new CharSequence[]{
                          "Food Details",
                          "Remove"
                        };
                        final AlertDialog.Builder builder = new AlertDialog.Builder(cartList.this);
                        builder.setTitle("Cart Options: ");

                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which==0){
                                    Intent intent = new Intent(cartList.this, foodListDetailView.class);
                                    intent.putExtra("fdid",required.getFdid());
                                    startActivity(intent);
                                }

                                if(which==1){
                                    cartListRef.child("UserSee")
                                            .child(UserCommon.ActiveUser.getPhoneNumber())
                                            .child("Foods")
                                            .child(required.getFdid())
                                            .removeValue()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()){
                                                        Toast.makeText(cartList.this,"Process Done..!, Food Removed Sccuessfully.", Toast.LENGTH_SHORT).show();
                                                        Intent intent = new Intent(cartList.this,Homemenu.class);
                                                        startActivity(intent);
                                                    }
                                                }
                                            });
                                }
                            }
                        });
                        builder.show();
                    }
                });

            }
            @NonNull
            @Override
            public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_array,parent,false);
                cartViewHolder holder=new cartViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }
}