package io.github.aungkothet.padc.assignment6.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "menu",
        foreignKeys = {@ForeignKey(entity = RestaurantVo.class, parentColumns = "id", childColumns = "restaurant_id")},
        indices = {@Index(value = "restaurant_id"/* name in ColumnInfo */, unique = true)})
public class MenuVo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "menu_id_pk")
    private int menuIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "menu_id")
    private Integer id;

    @SerializedName("name")
    @ColumnInfo(name = "menu_name")
    private String name;

    @SerializedName("price")
    @ColumnInfo(name = "menu_price")
    private Integer price;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    public int getMenuIdPK() {
        return menuIdPK;
    }

    public void setMenuIdPK(int menuIdPK) {
        this.menuIdPK = menuIdPK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}