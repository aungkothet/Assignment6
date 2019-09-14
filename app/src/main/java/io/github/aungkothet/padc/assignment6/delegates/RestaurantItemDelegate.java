package io.github.aungkothet.padc.assignment6.delegates;

import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;

public interface RestaurantItemDelegate {

    void onItemClicked(int id);

    void onFabClicked(RestaurantVo restaurant);
    void showErrorSnack(String errMessage);
}
