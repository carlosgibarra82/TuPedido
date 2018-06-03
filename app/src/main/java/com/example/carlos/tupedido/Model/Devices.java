package com.example.carlos.tupedido.model;

public class Devices {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public Devices(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
