package com.example.vuelovmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vuelovmovil.Interface.JsonPlaceHolderApi;
import com.example.vuelovmovil.Model.Promociones;
import com.example.vuelovmovil.pantallasecundarias.AboutActitivy;
import com.example.vuelovmovil.sqlite.daos.PromocionesDaoImpl;
import com.example.vuelovmovil.sqlite.models.Promocion;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TableroActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    private PromocionesDaoImpl promocionesDao;

    private TextView mJsonTxtView;
    ListView listView;

    Button vervuelos;


    List<Promociones> promocionesList = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
       //

        preferences = getSharedPreferences("Preferences",MODE_PRIVATE);

        int usuario_id = preferences.getInt("usuario_id",0);

        Log.e("este es el id del shared preferencesssssssssssssss", String.valueOf(usuario_id));






        vervuelos = findViewById(R.id.vervuelos);

        vervuelos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(usuario_id > 0){

                    startActivity(new Intent(TableroActivity.this,VuelosReservados.class));

                }
//                startActivity(new Intent(TableroActivity.this,VuelosReservados.class).putExtra("data","100"));

            }
        });

        promocionesDao = new PromocionesDaoImpl(this);
//mJsonTxtView = findViewById(R.id.jsonText);
        listView = findViewById(R.id.listView);

        //MENUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
        //MENUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU

        //Metodo que trae las promociones//

        if (isNetworkAvailable()) {
            getPromociones();
        } else {
            Toast.makeText(this, "No estás conectado a internet!", Toast.LENGTH_LONG).show();
            getSavedPromociones();
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void getSavedPromociones() {
        List<Promocion> promocions = promocionesDao.getAll();
        loadPromocionesOnView(promocions);
    }

    private void loadPromocionesOnView(List<Promocion> promocionesList) {
        List<String> stringPromociones = new ArrayList<>();
        for (Promocion promocion : promocionesList) {
            String content = "";
            content += "            OFERTA DISPONIBLE!" + "\n";
            content += promocion.getDescripcion() + "\n";
            content += "APROVECHA DESCUENTO : " + promocion.getDescuento() + "%" + "\n";
            content += "PRECIO : $" + promocion.getPrecio() + "\n";
            content += "SALIDA : " + promocion.getFechaVuelo() + "\n";
            content += "RUTA VIAJE : " + promocion.getRutaDescripcion() + "\n";
            content += "DESDE : " + promocion.getOrigen() + "\n";
            content += "HASTA : " + promocion.getDestino() + "\n\n";
            stringPromociones.add(content);
        }

        promocionesList.forEach(p -> {
            promocionesDao.save(p);
        });


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, stringPromociones);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {




                startActivity(new Intent(TableroActivity.this, DashboardActivity.class));
                } else if (position == 1) {



                   startActivity(new Intent(TableroActivity.this, DashboardActivity.class));

                } else if (position == 2) {



                    startActivity(new Intent(TableroActivity.this, DashboardActivity.class));

                } else if (position == 3) {



                  startActivity(new Intent(TableroActivity.this, DashboardActivity.class));

                } else if (position == 4) {

                    startActivity(new Intent(TableroActivity.this, DashboardActivity.class));

                } else if (position == 5) {


                   startActivity(new Intent(TableroActivity.this, DashboardActivity.class));

                } else if (position == 6) {

                    startActivity(new Intent(TableroActivity.this, DashboardActivity.class));

                }
            }
        });
    }

    private void getPromociones() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vuelav-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Promociones>> call = jsonPlaceHolderApi.getPromociones();

        call.enqueue(new Callback<List<Promociones>>() {
            @Override
            public void onResponse(Call<List<Promociones>> call, Response<List<Promociones>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                promocionesList = response.body();
                promocionesDao.deleteAll();

                List<Promocion> promocions = promocionesList.stream()
                        .filter(promociones -> promociones.getVuelo().isEstado()==true)
                        .map(p -> promocioResponseToModel(p))
                        .collect(Collectors.toList());

                loadPromocionesOnView(promocions);
            }

            @Override
            public void onFailure(Call<List<Promociones>> call, Throwable t) {
                // mJsonTxtView.setText(t.getMessage());
            }
        });
    }

    private Promocion promocioResponseToModel(Promociones p) {
        Promocion promocion = new Promocion();
        promocion.setId((long) p.getId());
        promocion.setDescripcion(p.getDescripcion());
        promocion.setFechaVuelo(p.getVuelo().getFechaVuelo());
        promocion.setDescuento(p.getDescuento());
        promocion.setPrecio(p.getVuelo().getPrecio());
        promocion.setRutaDescripcion(p.getVuelo().getRutaResponse().getDescripcion());
        promocion.setOrigen(p.getVuelo().getRutaResponse().getOrigen());
        promocion.setDestino(p.getVuelo().getRutaResponse().getDestino());
        return promocion;
    }
}