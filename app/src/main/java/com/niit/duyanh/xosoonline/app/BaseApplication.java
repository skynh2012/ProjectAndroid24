package com.niit.duyanh.xosoonline.app;

import android.app.Application;

import com.niit.duyanh.xosoonline.network.KetQuaAPIService;

import com.niit.duyanh.xosoonline.database.tinhThanhdbManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 09/08/2016.
 */
public class BaseApplication extends Application {
    public static Retrofit mRetrofit;

    public static final String BASE_API = "http://xoso888.vn/android_server/";

    public static KetQuaAPIService ketQuaAPIService;

    public static tinhThanhdbManager dbManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ketQuaAPIService = mRetrofit.create(KetQuaAPIService.class);

    }
}
