package io.github.aungkothet.padc.assignment6.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.activities.MainActivity;
import io.github.aungkothet.padc.assignment6.adapters.RestaurantListRecyclerAdapter;
import io.github.aungkothet.padc.assignment6.data.models.RestaurantModel;
import io.github.aungkothet.padc.assignment6.data.models.RestaurantModelImpl;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.delegates.RestaurantItemDelegate;
import io.github.aungkothet.padc.assignment6.utils.Constants;

public class ExploreFragment extends Fragment {

    @BindView(R.id.rv_restaurant_list)
    RecyclerView restaurantList;

    RestaurantListRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;
    RestaurantItemDelegate delegate;

    @BindView(R.id.searchView)
    ImageView searchImage;

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    @BindView(R.id.et_layout)
    LinearLayout etLayout;

    @BindView(R.id.et_searach)
    EditText etSearch;

    public ExploreFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        delegate = (RestaurantItemDelegate) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this,view);
        adapter = new RestaurantListRecyclerAdapter(delegate);
        layoutManager = new LinearLayoutManager(view.getContext());
        restaurantList.setLayoutManager(layoutManager);
        restaurantList.setAdapter(adapter);
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etLayout.setVisibility(View.VISIBLE);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<RestaurantVo> houseVoList = MainActivity.restaurantModel.filterHouse(s.toString());
                adapter.setViewData(houseVoList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        MainActivity.restaurantModel.getAllRestaurants(Constants.ACCESS_TOKEN, new RestaurantModel.GetRestaurantListFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<RestaurantVo> houseVoList) {
                adapter.setViewData(houseVoList);
                pbLoading.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(String errMessage) {
                delegate.showErrorSnack(errMessage);
            }
        });
        return view;
    }

}
