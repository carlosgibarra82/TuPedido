package com.example.carlos.tupedido.Model;

public class Promo {

    private String id;
    private String name;
    private String picture;
    private String picture2;
    private String flavor;
    private int price;

    public Promo(String id, String name, String picture, String picture2, String flavor, int price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.picture2 = picture2;
        this.flavor = flavor;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
