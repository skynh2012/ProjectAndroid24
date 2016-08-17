package com.niit.duyanh.xosoonline.network;

import com.google.gson.JsonElement;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Duy Anh on 09/08/2016.
 */
public interface KetQuaAPIService {

    @GET("get_xsmb_details.php")
    Call<JsonElement> getXSMBToDay();

    @GET("get_xsmb_details.php")
    Call<JsonElement> getXoSo(@Query("ngay") String ngay, @Query("tinh") String tinh);

    @GET("get_xsmt_details.php")
    Call<JsonElement> getXoSoMienTrung();

    @GET("get_xsmt_details.php")
    Call<JsonElement> getXoSoMienTrung(@Query("ngay") String ngay);

    @GET("get_xsmn_details.php")
    Call<JsonElement> getXoSoMienNam(@Query("ngay") String ngay);
}
