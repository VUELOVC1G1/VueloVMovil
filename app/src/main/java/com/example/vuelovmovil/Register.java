package com.example.vuelovmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vuelovmovil.Models.MainObjectClass;
import com.example.vuelovmovil.Response.MainResponseObjectClass;
import com.example.vuelovmovil.Services.OurRetrofitClient;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    dataObjectClass usuarios;
    EditText cedula;
    EditText nombre;
    EditText apellido;
    //fechaNacimientopendiente;
    EditText correo;
    EditText password;
    TextView tvSelectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        cedula = findViewById(R.id.edCedula);
        nombre = findViewById(R.id.edNombre);
        apellido = findViewById(R.id.edApellido);
        //fechas
        tvSelectDate = findViewById(R.id.tvSelectDate);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month+1;
                    String date = day+"/"+month+"/"+year;
                    tvSelectDate.setText(date);
                    }
                },year,month,day);
                dialog.show();
            }
        });



        //variables usuario
        correo = findViewById(R.id.edCorreo);
        password = findViewById(R.id.edPassword);

        final AppCompatButton singUpBtn = findViewById(R.id.signUpBtn);
        final TextView loginBtn = findViewById(R.id.loginBtn);



        //Metodos de los botones login y registrarse en la interfaz
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //going to login activity
              startActivity(new Intent(Register.this,Login.class));
                finish();
            }
        });

        //Metodo del boton de registrase
        singUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle your sign up heree.....


                registerUsuario();


                //then open MainActivity after successfully sign up
               // startActivity(new Intent(Register.this,Login.class));
                //Toast.makeText(Register.this, "Ahora Ingresa tus Datos", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Register.this,Login.class));
        finish();
    }

    public void registerUsuario(){

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vuelav-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usuarios = new dataObjectClass(correo.getText().toString(),password.getText().toString());

        //Metodo dos
        MainObjectClass mainObjectClass = new MainObjectClass(cedula.getText().toString(),nombre.getText().toString(),apellido.getText().toString(),"2001-06-09T16:31:42.156Z",usuarios);
        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);
        Call<MainResponseObjectClass> res = ourRetrofitClient.GetPostValue(mainObjectClass);

        res.enqueue(new Callback<MainResponseObjectClass>() {
            @Override
            public void onResponse(Call<MainResponseObjectClass> call, Response<MainResponseObjectClass> response) {

                String nombre = response.body().getNombre();

                Log.e("nombre",nombre);
                Toast.makeText(Register.this, "Ahora Ingresa a tu cuenta con tu datos", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<MainResponseObjectClass> call, Throwable t) {

                Log.e("response","failed");

            }
        });

    }
}
