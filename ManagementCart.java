package com.example.fooddeliveryapp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.fooddeliveryapp.Domain.FoodDomain;
import com.example.fooddeliveryapp.Interfaces.ChangeItemNumber;


import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listFood.get(n).setCartNr(item.getCartNr());
        } else {
            listFood.add(item);
        }

        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeItemNumber changeNumberItemsListener) {
        if (listfood.get(position).getCartNr() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setCartNr(listfood.get(position).getCartNr() - 1);
        }
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeItemNumber changeNumberItemsListener) {
        listfood.get(position).setCartNr(listfood.get(position).getCartNr() + 1);
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<FoodDomain> listfood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getFee() * listfood2.get(i).getCartNr());
        }
        return fee;
    }
}
