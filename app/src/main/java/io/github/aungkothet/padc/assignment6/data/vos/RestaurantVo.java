package io.github.aungkothet.padc.assignment6.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "restaurant",
        indices = {@Index(value = "id", unique = true)})
public class RestaurantVo implements Serializable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "restaurant_id_pk")
    private int restaurantIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private Integer id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("image_url")
    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("opening_closing_times")
    @Embedded(prefix = "opening_closing_times_")
    private OpeningClosingTimesVo openingClosingTimes;

    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    private String rating;

    @SerializedName("restaurant_location")
    @Embedded(prefix = "restaurant_location_")
    private RestaurantLocationVo restaurantLocation;

    @SerializedName("menus")
    @Ignore
    private List<MenuVo> menus = null;

    public int getRestaurantIdPK() {
        return restaurantIdPK;
    }

    public void setRestaurantIdPK(int restaurantIdPK) {
        this.restaurantIdPK = restaurantIdPK;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpeningClosingTimesVo getOpeningClosingTimes() {
        return openingClosingTimes;
    }

    public void setOpeningClosingTimes(OpeningClosingTimesVo openingClosingTimes) {
        this.openingClosingTimes = openingClosingTimes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public RestaurantLocationVo getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(RestaurantLocationVo restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public List<MenuVo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVo> menus) {
        this.menus = menus;
    }

}