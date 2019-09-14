package io.github.aungkothet.padc.assignment6.views.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.delegates.RestaurantItemDelegate;

public class RestaurantViewHolder extends BaseViewHolder<RestaurantVo> {

    @BindView(R.id.item_restaurant_image)
    ImageView restaurantImage;

    @BindView(R.id.item_restaurant_name)
    TextView restaurantName;

    @BindView(R.id.item_restaurant_rating_text)
    TextView restaurantRating;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.item_restaurant_location_fab)
    FloatingActionButton loactionFab;

    @BindView(R.id.item_restaurant_desc)
    TextView restaurantDesc;

    @BindView(R.id.item_restaurant_address)
    TextView restaurantAddress;

    private Context context;

    public RestaurantViewHolder(@NonNull View itemView, final RestaurantItemDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
        loactionFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onFabClicked(mData);
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onItemClicked(mData.getId());
            }
        });
    }

    @Override
    public void bindData(RestaurantVo data) {
        mData = data;
        Glide.with(itemView).load(data.getImageUrl()).error(R.drawable.default_image).into(restaurantImage);
        restaurantName.setText(data.getName());
        restaurantAddress.setText(data.getAddress());
        restaurantDesc.setText(data.getDescription());
        restaurantRating.setText(data.getRating());
        ratingBar.setRating(Float.parseFloat(data.getRating()));

    }
}
