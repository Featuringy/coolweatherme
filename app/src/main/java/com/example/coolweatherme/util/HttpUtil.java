package com.example.coolweatherme.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static  void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
        /*先创建客户端，再创建请求*/
        /*将创建的请求放进客户端里面*/
    }
}
