package com.example.vuelovmovil.pantallasecundarias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.vuelovmovil.InfoActivity;
import com.example.vuelovmovil.NotificationActivity;
import com.example.vuelovmovil.R;
import com.example.vuelovmovil.TableroActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActitivy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_actitivy);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.about);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), TableroActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notifications:
                        startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        return true;
                    case R.id.informacion:
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }
}