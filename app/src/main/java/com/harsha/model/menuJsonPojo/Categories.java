package com.harsha.model.menuJsonPojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Categories {

    @SerializedName("menu-items")
    private ArrayList<MenuItems> menuItems;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    public ArrayList<MenuItems> getMenuItems ()
    {
        return menuItems;
    }

    public void setMenuItems (ArrayList<MenuItems> menuItems)
    {
        this.menuItems = menuItems;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }
}
