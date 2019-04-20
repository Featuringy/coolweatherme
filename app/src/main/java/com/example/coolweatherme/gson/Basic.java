package com.example.coolweatherme.gson;

import com.google.gson.annotations.SerializedName;

/*
* 当前城市和时间
* */
public class Basic {
    /*
    * @SerializedName注解用于json字段和java字段之间建立映射关系
    * */
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }

}
