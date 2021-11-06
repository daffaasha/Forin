package com.example.forin;

import java.util.ArrayList;

public class FoodData {
    private static String[] titleFood = {
            "Sate Madura",
            "Rendang Minang",
            "Gado-Gado",
            "Pempek Palembang",
            "Nasi Goreng",
            "Bakso"
    };

    private static String[] descFood = {
            "Masakan khas Indonesia dengan daging ayam premium serta rempah-rempah pilihan",
            "Masakan khas Indonesia dengan sapi berkualitas serta rempah-rempah pilihan",
            "Masakan khas Indonesia dengan sayur serta sambal kacang dan teman-temannya",
            "Masakan khas Indonesia dengan daging ikan belida serta rempah-rempah pilihan",
            "Masakan khas Indonesia dengan bumbu pilihan khas Indonesia",
            "Gumpalan daging yang kenyal dengan cita rasa yang menakjubkan bersama dengan kuah gurih"
    };

    private static String[] priceFood = {
            "24.000",
            "24.000",
            "17.000",
            "15.000",
            "24.000",
            "24.000"
    };

    private static int[] foodCount = {
            0,
            0,
            0,
            0,
            0,
            0
    };

    private static int[] imgFood = {
        R.drawable.sate_madura,
            R.drawable.rendang_minang,
            R.drawable.gado_gado,
            R.drawable.pempek_palembang,
            R.drawable.nasi_goreng,
            R.drawable.bakso
    };

    static ArrayList<Food> getListData(){
        ArrayList<Food> list = new ArrayList<>();
        for (int position = 0; position < titleFood.length; position++) {
            Food food = new Food();
            food.setTitleFood(titleFood[position]);
            food.setDescFood(descFood[position]);
            food.setPriceFood(priceFood[position]);
            food.setImgFood(imgFood[position]);
            list.add(food);
        }
        return list;
    };
}
