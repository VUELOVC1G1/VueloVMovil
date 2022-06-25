package com.example.vuelovmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vuelovmovil.pantallasecundarias.AboutActitivy;
import com.example.vuelovmovil.pantallasecundarias.CodigoQRActivity;
import com.example.vuelovmovil.pantallasecundarias.ContactanosActivity;
import com.example.vuelovmovil.sqlite.daos.UsuarioDaoImpl;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InfoActivity extends AppCompatActivity {
    private UsuarioDaoImpl usuarioDao;

    //Declacion de Imagenes con su evento de boton
    ImageView seguridadViaje;
    ImageView codigoQr;
    ImageView informacionAerolinea;
    ImageView contactanos;
    TextView cerrarSesion;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        preferences = getSharedPreferences("Preferences",MODE_PRIVATE);

        usuarioDao = new UsuarioDaoImpl(this);

        //Inicializar variables imageview
        seguridadViaje = findViewById(R.id.seguridadViaje);
        codigoQr = findViewById(R.id.codigoQr);
        informacionAerolinea = findViewById(R.id.informacionAerolinea);
        contactanos = findViewById(R.id.contactanos);
        cerrarSesion = findViewById(R.id.cerrarSesion);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.informacion);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), TableroActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notifications:
                        startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), AboutActitivy.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.informacion:
                        return true;

                }
                return false;
            }
        });


        //Metodos de los ajustes

        seguridadViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(InfoActivity.this, SeguridadViajeActivity.class));

            }
        });

        codigoQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this, CodigoQRActivity.class));


            }
        });

        informacionAerolinea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this, InformacionAerolineaActivity.class));

            }
        });

        contactanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(InfoActivity.this, ContactanosActivity.class));


            }
        });

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioDao.deleteAll();
                preferences.edit().clear().apply();
                startActivity(new Intent(InfoActivity.this, Login.class));
                finish();
            }
        });
    }


}