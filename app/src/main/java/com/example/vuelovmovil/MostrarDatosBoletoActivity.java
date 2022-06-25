package com.example.vuelovmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vuelovmovil.RespuestaBoleto.BoletoResponseObjectClass;
import com.example.vuelovmovil.Services.ApiInterfaceRespuesta;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarDatosBoletoActivity extends AppCompatActivity {

    TextView textoid;
    Button volvermenu;

    //Codigo qr
    Button btGenerate;
    ImageView ivOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos_boleto);


        volvermenu = findViewById(R.id.volvermenu);
        ivOutput = findViewById(R.id.iv_output);



        textoid = findViewById(R.id.textoid);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vuelav-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterfaceRespuesta apiInterfaceRespuesta = retrofit.create(ApiInterfaceRespuesta.class);
int min = 132;
min++;

        Call<BoletoResponseObjectClass> call = apiInterfaceRespuesta.getBoletos(min);

        call.enqueue(new Callback<BoletoResponseObjectClass>() {
            @Override
            public void onResponse(Call<BoletoResponseObjectClass> call, Response<BoletoResponseObjectClass> response) {
//textoid.setText(response.body().getQr());

String contenido = "";
contenido += "BOLETO" + "\n\n";
contenido += "METODO PAGO : "+response.body().getPago().getTipo()+ "\n";
contenido += "TIPO ASIENTO : "+response.body().getAsientos().get(0).getTipoAsiento().getNombre() + "\n";
contenido += "CLASE : "+" PASAJERO" + "\n";
contenido += "FECHA RESERVA : "+response.body().getVuelo().getFechaCreacion() + "\n";


                textoid.setText(contenido);









                        String text = contenido;

                        MultiFormatWriter writer = new MultiFormatWriter();

                        try {
                            //Inicialias bit matrix
                            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE,
                                    450,450);
                            BarcodeEncoder encoder = new BarcodeEncoder();

                            Bitmap bitmap = encoder.createBitmap(matrix);

                            ivOutput.setImageBitmap(bitmap);

                            InputMethodManager manager = (InputMethodManager) getSystemService(
                                    Context.INPUT_METHOD_SERVICE
                            );

                        } catch (WriterException e) {
                            e.printStackTrace();
                        }

            }

            @Override
            public void onFailure(Call<BoletoResponseObjectClass> call, Throwable t) {

            }
        });

volvermenu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MostrarDatosBoletoActivity.this,TableroActivity.class));
        finish();
    }
});
    }

}