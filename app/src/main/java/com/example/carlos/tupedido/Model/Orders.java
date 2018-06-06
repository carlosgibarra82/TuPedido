package com.example.carlos.tupedido.Model;

public class Orders {
    private String name;
    private String device;
    private String[] dishes;
    private String[] drinks;

    public Orders(String name, String device, String[] dishes, String[] drinks) {
        this.name = name;
        this.device = device;
        this.dishes = dishes;
        this.drinks = drinks;
    }

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

    public String[] getDishes() {
        return dishes;
    }

    public void setDishes(String[] dishes) {
        this.dishes = dishes;
    }

    public String[] getDrinks() {
        return drinks;
    }

    public void setDrinks(String[] drinks) {
        this.drinks = drinks;
    }
}
