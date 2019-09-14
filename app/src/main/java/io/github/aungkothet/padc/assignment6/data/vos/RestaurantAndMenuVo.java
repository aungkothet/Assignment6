package io.github.aungkothet.padc.assignment6.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class RestaurantAndMenuVo {

    @Embedded
    RestaurantVo restaurants;

    @Relation(parentColumn = "id", entityColumn = "restaurant_id")
    List<MenuVo> menus;

    public RestaurantVo getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(RestaurantVo restaurants) {
        this.restaurants = restaurants;
    }

    public List<MenuVo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVo> menus) {
        this.menus = menus;
    }
}
