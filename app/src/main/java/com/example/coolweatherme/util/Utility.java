package com.example.coolweatherme.util;

import android.text.TextUtils;

import com.example.coolweatherme.db.City;
import com.example.coolweatherme.db.County;
import com.example.coolweatherme.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /*
    * 解析和处理服务器返回的省级数据
    * */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces= new JSONArray(response);//将一串json字符串解析成对象数组
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);//获取数组中的一个元素
                    Province province=new Province();
                    /*
                    * name和id是json字串中的字段名，
                    * */
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * 解析和处理服务器返回的市级数据
     * */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities= new JSONArray(response);//将一串json字符串解析成对象数组
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);//获取数组中的一个元素
                    City city=new City();
                    /*
                     * name和id是json字串中的字段名，
                     * */
                    city.setCityname(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * 解析和处理服务器返回的县级数据
     * */
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCountiies= new JSONArray(response);//将一串json字符串解析成对象数组
                for(int i=0;i<allCountiies.length();i++){
                    JSONObject countyObject=allCountiies.getJSONObject(i);//获取数组中的一个元素
                    County county=new County();
                    /*
                     * name和id是json字串中的字段名，
                     * */
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}