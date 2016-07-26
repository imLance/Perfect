package com.lance.perfect.domain.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/9.
 */
public class RxService {
    private static final String BASETESTURL = "http://apis.baidu.com/showapi_open_bus/";

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor
            (new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

    private static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BASETESTURL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private RxService() {

    }

    public static <T> T createApi(Class<T> clazz){
        return retrofit.create(clazz);
    }
}
