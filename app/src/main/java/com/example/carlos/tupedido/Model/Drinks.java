package com.example.carlos.tupedido.model;

public class Drinks {
    private String type;
    private String flavor;
    private String picture;

    public Drinks(String type, String flavor, String picture) {
        this.type = type;
        this.flavor = flavor;
        this.picture = picture;
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
}
