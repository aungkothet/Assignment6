package io.github.aungkothet.padc.assignment6;

import android.app.Application;

import io.github.aungkothet.padc.assignment6.data.models.RestaurantModelImpl;

public class RestaurantApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RestaurantModelImpl.initializeEventModel(getApplicationContext());
    }
}
