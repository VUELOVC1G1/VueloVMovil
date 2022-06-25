package com.example.vuelovmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.vuelovmovil.RespuestaBoleto.BoletoResponseObjectClass;

import java.util.List;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VuelosReservados extends AppCompatActivity {

    private TextView mJsonText;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuelos_reservados);

        preferences = getSharedPreferences("Preferences",MODE_PRIVATE);

        int usuario_id = preferences.getInt("usuario_id",0);


        Log.e("estas son de vuelos reservadosssssssssssssssssssss", String.valueOf(usuario_id));







        mJsonText = findViewById(R.id.jsonTexto);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vuelav-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface2 apiInterface2 = retrofit.create(ApiInterface2.class);



            Call<List<BoletoResponseObjectClass>> call = apiInterface2.getBoletosPajero(usuario_id-7);



        call.enqueue(new Callback<List<BoletoResponseObjectClass>>() {
            @Override
            public void onResponse(Call<List<BoletoResponseObjectClass>> call, Response<List<BoletoResponseObjectClass>> response) {

                if(!response.isSuccessful()){
                    mJsonText.setText("No ha reservado ningun vuelo todavia!!! ");
                    return;
                }




                List<BoletoResponseObjectClass> boletosList = response.body();

                for(BoletoResponseObjectClass boleto: boletosList){
                    String content1 = "";
                    content1 = "                VUELO COMPRADO " + "\n";

                    content1 += "  FECHA RESERVA :" + boleto.getFecha() + "\n";
                    content1 += "  TIPO PAGO  " + boleto.getPago().getTipo()+"\n";
                    content1 += "  PRECIO MALETAS " + boleto.getMaletas().get(0).getPrecio() +"\n";
                    content1 += "  OBSERVACION  " + " Vuelo reservado"+"\n";
                    content1 += "  TIPO USUARIO  " + "PASAJERO COMERCIAL"+"\n";
                    content1 += "  AVION  " + " American "+"\n\n\n";


                    mJsonText.append(content1);
                    Log.d("mensajeee",content1);

                }
            }

            @Override
            public void onFailure(Call<List<BoletoResponseObjectClass>> call, Throwable t) {
                mJsonText.setText("No hay Vuelos Para este usuario ");

    Log.e("error de mensaje",t.getMessage());
            }
        });
    }
}