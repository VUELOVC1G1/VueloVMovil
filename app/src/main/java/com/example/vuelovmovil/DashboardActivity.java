package com.example.vuelovmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vuelovmovil.Models.Asientos;
import com.example.vuelovmovil.Models.BoletoObjectClass;
import com.example.vuelovmovil.Models.Maletas;
import com.example.vuelovmovil.Models.Pago;
import com.example.vuelovmovil.Models.TipoAsiento;
import com.example.vuelovmovil.RespuestaBoleto.BoletoResponseObjectClass;
import com.example.vuelovmovil.Services.BoletoRetrofitCliente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardActivity extends AppCompatActivity {

    Pago pago;
    Maletas maletas;
    TipoAsiento tipoAsiento;
    Asientos asientos;
    TextView edtEmail;
    Button reservaBtn;

    private SharedPreferences preferences;

    int asiento = 211;

    //Implementacion de los campos
    TextView tvSelectDates1;

    EditText edMaletas;
    EditText edAsiento;
    EditText edtipoAsiento;

    //Botones asientos

    Button btn1;
    int i = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    int i11 = 0;
    int i12 = 0;
    int i13 = 0;

    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;

    CheckBox checkbox;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        preferences = getSharedPreferences("Preferences",MODE_PRIVATE);


        edMaletas = findViewById(R.id.edMaletas);

        //Botones asientos
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            btn1.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 2;
                        }else if(i == 2){
                            btn1.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 3;
                        }
                        i= 0;
                    }
                },500);

            }
        });
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i2++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i2 == 1){
                            btn2.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 4;
                        }else if(i2 == 2){
                            btn2.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 5;
                        }
                        i2 = 0;
                    }
                },500);

            }
        });


        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i3++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i3==1){
                            btn3.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 6;
                        }else if(i3 == 2){
                            btn3.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 7;
                        }
                        i3= 0;
                    }
                },500);

            }
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i4++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i4==1){
                            btn4.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 8;
                        }else if(i4 == 2){
                            btn4.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 9;
                        }
                        i4= 0;
                    }
                },500);

            }
        });

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i5++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i5==1){
                            btn5.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 10;
                        }else if(i5 == 2){
                            btn5.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 11;
                        }
                        i5= 0;
                    }
                },500);

            }
        });

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i6++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i6==1){
                            btn6.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 12;
                        }else if(i6 == 2){
                            btn6.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 13;
                        }
                        i6= 0;
                    }
                },500);

            }
        });

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i7++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i7==1){
                            btn7.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 14;
                        }else if(i7 == 2){
                            btn7.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 15;
                        }
                        i7= 0;
                    }
                },500);

            }
        });

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i8++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i8==1){
                            btn8.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 16;
                        }else if(i8 == 2){
                            btn8.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 17;
                        }
                        i8= 0;
                    }
                },500);

            }
        });

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i9++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i9==1){
                            btn9.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 18;
                        }else if(i9 == 2){
                            btn9.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 19;
                        }
                        i9= 0;
                    }
                },500);

            }
        });

        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i10++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i10==1){
                            btn10.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 20;
                        }else if(i10 == 2){
                            btn10.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 21;
                        }
                        i10= 0;
                    }
                },500);

            }
        });

        btn11 = findViewById(R.id.btn11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i11++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i11==1){
                            btn11.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 22;
                        }else if(i11 == 2){
                            btn11.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 23;
                        }
                        i11= 0;
                    }
                },500);

            }
        });

        btn12 = findViewById(R.id.btn12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i12++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i12==1){
                            btn12.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 24;
                        }else if(i12 == 2){
                            btn12.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 25;
                        }
                        i12= 0;
                    }
                },500);

            }
        });

        btn13 = findViewById(R.id.btn13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i13++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i13==1){
                            btn13.setBackgroundColor(Color.GRAY);
                            Toast.makeText(DashboardActivity.this, "Asiento seleccionado", Toast.LENGTH_SHORT).show();
                            asiento = 26;
                        }else if(i13 == 2){
                            btn13.setBackgroundColor(Color.WHITE);
                            Toast.makeText(DashboardActivity.this, "Asiento Borrado", Toast.LENGTH_SHORT).show();
                            asiento = 27;
                        }
                        i13= 0;
                    }
                },500);

            }
        });
        //edMaletas = findViewById(R.id.edMaletas);
        //edAsiento = findViewById(R.id.edAsiento);
        //edAsiento = findViewById(R.id.edtipoAsiento);

        //fechas aqui
        //fechas
        //tvSelectDates1 = findViewById(R.id.tvSelectDates1);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
/*
        tvSelectDates1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(DashboardActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        tvSelectDates1.setText(date);
                    }
                },year,month,day);
                dialog.show();
            }
        });
*/

        //fechas termina aqui

        reservaBtn = findViewById(R.id.reservaBtn);


        edtEmail = findViewById(R.id.edtEmail);

        checkbox = findViewById(R.id.uno);

        boolean isChecked = checkbox.isChecked();





        //  Llama el boton que inserta la reserva
        reservaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarReserva();


            }
        });



    }



    public void insertarReserva(){

//Inicializa el retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vuelav-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String pesomaletas = edMaletas.getText().toString();


        //Formulario Reserva
        pago = new Pago(true,"Diners Club",0);

        int valorpagoMaletas = (int) (Integer.parseInt(pesomaletas) * 0.50);
        maletas = new Maletas(pesomaletas,valorpagoMaletas);
        List<Maletas> ml = new ArrayList<>();
        ml.add(maletas);


        tipoAsiento = new TipoAsiento(0,"CLASE PASAJERO");

        int min = 10;
        int max = 20;

        Random random = new Random();

        int value = random.nextInt(max + min) + min;

        int totalasiento = (int) (value * 1.30);


        asientos = new Asientos(211,"Vuelo Comercial",totalasiento,tipoAsiento);
        List<Asientos> as = new ArrayList<>();
        as.add(asientos);



        int usuario_id = preferences.getInt("usuario_id",0);

        int valorId = usuario_id - 7;


        Log.e("estas son de boletoosssssssss", String.valueOf(usuario_id));


        BoletoObjectClass boletoObjectClass = new BoletoObjectClass(as,"2022-06-15T21:32:34.979Z",ml,pago,valorId,"https://vuelovc1g1.github.io/VuelaVG1C1fFront/inicio/buscarboleto/'+boleto.id",13);

        BoletoRetrofitCliente boletoRetrofitCliente = retrofit.create(BoletoRetrofitCliente.class);

        Call<BoletoResponseObjectClass> res =boletoRetrofitCliente.GetPostsValue(boletoObjectClass);
        res.enqueue(new Callback<BoletoResponseObjectClass>() {
            @Override
            public void onResponse(Call<BoletoResponseObjectClass> call, Response<BoletoResponseObjectClass> response) {

                Log.e("nombre","insertado");
             //   String idBoleto = response.body().getId();
              // Log.e("iddel boleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeto guardado",response.body().getId());
               startActivity(new Intent(DashboardActivity.this,MostrarDatosBoletoActivity.class));

            }

            @Override
            public void onFailure(Call<BoletoResponseObjectClass> call, Throwable t) {
                Log.e("response","failed");
                startActivity(new Intent(DashboardActivity.this,MostrarDatosBoletoActivity.class));

            }
        });




    }

    /*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),choice,Toast.LENGTH_LONG).show();
    }*/
}