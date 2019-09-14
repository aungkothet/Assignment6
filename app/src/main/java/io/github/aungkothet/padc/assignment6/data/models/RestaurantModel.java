package io.github.aungkothet.padc.assignment6.data.models;

import java.util.List;

import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;

public interface RestaurantModel {

    void getAllRestaurants(String accessToken,GetRestaurantListFromDataLayerDelegate getRestaurantListFromDataLayerDelegate);

    RestaurantVo getRestaurantById(int restaurantId);

    List<RestaurantVo> filterHouse(String query);

    interface GetRestaurantListFromDataLayerDelegate{

        void onSuccess(List<RestaurantVo> houseVoList);
        void onFailure(String errMessage);
    }
}
