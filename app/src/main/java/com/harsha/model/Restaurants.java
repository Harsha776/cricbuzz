package com.harsha.model;

import java.util.ArrayList;

public class Restaurants {

    private String type;
    private int id;
    private String name;
    private String cuisine_type;
    private ArrayList<RestaurantMenu> restaurantMenus;

    public Restaurants(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine_type() {
        return cuisine_type;
    }

    public void setCuisine_type(String cuisine_type) {
        this.cuisine_type = cuisine_type;
    }

    public ArrayList<RestaurantMenu> getRestaurantMenus() {
        return restaurantMenus;
    }

    public void setRestaurantMenus(ArrayList<RestaurantMenu> restaurantMenus) {
        this.restaurantMenus = restaurantMenus;
    }
}
