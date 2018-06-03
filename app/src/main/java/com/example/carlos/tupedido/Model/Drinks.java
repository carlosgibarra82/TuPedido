package com.example.carlos.tupedido.model;

public class Drinks {
    private String type;
    private String flavor;

    public String getType() {
        return type;
    }

    public Drinks(String type, String flavor) {
        this.type = type;
        this.flavor = flavor;
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
}
