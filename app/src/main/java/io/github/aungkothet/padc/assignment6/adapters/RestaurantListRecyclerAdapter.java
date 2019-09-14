package io.github.aungkothet.padc.assignment6.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.delegates.RestaurantItemDelegate;
import io.github.aungkothet.padc.assignment6.views.holders.RestaurantViewHolder;

public class RestaurantListRecyclerAdapter extends BaseRecyclerAdapter<RestaurantViewHolder, RestaurantVo> {

    RestaurantItemDelegate delegate;

    public RestaurantListRecyclerAdapter(RestaurantItemDelegate delegate) {
        this.delegate = delegate;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_reataurant, viewGroup, false);
        return new RestaurantViewHolder(view, delegate);
    }
}
