package io.github.aungkothet.padc.assignment6.data.models;

import android.content.Context;

import io.github.aungkothet.padc.assignment6.network.dataagents.RestaurantDataAgent;
import io.github.aungkothet.padc.assignment6.network.dataagents.RetrofitDataAgentImpl;
import io.github.aungkothet.padc.assignment6.persistance.RestaurantDataBase;


public abstract class BaseModel {
    protected RestaurantDataAgent mDataAgent;
    protected RestaurantDataBase mDatabase;

    BaseModel(Context context) {

        this.mDataAgent = RetrofitDataAgentImpl.getObjInstance();
        this.mDatabase = RestaurantDataBase.getObjectInstance(context);

    }
}
