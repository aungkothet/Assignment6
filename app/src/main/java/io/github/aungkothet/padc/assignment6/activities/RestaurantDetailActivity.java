package io.github.aungkothet.padc.assignment6.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.delegates.RestaurantItemDelegate;
import io.github.aungkothet.padc.assignment6.fragments.DetailCardFragment;
import io.github.aungkothet.padc.assignment6.fragments.DetailMenuFragment;

public class RestaurantDetailActivity extends BaseActivity implements RestaurantItemDelegate {

    public static String IE_RESTAURANT = "restaurantExtra";

    @BindView(R.id.detail_restaurant_image)
    ImageView detailImage;

    @BindView(R.id.detail_bottom_tab)
    TabLayout tabLayout;

    RestaurantVo restaurant;

    public static Intent newIntent(Context context, int restaurantID) {
        Intent intent = new Intent(context, RestaurantDetailActivity.class);
        intent.putExtra(IE_RESTAURANT, restaurantID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ButterKnife.bind(this);
        int id = getIntent().getIntExtra(IE_RESTAURANT, 0);

        restaurant = mRestaurantModel.getRestaurantById(id);
        Glide.with(this).load(restaurant.getImageUrl()).error(R.drawable.default_image).into(detailImage);
        changeFragment(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void changeFragment(int i) {
        Fragment targetFragment;
        switch (i) {
            case 0:
                targetFragment = DetailCardFragment.newInstance(restaurant);
//                targetFragment = new DetailCardFragment();
//                ((DetailCardFragment) targetFragment).setRestaurantVo(restaurant);
                break;
            case 1:
                targetFragment = DetailCardFragment.newInstance(restaurant);
//                targetFragment = new DetailMenuFragment();
//                ((DetailMenuFragment) targetFragment).setRestaurantVo(restaurant);
                break;
            default:
                targetFragment = DetailCardFragment.newInstance(restaurant);
//                targetFragment = new DetailCardFragment();
//                ((DetailCardFragment) targetFragment).setRestaurantVo(restaurant);
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail_frame_layout, targetFragment)
                .commit();
    }

    @Override
    public void onItemClicked(int id) {

    }

    @Override
    public void onFabClicked(RestaurantVo restaurant) {
        Uri gmmIntentUri = Uri.parse(getString(R.string.str_geo, restaurant.getRestaurantLocation().getLatitude(),
                restaurant.getRestaurantLocation().getLongitude()));
//                Uri gmmIntentUri = Uri.parse(getString(R.string.str_geo, 16.812715, 96.131513));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    @Override
    public void showErrorSnack(String errMessage) {
        showSnack(errMessage);
    }
}
