package com.example.carlos.tupedido.Model;

import java.util.ArrayList;


public class Orders {

    private String name;
    private String device;
    private ArrayList<String> dishes;
    private ArrayList<String> dishesquantity;
    private ArrayList<String> drinksquantity;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public ArrayList<String> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<String> dishes) {
        this.dishes = dishes;
    }

    public ArrayList<String> getDishesquantity() {
        return dishesquantity;
    }

    public void setDishesquantity(ArrayList<String> dishesquantity) {
        this.dishesquantity = dishesquantity;
    }

    public ArrayList<String> getDrinksquantity() {
        return drinksquantity;
    }

    public void setDrinksquantity(ArrayList<String> drinksquantity) {
        this.drinksquantity = drinksquantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
