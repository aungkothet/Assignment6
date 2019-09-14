package io.github.aungkothet.padc.assignment6.network.dataagents;

import io.github.aungkothet.padc.assignment6.network.RestaurantApi;
import io.github.aungkothet.padc.assignment6.network.responses.RestaurantListResponse;
import io.github.aungkothet.padc.assignment6.utils.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RetrofitDataAgentImpl implements RestaurantDataAgent {

    private static RetrofitDataAgentImpl objInstance;

    private RestaurantApi restaurantApi;

    public static RetrofitDataAgentImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    private RetrofitDataAgentImpl() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, SECONDS)
                .writeTimeout(15, SECONDS)
                .readTimeout(15, SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        restaurantApi = retrofit.create(RestaurantApi.class);

    }

    @Override
    public void getRestaurantList(String accessToken, final GetHouseListFromNetworkDelegates delegates) {
        Call<RestaurantListResponse> responseCall = restaurantApi.getHouseList(accessToken);
        responseCall.enqueue(new Callback<RestaurantListResponse>() {
            @Override
            public void onResponse(Call<RestaurantListResponse> call, Response<RestaurantListResponse> response) {
                if (response.body().isResponseOk()) {
                    delegates.onSuccess(response.body().getData());
                } else {
                    delegates.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<RestaurantListResponse> call, Throwable t) {
                delegates.onFailure(t.getMessage());
            }
        });
    }
}
