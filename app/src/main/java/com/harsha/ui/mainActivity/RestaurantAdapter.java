package com.harsha.ui.mainActivity;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.harsha.common.Utility;
import com.harsha.model.Restaurants;
import com.harsha.ui.splashactivity.R;
import com.harsha.ui.splashactivity.databinding.ItemRestaurantBinding;
import java.util.ArrayList;
import static com.harsha.common.Constants.BLACK;
import static com.harsha.common.Constants.LIGHT_BLACK;
import static com.harsha.common.Constants.ZERO;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantListAdapter> {

    private Context mContext;
    ArrayList<Restaurants> restaurants;

     RestaurantAdapter(ArrayList<Restaurants> restaurants){
         this.restaurants=restaurants;
    }
    @NonNull
    @Override
    public RestaurantListAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        ItemRestaurantBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_restaurant, parent, false);
        return new RestaurantListAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantListAdapter holder, int position) {
         holder.binding.tvType.setText(restaurants.get(position).getType());
         holder.binding.tvName.setText(Html.fromHtml(String.format("%s %s", Utility.multiplrColorText(mContext.getString(R.string.name), LIGHT_BLACK), Utility.multiplrColorText(restaurants.get(position).getName(), BLACK))));
        holder.binding.tvId.setText(Html.fromHtml(String.format("%s %s", Utility.multiplrColorText(mContext.getString(R.string.id), LIGHT_BLACK), Utility.multiplrColorText(restaurants.get(position).getId() + "", BLACK))));
        holder.binding.tvCuisine.setText(Html.fromHtml(String.format("%s %s", Utility.multiplrColorText(mContext.getString(R.string.cuisineType), LIGHT_BLACK), Utility.multiplrColorText(restaurants.get(position).getCuisine_type(), BLACK))));
        holder.binding.tvMenu.setVisibility(restaurants.get(position).getRestaurantMenus().size()>ZERO?View.VISIBLE:View.GONE);
        MenusAdapter menusAdapter=new MenusAdapter(restaurants.get(position).getRestaurantMenus());
        holder.binding.rvMens.setHasFixedSize(true);
        holder.binding.rvMens.setAdapter(menusAdapter);
    }

    @Override
    public int getItemCount() {
        return restaurants!=null?restaurants.size():ZERO;
    }

    public class RestaurantListAdapter extends RecyclerView.ViewHolder {
        private ItemRestaurantBinding binding;
        public RestaurantListAdapter(@NonNull ItemRestaurantBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
