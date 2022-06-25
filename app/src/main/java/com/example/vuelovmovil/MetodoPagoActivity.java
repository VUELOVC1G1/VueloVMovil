package com.example.vuelovmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MetodoPagoActivity extends AppCompatActivity {


    Button dinnersClub;
    Button masterCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_pago);


        dinnersClub = findViewById(R.id.dinnersClub);
        masterCard = findViewById(R.id.masterCard);




        //otro
        dinnersClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MetodoPagoActivity.this,MostrarDatosBoletoActivity.class));
                Toast.makeText(getApplicationContext(), "Reserva Guardada", Toast.LENGTH_SHORT).show();
finish();
            }
        });

        //otro
        masterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MetodoPagoActivity.this,MostrarDatosBoletoActivity.class));
                Toast.makeText(getApplicationContext(), "Reserva Guardada", Toast.LENGTH_SHORT).show();
finish();
            }
        });





    }




}