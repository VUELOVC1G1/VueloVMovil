package com.example.vuelovmovil.pantallasecundarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vuelovmovil.Models.SolicitudesObjectClass;
import com.example.vuelovmovil.R;
import com.example.vuelovmovil.Respuesta.SolicitudesResponseObjectClass;
import com.example.vuelovmovil.Services.SolicitudesRetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactanosActivity extends AppCompatActivity {

    EditText cedulas;
    EditText nombres;
    EditText apellidos;
    EditText correos;
    EditText descripciones;
    Button enviarSoliBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        //Inicializo variables formularios
        cedulas = findViewById(R.id.edCedula1);
        nombres = findViewById(R.id.edNombre1);
        apellidos = findViewById(R.id.edApellido1);
        correos = findViewById(R.id.edCorreo1);
        descripciones = findViewById(R.id.edDescripcion1);

//Variables Btn
         enviarSoliBtn = findViewById(R.id.enviarSoliBtn);

        //Metodo del Boton
        enviarSoliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Llamada del metodo de enviar solicitud
                enviarSolicitud();
            }
        });
    }

    //Codigo del metodo enviar solicitud

public void enviarSolicitud(){

    //Inicializar el metodo retrofit
    Retrofit retro = new Retrofit.Builder()
            .baseUrl("https://vuelo-v.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    SolicitudesObjectClass solicitudesObjectClass = new SolicitudesObjectClass(cedulas.getText().toString(),nombres.getText().toString(),apellidos.getText().toString(),correos.getText().toString(),descripciones.getText().toString());

    SolicitudesRetrofitClient solicitudesRetrofitClient = retro.create(SolicitudesRetrofitClient.class);

    Call<SolicitudesResponseObjectClass> resp = solicitudesRetrofitClient.GetPostValued(solicitudesObjectClass);

    resp.enqueue(new Callback<SolicitudesResponseObjectClass>() {
        @Override
        public void onResponse(Call<SolicitudesResponseObjectClass> call, Response<SolicitudesResponseObjectClass> response) {

            String nombres = response.body().getCedula();
            Log.e("nombres",nombres);
            Toast.makeText(ContactanosActivity.this, "Se ha enviado tu solicitud", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onFailure(Call<SolicitudesResponseObjectClass> call, Throwable t) {

            Log.e("response","failed");
            Toast.makeText(ContactanosActivity.this, "Se ha enviado tu solicitud", Toast.LENGTH_SHORT).show();



        }
    });






}
}