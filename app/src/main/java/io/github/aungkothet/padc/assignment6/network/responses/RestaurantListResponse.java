package io.github.aungkothet.padc.assignment6.network.responses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;
import io.github.aungkothet.padc.assignment6.utils.Constants;

public class RestaurantListResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<RestaurantVo> data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RestaurantVo> getData() {
        return data;
    }

    public void setData(List<RestaurantVo> data) {
        this.data = data;
    }

    public boolean isResponseOk(){
        return code == Constants.CODE_RESPONSE_OK && data != null;
    }

}