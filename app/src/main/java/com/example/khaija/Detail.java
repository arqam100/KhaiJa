package com.example.khaija;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.DBHelper;
import com.example.khaija.databinding.ActivityDetailBinding;

public class Detail extends AppCompatActivity {


    ActivityDetailBinding binding;
//    int foodimage;
//    String foodname,foodprice,fooddescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        try {
//            foodimage = getIntent().getIntExtra("image", 0);
//            foodname =  getIntent().getStringExtra("name");
//            foodprice = getIntent().getStringExtra("price");
//            fooddescription = getIntent().getStringExtra("desc");
//
//            Toast.makeText(this, foodname + " " + foodprice, Toast.LENGTH_SHORT).show();
//        } catch (NullPointerException e) {
//            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//        }
        final DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLabel.setText(String.format("%d", price));
            binding.detailName.setText(name);
            binding.detailDescription.setText(description);


            binding.orderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(Detail.this, "Data Inserted...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Detail.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLabel.setText(String.format("%d", cursor.getInt(3)));
            binding.detailName.setText(cursor.getString(7));
            binding.detailDescription.setText(cursor.getString(6));


            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));

            binding.orderBtn.setText("Update Now");
            binding.orderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
              Boolean isUpdated = helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLabel.getText().toString()),
                            image,
                            binding.detailName.getText().toString(),
                            binding.detailDescription.getText().toString(),
                            1,
                            id
                            );
              if (isUpdated)
              {
                  Toast.makeText(Detail.this, "Order Updated", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(Detail.this, "Failed!", Toast.LENGTH_SHORT).show();
              }
                }
            });
        }

    }
}