package com.example.forin;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderFoodAdapter extends RecyclerView.Adapter<OrderFoodAdapter.ListViewHolder> {
    private ArrayList<Food> foodArrayList;

    public OrderFoodAdapter(ArrayList<Food> list) {
        this.foodArrayList = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_order, parent, false);
        return new ListViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Food food = foodArrayList.get(position);
        holder.tvFoodCount.setText(String.valueOf(food.getFoodCount()));
        holder.tvFoodTitle.setText(food.getTitleFood());
        holder.tvFoodPrice.setText(String.valueOf(food.getFoodCount() * Float.parseFloat(food.getPriceFood()))+"00");
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvFoodCount, tvFoodTitle, tvFoodPrice;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFoodPrice = itemView.findViewById(R.id.tv_priceFood);
            tvFoodTitle = itemView.findViewById(R.id.tv_titleFood);
            tvFoodCount = itemView.findViewById(R.id.tv_countFood);

        }
    }
}
