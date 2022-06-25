package com.example.vuelovmovil;

import com.example.vuelovmovil.Services.UserService;
import com.example.vuelovmovil.notifications.TokenService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor =  new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://vuelav-api.herokuapp.com/")
                .client(okHttpClient)
                .build();

        return retrofit;

    }


    public static UserService getUserService(){
        UserService userService = getRetrofit().create(UserService.class);

        return userService;
    }

    public static TokenService getTokenService() {
        return getRetrofit().create(TokenService.class);
    }
}
