package com.harsha.model.menuJsonPojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MenuItems implements Parcelable {

    @SerializedName("images")
    private String[] images;

    @SerializedName("price")
    private String price;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private String id;

    protected MenuItems(Parcel in) {
        images = in.createStringArray();
        price = in.readString();
        name = in.readString();
        description = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(images);
        dest.writeString(price);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MenuItems> CREATOR = new Creator<MenuItems>() {
        @Override
        public MenuItems createFromParcel(Parcel in) {
            return new MenuItems(in);
        }

        @Override
        public MenuItems[] newArray(int size) {
            return new MenuItems[size];
        }
    };

    public String[] getImages ()
    {
        return images;
    }

    public void setImages (String[] images)
    {
        this.images = images;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
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
