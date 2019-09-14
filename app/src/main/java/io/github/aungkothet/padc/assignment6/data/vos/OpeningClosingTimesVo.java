package io.github.aungkothet.padc.assignment6.data.vos;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class OpeningClosingTimesVo {

    @SerializedName("opening_time")
    @ColumnInfo(name = "opening_time")
    private String openingTime;

    @SerializedName("closing_time")
    @ColumnInfo(name = "closing_time")
    private String closingTime;

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

}