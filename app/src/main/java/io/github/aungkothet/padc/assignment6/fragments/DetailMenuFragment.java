package io.github.aungkothet.padc.assignment6.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.adapters.RestaurantMenuRecyclerAdapter;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailMenuFragment extends Fragment {


    @BindView(R.id.detail_menu_list)
    RecyclerView menuList;

    public DetailMenuFragment() {
        // Required empty public constructor
    }

    RestaurantVo restaurantVo;

    private static final String BE_RESTAURNAT = "bundleExtra";


    public static Fragment newInstance(RestaurantVo restaurantVo){
        Bundle bundle = new Bundle();
        bundle.putSerializable(BE_RESTAURNAT, restaurantVo);
        Fragment fragment = new DetailMenuFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


//    public void setRestaurantVo(RestaurantVo restaurantVo) {
//        System.out.println("received data");
//        this.restaurantVo = restaurantVo;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_menu, container, false);
        ButterKnife.bind(this,view);
        restaurantVo = (RestaurantVo)getArguments().getSerializable(BE_RESTAURNAT);
        RestaurantMenuRecyclerAdapter adapter = new RestaurantMenuRecyclerAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(adapter);
        adapter.setViewData(restaurantVo.getMenus());
        return  view;
    }

}
