package com.example.vuelovmovil.notifications;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TokenService {

    @POST("api/v1/token")
    Call<ResponseBody> saveToken(@Body UserTokenRequest request);
}
