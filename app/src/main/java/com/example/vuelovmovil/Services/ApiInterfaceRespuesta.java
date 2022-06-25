package com.example.vuelovmovil.Services;

import com.example.vuelovmovil.RespuestaBoleto.BoletoResponseObjectClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterfaceRespuesta {

    @GET("api/v1/boletos/{id}")
    public Call<BoletoResponseObjectClass> getBoletos(@Path("id") int boletoId);
}
