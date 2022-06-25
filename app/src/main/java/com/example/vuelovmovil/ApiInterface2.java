package com.example.vuelovmovil;

import com.example.vuelovmovil.RespuestaBoleto.BoletoResponseObjectClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface2 {
    @GET("api/v1/boletos/pasajero/{id}")
    Call<List<BoletoResponseObjectClass>> getBoletosPajero(@Path("id") int id);
}
