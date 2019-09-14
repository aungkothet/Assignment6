package io.github.aungkothet.padc.assignment6.persistance.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.github.aungkothet.padc.assignment6.data.vos.MenuVo;

@Dao
public abstract class MenuDao {

    @Query("SELECT * FROM menu")
    public  abstract List<MenuVo> getAllMenus();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insertMenu(List<MenuVo> menu);

}
