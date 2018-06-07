package com.example.carlos.tupedido.Model;

import java.util.List;

public class Dishes {
    private String name;
    private String picture;
    private List ingredients;
    private String cook_time;
    private int price;

    public Dishes(String name, String picture, List ingredients, String cook_time, int price) {
        this.name = name;
        this.picture = picture;
        this.ingredients = ingredients;
        this.cook_time = cook_time;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List getIngredients() {
        return ingredients;
    }

    public void setIngredients(List ingredients) {
        this.ingredients = ingredients;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setCook_time(String cook_time) {
        this.cook_time = cook_time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return "{type\":\"object\"," +
                "\"properties\":{" +
                "\"name\":\"" + name + '\"' +
                ", \"picture\":\"" + picture + '\"' +
                ", \"ingredients\":\"" + ingredients + '\"' +
                ", \"cook_time\":\"" + cook_time + '\"' +
                ", \"price\":" + price +
                '}'+'}';
    }
}
