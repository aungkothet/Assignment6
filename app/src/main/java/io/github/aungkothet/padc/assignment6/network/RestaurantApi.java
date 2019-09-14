package io.github.aungkothet.padc.assignment6.network;

import io.github.aungkothet.padc.assignment6.network.responses.RestaurantListResponse;
import io.github.aungkothet.padc.assignment6.utils.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestaurantApi {

    @GET(Constants.URL_GET_ALL_RESTAURANT)
    Call<RestaurantListResponse> getHouseList(@Query(Constants.PARAM_ACCESS_TOKEN) String accessToken);

}
