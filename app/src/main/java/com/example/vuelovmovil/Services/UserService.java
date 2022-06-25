package com.example.vuelovmovil.Services;

import com.example.vuelovmovil.Models.LoginRequest;
import com.example.vuelovmovil.Models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/v1/auth/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}
