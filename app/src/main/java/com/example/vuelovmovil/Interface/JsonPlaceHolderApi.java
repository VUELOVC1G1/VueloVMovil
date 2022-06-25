package com.example.vuelovmovil.Interface;

import com.example.vuelovmovil.Model.Promociones;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

        @GET("api/v1/promociones/comerciales")
        Call<List<Promociones>> getPromociones();
}
