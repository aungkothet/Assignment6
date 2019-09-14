package io.github.aungkothet.padc.assignment6.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.data.models.RestaurantModel;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.delegates.RestaurantItemDelegate;
import io.github.aungkothet.padc.assignment6.fragments.ExploreFragment;
import io.github.aungkothet.padc.assignment6.utils.Constants;

public class MainActivity extends BaseActivity implements RestaurantItemDelegate {

    @BindView(R.id.nav_view)
    BottomNavigationView bottomNavigationView;

    public static RestaurantModel restaurantModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        restaurantModel = mRestaurantModel;
        changeFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_camera : return true;
                    case R.id.navigation_explore :changeFragment(); return true;
                    case R.id.navigation_grid : return true;
                    case R.id.navigation_noti : return true;
                    case R.id.navigation_profile: return true;
                }
                return false;
            }
        });
    }

    private void changeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame_layout, new ExploreFragment())
                .commit();
    }

    @Override
    public void onItemClicked(int id) {
        Log.d("TAG","INMAIN"+id);
        startActivity(RestaurantDetailActivity.newIntent(MainActivity.this,id));
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
