package com.coempperu.appmovil.coemptransp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coempperu.appmovil.coemptransp.io.MyApiAdapter;
import com.coempperu.appmovil.coemptransp.io.responses.LoginResponse;
import com.coempperu.appmovil.coemptransp.ui.MenuActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<LoginResponse> {

    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }


    @Override
    public void onClick(View v) {
        final String username = etEmail.getText().toString();
        final String password = etPassword.getText().toString();
        Call<LoginResponse> call = MyApiAdapter.getApiService().getLogin(username, password);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if (response.isSuccessful()) {
            LoginResponse loginResponse = response.body();
            final String company = loginResponse.getCompany();

            if (company == null) {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Bienvenido "+company, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Mensaje de respuesta desconocido", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        Toast.makeText(this, "Sin internet", Toast.LENGTH_SHORT).show();
    }
}
