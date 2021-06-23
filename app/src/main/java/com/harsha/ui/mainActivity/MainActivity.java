package com.harsha.ui.mainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.google.gson.Gson;
import com.harsha.model.Restaurants;
import com.harsha.model.menuJsonPojo.MenuPojo;
import com.harsha.model.RestaurantMenu;
import com.harsha.model.restaurantJsonPojo.RestaurantConvertionPojo;
import com.harsha.ui.splashactivity.R;
import com.harsha.ui.splashactivity.databinding.MainActivityBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;
    ArrayList<Restaurants> restaurants=new ArrayList<>();
    private RestaurantAdapter restaurantAdapter;
    private MenuPojo menuPojo;
    private RestaurantConvertionPojo restaurantConvertionPojo;
    ArrayList<Restaurants> searchitem=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        initView();

    }

    /**
     * initialize the views
     */
    private void initView(){
        searchlistView();
        String restaurantResponse=loadRestaurantJSONFromAsset();
        String menuResponse=loadMenuJSONFromAsset();
        addingMenusToRespectiveRestaurant(restaurantResponse,menuResponse);
        searchitem.clear();
        searchitem.addAll(restaurants);
        restaurantAdapter=new RestaurantAdapter(searchitem);
        binding.rvAdapter.setAdapter(restaurantAdapter);
    }

    /**
     * adding the menu items to correspoing restaurant with using ID key
     */
    private void addingMenusToRespectiveRestaurant(String restaurantResponse,String menuResponse){
        Gson gson = new Gson();
        menuPojo = gson.fromJson(menuResponse, MenuPojo.class);
        restaurantConvertionPojo=gson.fromJson(restaurantResponse,RestaurantConvertionPojo.class);
        for(int i=0;i<restaurantConvertionPojo.getRestaurants().size();i++){
            Restaurants pojo=new Restaurants();
            pojo.setId(Integer.parseInt(restaurantConvertionPojo.getRestaurants().get(i).getId()));
            pojo.setCuisine_type(restaurantConvertionPojo.getRestaurants().get(i).getCuisine_type());
            pojo.setName(restaurantConvertionPojo.getRestaurants().get(i).getName());
            pojo.setType(getString(R.string.restaurant));
            ArrayList<RestaurantMenu> restaurantMenus=new ArrayList<>();
            for(int j=0;j<menuPojo.getMenus().size();j++) {
                if (Integer.parseInt(restaurantConvertionPojo.getRestaurants().get(i).getId()) == Integer.parseInt(menuPojo.getMenus().get(j).getRestaurantId())){
                    restaurantMenus.clear();
                    for(int k=0;k<menuPojo.getMenus().get(j).getCategories().size();k++) {
                        for(int l=0;l<menuPojo.getMenus().get(j).getCategories().get(k).getMenuItems().size();l++) {
                            RestaurantMenu restpojo=new RestaurantMenu();
                            restpojo.setId(menuPojo.getMenus().get(j).getCategories().get(k).getMenuItems().get(l).getId());
                            restpojo.setName(menuPojo.getMenus().get(j).getCategories().get(k).getMenuItems().get(l).getName());
                            restpojo.setPrice(menuPojo.getMenus().get(j).getCategories().get(k).getMenuItems().get(l).getPrice());
                            restpojo.setDescription(menuPojo.getMenus().get(j).getCategories().get(k).getMenuItems().get(l).getDescription());
                            restaurantMenus.add(restpojo);
                        }
                    }
                }
            }
            pojo.setRestaurantMenus(restaurantMenus);
            restaurants.add(pojo);
        }
    }

    /**
     * search the order of items/cuisine types/restaurants.
     */
    private void searchlistView(){
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    searchitem.clear();
                    for(int i=0;i<restaurants.size();i++){
                        //condition for check the cuisinetype
                        if(restaurants.get(i).getCuisine_type().toLowerCase().contains(s.toString().toLowerCase())){
                            searchitem.add(restaurants.get(i));
                        }
                        //condition for check the restaurants name
                        else if(restaurants.get(i).getName().toLowerCase().contains(s.toString().toLowerCase())){
                            searchitem.add(restaurants.get(i));
                        }else {
                            for(int j=0;j<restaurants.get(i).getRestaurantMenus().size();j++){
                                //condition for check the menu items name
                                if(restaurants.get(i).getRestaurantMenus().get(j).getName().toLowerCase().contains(s.toString().toLowerCase())){
                                    searchitem.add(restaurants.get(i));
                                    break;
                                }
                            }
                        }
                    }
                    restaurantAdapter.notifyDataSetChanged();
                }else{
                    searchitem.clear();
                    searchitem.addAll(restaurants);
                    restaurantAdapter.notifyDataSetChanged();
                }
                binding.ivEmpty.setVisibility(searchitem.size()>0? View.GONE:View.VISIBLE);
                binding.tvNotFound.setVisibility(searchitem.size()>0?View.GONE:View.VISIBLE);
            }
        });
    }

    /**
     * read the restaurants json file
     * @return
     */
    public String loadRestaurantJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("restaurants.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * read the menu json file
     * @return
     */
    public String loadMenuJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("menus.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}