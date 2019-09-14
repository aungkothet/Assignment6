package io.github.aungkothet.padc.assignment6.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.data.vos.MenuVo;
import io.github.aungkothet.padc.assignment6.views.holders.RestaurantMenuViewHolder;
import io.github.aungkothet.padc.assignment6.views.holders.RestaurantViewHolder;

public class RestaurantMenuRecyclerAdapter extends BaseRecyclerAdapter<RestaurantMenuViewHolder, MenuVo> {

    @NonNull
    @Override
    public RestaurantMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_restaurant_menu, viewGroup, false);
        return new RestaurantMenuViewHolder(view);
    }
}
