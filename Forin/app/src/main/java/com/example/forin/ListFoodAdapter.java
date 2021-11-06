package com.example.forin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFoodAdapter extends RecyclerView.Adapter<ListFoodAdapter.ListViewHolder> {
    private ArrayList<Food> listFood;

    public ListFoodAdapter(ArrayList<Food> list) {
        this.listFood = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_food, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Food food = listFood.get(position);
        holder.ivImgFood.setImageResource(food.getImgFood());
        holder.tvTitleFood.setText(food.getTitleFood());
        holder.tvDescFood.setText(food.getDescFood());
        holder.tvPriceFood.setText(food.getPriceFood());

        holder.btnMinus.setOnClickListener(v -> {
            try {
                holder.decreaseInteger();
                if (holder.total == -1) {
                    Toast.makeText(holder.itemView.getContext(), "Pesanan tidak boleh minus", Toast.LENGTH_SHORT).show();
                    holder.total = 0;
                }
                holder.display(holder.total);
                food.setFoodCount(holder.total);
            } catch (NumberFormatException e){
                System.err.println("String bukan angka");
            }
        });

        holder.btnPlus.setOnClickListener(v -> {
            try {
                holder.increaseInteger();
                if (holder.total == 11) {
                    Toast.makeText(holder.itemView.getContext(), "Hanya 20 item per pesanan", Toast.LENGTH_SHORT).show();
                    holder.total-=1;
                }
                holder.display(holder.total);
                food.setFoodCount(holder.total);
            } catch (NumberFormatException e){
                System.err.println("String bukan angka");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleFood, tvDescFood, tvPriceFood;
        ImageView ivImgFood;
        EditText edtTotal;
        Button btnPlus, btnMinus;
        int total = 0;
        static boolean isExceed;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitleFood = itemView.findViewById(R.id.tv_titleFood);
            tvDescFood = itemView.findViewById(R.id.tv_descFood);
            tvPriceFood = itemView.findViewById(R.id.tv_priceFood);
            ivImgFood = itemView.findViewById(R.id.iv_imgFood);
            edtTotal = itemView.findViewById(R.id.edt_total);
            btnMinus = itemView.findViewById(R.id.btn_min);
            btnPlus = itemView.findViewById(R.id.btn_plus);

        }

        public void increaseInteger() {
            total = setEdtTotal()+1;
        }

        public void decreaseInteger() {
            total = setEdtTotal()-1;
        }

        private void display(int number) {
            edtTotal.setText(String.valueOf(number));
        }

        public int setEdtTotal() {
            return Integer.parseInt(edtTotal.getText().toString());
        }
    }
}
