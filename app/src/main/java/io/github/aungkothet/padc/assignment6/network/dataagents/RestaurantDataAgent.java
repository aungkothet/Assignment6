package io.github.aungkothet.padc.assignment6.network.dataagents;

import java.util.List;

import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;

public interface RestaurantDataAgent {

    void getRestaurantList(String accessToken, GetHouseListFromNetworkDelegates delegates);

    interface GetHouseListFromNetworkDelegates {

        void onSuccess(List<RestaurantVo> restaurantVoList);

        void onFailure(String errorMessage);
    }
}
