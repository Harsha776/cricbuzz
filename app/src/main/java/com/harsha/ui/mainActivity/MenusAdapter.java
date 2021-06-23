package com.harsha.ui.mainActivity;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.harsha.common.Utility;
import com.harsha.model.RestaurantMenu;
import com.harsha.ui.splashactivity.R;
import com.harsha.ui.splashactivity.databinding.ItemMenuListBinding;
import java.util.ArrayList;

import static com.harsha.common.Constants.BLACK;
import static com.harsha.common.Constants.LIGHT_BLACK;
import static com.harsha.common.Constants.ZERO;

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MenusAdapterViewHolder> {
    private Context mContext;
    ArrayList<RestaurantMenu> restaurantMenus;

    MenusAdapter(ArrayList<RestaurantMenu> restaurantMenus){
        this.restaurantMenus=restaurantMenus;
    }
    @NonNull
    @Override
    public MenusAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        ItemMenuListBinding binding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_menu_list, parent, false);
        return new MenusAdapter.MenusAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenusAdapterViewHolder holder, int position) {
        holder.binding.tvName.setText(Html.fromHtml(String.format("%s %s", Utility.multiplrColorText(mContext.getString(R.string.name), LIGHT_BLACK), Utility.multiplrColorText(restaurantMenus.get(position).getName(), BLACK))));
        holder.binding.tvId.setText(Html.fromHtml(String.format("%s %s", Utility.multiplrColorText(mContext.getString(R.string.id), LIGHT_BLACK), Utility.multiplrColorText(restaurantMenus.get(position).getId(), BLACK))));
        holder.binding.tvDesc.setText(Html.fromHtml(String.format("%s %s", Utility.multiplrColorText(mContext.getString(R.string.description), LIGHT_BLACK), Utility.multiplrColorText(restaurantMenus.get(position).getDescription(), BLACK))));
        holder.binding.tvPrice.setText(Html.fromHtml(String.format("%s %s", Utility.multiplrColorText(mContext.getString(R.string.price), LIGHT_BLACK), Utility.multiplrColorText(restaurantMenus.get(position).getPrice(), BLACK))));
    }

    @Override
    public int getItemCount() {
        return restaurantMenus!=null?restaurantMenus.size():ZERO;
    }

    public class MenusAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemMenuListBinding binding;
        public MenusAdapterViewHolder(@NonNull ItemMenuListBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
