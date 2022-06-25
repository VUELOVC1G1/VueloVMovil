package com.example.vuelovmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vuelovmovil.Models.LoginRequest;
import com.example.vuelovmovil.Models.LoginResponse;
import com.example.vuelovmovil.notifications.UserTokenRequest;
import com.example.vuelovmovil.sqlite.daos.UsuarioDaoImpl;
import com.example.vuelovmovil.sqlite.models.Usuario;
import com.google.firebase.messaging.FirebaseMessaging;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private UsuarioDaoImpl usuarioDao;
    private String token;

    EditText correo;
    EditText password;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioDao = new UsuarioDaoImpl(this);
        correo = findViewById(R.id.edCorreo);
        password = findViewById(R.id.edPassword);


        final AppCompatButton loginBtn = findViewById(R.id.loginBtn);
        final TextView singUpBtn = findViewById(R.id.signUpBtn);

        preferences = getSharedPreferences("Preferences",MODE_PRIVATE);




        singUpBtn.setOnClickListener(v -> {
            startActivity(new Intent(Login.this, Register.class));
            finish();
        });

        loginBtn.setOnClickListener(v -> {
            //handle your login....
            if (TextUtils.isEmpty(correo.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                Toast.makeText(Login.this, "Correo / Password Requeridos", Toast.LENGTH_SHORT).show();
            } else {
                //proceed to Login
                login();
            }
            //then open MainActivity after succesfully login
            // startActivity(new Intent(Login.this, MainActivity.class));
            //finish();
        });
        comprobarLogin();
    }

    private void getToken(long userId) {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                        return;
                    }
                    String token = task.getResult();
                    Log.d(TAG, "TOKENN: => : " + token);
                    sendToken(userId, token);
                });
    }

    private void comprobarLogin() {
        Usuario usuario = usuarioDao.getUser();
        if (usuario != null) {
            startActivity(new Intent(Login.this, TableroActivity.class));
            finish();
        }
    }

    private void sendToken(long userId, String token) {
        UserTokenRequest request = new UserTokenRequest(token, userId);
        System.out.println("CLASSTOKEN ===> " + token);

        Call<ResponseBody> call = ApiClient.getTokenService().saveToken(request);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: Token saved!");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: Error send token!");
            }
        });
    }

    public void login() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setCorreo(correo.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(Login.this, " Sesion Iniciada Correctamente!!", Toast.LENGTH_SHORT).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(() -> {

                        Log.d("id", String.valueOf(response.body().getId()));
                        Log.d("nombre", response.body().getEmail());

                        usuarioDao.deleteAll();

                        Usuario usuario = new Usuario((long) loginResponse.getId(), loginResponse.getEmail(), loginResponse.getPassword());
                        usuarioDao.save(usuario);

                        getToken(usuario.getId());

                        //Aqui es despues del login manda al menu principal
                        SharedPreferences.Editor  editor = preferences.edit();
                        editor.putInt("usuario_id",response.body().getId());
                        editor.commit();

                        startActivity(new Intent(Login.this, TableroActivity.class));

                    }, 10000);
                } else {
                    Toast.makeText(Login.this, "Inicio de Sesion Fallido", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Throwable" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();

            }
        });
    }


}