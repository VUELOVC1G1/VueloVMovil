package com.example.vuelovmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.vuelovmovil.pantallasecundarias.AboutActitivy;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotificationActivity extends AppCompatActivity {

    public Spinner a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.notifications);

        a=findViewById(R.id.id_desde);
        b=findViewById(R.id.id_hasta);


        String [] azuay={"Azuay", "Bolívar", "Cañar",
                "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas"
                , "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona-Santiago", "Napo", "Orellana", "Pastaza"
                , "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas"
                , "Sucumbíos", "Tungurahua", "Zamora-Chinchipe"
        };
        a.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, azuay));



        b.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, azuay));
        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),TableroActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notifications:
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), AboutActitivy.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.informacion:
                        startActivity(new Intent(getApplicationContext(),InfoActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


    }
}