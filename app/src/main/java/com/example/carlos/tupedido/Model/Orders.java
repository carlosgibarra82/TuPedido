package com.example.carlos.tupedido.Model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@DatabaseTable
public class Orders {
    @DatabaseField(generatedId = true)
    private int _id;
    private String name;
    @DatabaseField
    private String device;
    @DatabaseField(dataType= DataType.SERIALIZABLE)
    private ArrayList<String> dishes;
    @DatabaseField(dataType= DataType.SERIALIZABLE)
    private ArrayList<String> drinks;
    @DatabaseField
    private int price;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public ArrayList<String> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<String> dishes) {
        this.dishes = dishes;
    }

    public ArrayList<String> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<String> drinks) {
        this.drinks = drinks;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
