package com.harsha.model.menuJsonPojo;

import java.util.ArrayList;

public class Menus {

    private ArrayList<Categories> categories;

    private String restaurantId;

    public ArrayList<Categories> getCategories ()
    {
        return categories;
    }

    public void setCategories (ArrayList<Categories> categories)
    {
        this.categories = categories;
    }

    public String getRestaurantId ()
    {
        return restaurantId;
    }

    public void setRestaurantId (String restaurantId)
    {
        this.restaurantId = restaurantId;
    }
}
