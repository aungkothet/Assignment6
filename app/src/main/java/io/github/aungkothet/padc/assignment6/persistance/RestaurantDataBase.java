package io.github.aungkothet.padc.assignment6.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import io.github.aungkothet.padc.assignment6.data.vos.MenuVo;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.persistance.daos.MenuDao;
import io.github.aungkothet.padc.assignment6.persistance.daos.RestaurantDao;
import io.github.aungkothet.padc.assignment6.utils.Constants;

@Database(entities = {RestaurantVo.class, MenuVo.class}, version = 3)
public abstract class RestaurantDataBase extends RoomDatabase {

    private static RestaurantDataBase objectInstance;

    public static RestaurantDataBase getObjectInstance(Context context) {
        if (objectInstance == null) {
            objectInstance = Room.databaseBuilder(context, RestaurantDataBase.class, Constants.DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objectInstance;
    }

    public abstract RestaurantDao restaurantDao();

    public abstract MenuDao menuDao();

    public boolean restaurantExistInDB() {
        return !restaurantDao().getAllRestaurantFromDB().isEmpty();
    }
}
