package com.example.hepsisurada;

import java.io.Serializable;

public class Object {
    private String img_id;
    private String name;
    private int like_count;
    private int id;
    private boolean isBasket;

    public Object(String img_id, String name, int like_count, int id, boolean isBasket) {
        this.img_id = img_id;
        this.name = name;
        this.like_count = like_count;
        this.id = id;
        this.isBasket = isBasket;
    }

    public Object() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count() {
        this.like_count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBasket() {
        return isBasket;
    }

    public void setBasket(boolean basket) {
        isBasket = basket;
    }
}
