package io.github.aungkothet.padc.assignment6.data.models;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.github.aungkothet.padc.assignment6.data.vos.RestaurantAndMenuVo;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.network.dataagents.RestaurantDataAgent;
import io.github.aungkothet.padc.assignment6.utils.Constants;

public class RestaurantModelImpl extends BaseModel implements RestaurantModel {

    private static RestaurantModelImpl objInstance;

    public static void initializeEventModel(Context context) {
        objInstance = new RestaurantModelImpl(context);
    }

    private RestaurantModelImpl(Context context) {
        super(context);
    }

    public static RestaurantModelImpl getObjInstance() {
        if (objInstance == null) {
            throw new RuntimeException(Constants.MSG_RUNTIME_EXCEPTION);
        }
        return objInstance;
    }


    @Override
    public void getAllRestaurants(String accessToken, final GetRestaurantListFromDataLayerDelegate delegate) {
        if (!mDatabase.restaurantExistInDB()) {
            mDataAgent.getRestaurantList(accessToken, new RestaurantDataAgent.GetHouseListFromNetworkDelegates() {
                @Override
                public void onSuccess(List<RestaurantVo> restaurants) {
                    mDatabase.restaurantDao().insertRestaurantAndMenu(restaurants,mDatabase.menuDao());
                    delegate.onSuccess(restaurants);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        } else {
            List<RestaurantAndMenuVo> restaurantAndMenuFromDB = mDatabase.restaurantDao().getAllRestaurantFromDB();

            List<RestaurantVo> restaurantsFromDB = new ArrayList<>();
            for (RestaurantAndMenuVo restaurantAndMenuVo :
                    restaurantAndMenuFromDB) {
                restaurantAndMenuVo.getRestaurants().setMenus(restaurantAndMenuVo.getMenus());
                restaurantsFromDB.add(restaurantAndMenuVo.getRestaurants());
            }
            delegate.onSuccess(restaurantsFromDB);

        }
    }

    @Override
    public RestaurantVo getRestaurantById(int restaurantId) {
        RestaurantVo restaurantVo = mDatabase.restaurantDao().getReataurantByID(restaurantId);
        return restaurantVo;
    }

    @Override
    public List<RestaurantVo> filterHouse(String query) {
        List<RestaurantVo> restaurantVoList = mDatabase.restaurantDao().getAllRestaurantsOnly();
        List<RestaurantVo> resultList = new ArrayList<>();
        for (RestaurantVo restaurantVo :
                restaurantVoList ) {
            if(restaurantVo.getName().toLowerCase().contains(query.toLowerCase()))
                resultList.add(restaurantVo);
        }
        return resultList;
    }
}
