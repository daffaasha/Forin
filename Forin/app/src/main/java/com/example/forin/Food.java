package com.example.forin;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private int imgFood;
    private String titleFood;
    private String descFood;
    private String priceFood;
    private int foodCount;

    protected Food(Parcel in) {
        imgFood = in.readInt();
        titleFood = in.readString();
        descFood = in.readString();
        priceFood = in.readString();
        foodCount = in.readInt();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public Food() {

    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }

    public String getTitleFood() {
        return titleFood;
    }

    public void setTitleFood(String titleFood) {
        this.titleFood = titleFood;
    }

    public String getDescFood() {
        return descFood;
    }

    public void setDescFood(String descFood) {
        this.descFood = descFood;
    }

    public String getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(String priceFood) {
        this.priceFood = priceFood;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imgFood);
        dest.writeString(titleFood);
        dest.writeString(descFood);
        dest.writeString(priceFood);
        dest.writeInt(foodCount);
    }
}
