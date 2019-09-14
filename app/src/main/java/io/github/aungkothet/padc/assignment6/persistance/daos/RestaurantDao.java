package io.github.aungkothet.padc.assignment6.persistance.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import io.github.aungkothet.padc.assignment6.data.vos.MenuVo;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantAndMenuVo;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public abstract class RestaurantDao {

    @Query("SELECT restaurant.*,menu.* FROM restaurant INNER JOIN menu WHERE restaurant.id = menu.restaurant_id")
    public  abstract List<RestaurantAndMenuVo> getAllRestaurantFromDB();

    @Insert(onConflict = REPLACE)
    public abstract void insertRestaurant(List<RestaurantVo> houseVoList);

    @Query("SELECT * FROM restaurant WHERE id = :restaurantID")
    public abstract RestaurantVo getReataurantByID(int restaurantID);

    @Query("SELECT * FROM restaurant")
    public abstract List<RestaurantVo> getAllRestaurantsOnly();

    public void insertRestaurantAndMenu(List<RestaurantVo> restaurantVoList,MenuDao menuDao){
        List<MenuVo> menuList = new ArrayList<>();

        for (RestaurantVo restaurantVo: restaurantVoList) {
            for (MenuVo menu: restaurantVo.getMenus()) {
                menu.setRestaurantId(restaurantVo.getId());
                menuList.add(menu);
            }
        }
        insertRestaurant(restaurantVoList);
        menuDao.insertMenu(menuList);
    }
}
