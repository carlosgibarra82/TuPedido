package com.example.carlos.tupedido.Model;

public class Drinks {
    private String type;
    private String flavor;
    private String picture;
    private int price;

    public Drinks(String type, String flavor, String picture , int price) {
        this.type = type;
        this.flavor = flavor;
        this.picture = picture;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
