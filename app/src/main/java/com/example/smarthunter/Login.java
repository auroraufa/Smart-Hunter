package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smarthunter.model.DataLogin;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.EventClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void toRegist(View view) {
        Intent registIntent = new Intent(Login.this, Register.class);
        startActivity(registIntent);
    }

    public void toMain(View view) {

        EditText editUsername;
        EditText editPassword;

        editUsername = findViewById(R.id.textInputUser);
        editPassword = findViewById(R.id.textInputPass);

        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        EventClient eventClient = RetrofitClient.getEventClient();

        Call<DataLogin> call = eventClient.checkLogin(username, password);

        call.enqueue(new Callback<DataLogin>() {
            @Override
            public void onResponse(Call<DataLogin> call, Response<DataLogin> response) {
                DataLogin datalogin = response.body();
                if (datalogin != null) {
                    String token = datalogin.getToken();
                    Integer userId = datalogin.getId();

                    SharedPreferences preferences = getSharedPreferences("com.example.smarthunter",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("USERID",userId);
                    editor.putString("TOKEN",token);
                    editor.apply();

                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainIntent);

                } else {
                    Toast.makeText(getApplicationContext(), "Username/Password Anda salah, silahkan inputkan kembali", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Akses server", Toast.LENGTH_SHORT).show();
            }
        });
    }

}