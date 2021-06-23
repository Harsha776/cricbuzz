package com.harsha.model.restaurantJsonPojo;

import com.google.gson.annotations.SerializedName;

public class RestaurantsListConverstion {

    @SerializedName("photograph")
    private String photograph;

    @SerializedName("address")
    private String address;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("neighborhood")
    private String neighborhood;

    @SerializedName("cuisine_type")
    private String cuisine_type;

    public String getPhotograph ()
    {
        return photograph;
    }

    public void setPhotograph (String photograph)
    {
        this.photograph = photograph;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
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

    public String getNeighborhood ()
    {
        return neighborhood;
    }

    public void setNeighborhood (String neighborhood)
    {
        this.neighborhood = neighborhood;
    }

    public String getCuisine_type ()
    {
        return cuisine_type;
    }

    public void setCuisine_type (String cuisine_type)
    {
        this.cuisine_type = cuisine_type;
    }
}
