package com.example.fooddeliveryapp.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private String pic;
    private String desc;
    private Double fee;
    private int rating;
    private int weight;

    public int getCartNr() {
        return cartNr;
    }

    public void setCartNr(int cartNr) {
        this.cartNr = cartNr;
    }

    private int cartNr;

    public FoodDomain(String title, String pic, String desc, Double fee, int rating, int weight) {
        this.title = title;
        this.pic = pic;
        this.desc = desc;
        this.fee = fee;
        this.rating = rating;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
