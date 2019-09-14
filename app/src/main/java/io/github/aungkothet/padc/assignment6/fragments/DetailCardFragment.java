package io.github.aungkothet.padc.assignment6.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.delegates.RestaurantItemDelegate;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCardFragment extends Fragment {


    @BindView(R.id.detail_restaurant_name)
    TextView restaurantName;

    @BindView(R.id.detail_restaurant_location_fab)
    FloatingActionButton locationFab;

    @BindView(R.id.detail_restaurant_desc)
    TextView restaurantDesc;

    @BindView(R.id.detail_opening_hour)
    TextView openingHour;

    @BindView(R.id.detail_map_view)
    TextView mapView;

    RestaurantItemDelegate delegate;
    RestaurantVo restaurantVo;

    public DetailCardFragment() {
        // Required empty public constructor
    }

    private static final String BE_RESTAURNAT = "bundleExtra";


    public static Fragment newInstance(RestaurantVo restaurantVo){
        Bundle bundle = new Bundle();
        bundle.putSerializable(BE_RESTAURNAT, restaurantVo);
        Fragment fragment = new DetailCardFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


//    public void setRestaurantVo(RestaurantVo restaurantVo) {
//        this.restaurantVo = restaurantVo;
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        delegate = (RestaurantItemDelegate) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_card, container, false);
        ButterKnife.bind(this,view);
        restaurantVo = (RestaurantVo)getArguments().getSerializable(BE_RESTAURNAT);
        bindViewData(restaurantVo);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onFabClicked(restaurantVo);
            }
        });

        locationFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onFabClicked(restaurantVo);
            }
        });
        return view;
    }

    private void bindViewData(RestaurantVo restaurantVo) {
        Log.d("TAG",restaurantVo.getName()+"in bindView");
        restaurantName.setText(restaurantVo.getName());
        restaurantDesc.setText(restaurantVo.getDescription());
        openingHour.setText(restaurantVo.getOpeningClosingTimes().getOpeningTime() + " - "
                + restaurantVo.getOpeningClosingTimes().getClosingTime());
    }

}
