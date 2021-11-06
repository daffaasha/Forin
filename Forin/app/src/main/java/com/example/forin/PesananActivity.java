package com.example.forin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PesananActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM = "extra_item";
    private RecyclerView rvOrder;
    private ArrayList<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        rvOrder = findViewById(R.id.rv_orders);
        rvOrder.setHasFixedSize(true);

        foodList.addAll(getIntent().getParcelableArrayListExtra(EXTRA_ITEM));
        showOrderList();
    }

    private void showOrderList() {
        rvOrder.setLayoutManager(new LinearLayoutManager(this));
        OrderFoodAdapter orderFoodAdapter = new OrderFoodAdapter(foodList);
        rvOrder.setAdapter(orderFoodAdapter);
    }
}