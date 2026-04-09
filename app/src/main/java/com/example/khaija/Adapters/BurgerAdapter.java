package com.example.khaija.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khaija.Detail;
import com.example.khaija.Models.BurgerRecipie;
import com.example.khaija.Models.PizzaRecipie;
import com.example.khaija.R;

import java.util.ArrayList;

public class BurgerAdapter extends RecyclerView.Adapter<BurgerAdapter.viewHolder>{

    ArrayList<BurgerRecipie> list;
    Context context;
    Intent intent;

    public BurgerAdapter(ArrayList<BurgerRecipie> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.burger_recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.foodImage.setImageResource(list.get(position).getImg());
        holder.foodName.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());
        holder.description.setText(list.get(position).getDescription());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(context, Detail.class);
                intent.putExtra("image",list.get(position).getImg());
                intent.putExtra("price",list.get(position).getPrice());
                intent.putExtra("desc",list.get(position).getDescription());
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodName,price,description;
        LinearLayout linearLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.image);
            foodName = itemView.findViewById(R.id.foodName);
            price = itemView.findViewById(R.id.orderPrice);
            description = itemView.findViewById(R.id.description);
            linearLayout = itemView.findViewById(R.id.parent_Layout_RecyclerView);
        }
    }
}
