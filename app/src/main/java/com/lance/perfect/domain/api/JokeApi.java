package com.lance.perfect.domain.api;

import com.lance.perfect.model.JokeEntity;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作用:  服务器URI获取
 * 作者： 张甲彪
 * 时间： 2016/4/28.
 */
public interface JokeApi {
    @Headers("apikey:83ec99fff780989a5376a1bc595ed5ff")

    @GET("showapi_joke/joke_text")
    Observable<JokeEntity> getJoke(@Query("page") int page);
}
