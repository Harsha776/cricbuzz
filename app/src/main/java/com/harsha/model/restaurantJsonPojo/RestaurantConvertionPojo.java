package com.harsha.model.restaurantJsonPojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RestaurantConvertionPojo {

    @SerializedName("restaurants")
    private ArrayList<RestaurantsListConverstion> restaurants;

    public ArrayList<RestaurantsListConverstion> getRestaurants ()
    {
        return restaurants;
    }

    public void setRestaurants (ArrayList<RestaurantsListConverstion> restaurants)
    {
        this.restaurants = restaurants;
    }

}
