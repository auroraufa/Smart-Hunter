package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smarthunter.model.RegisterUser;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.EventClient;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    TextInputEditText addUsername, addEmail, addPassword, addConfirmPassword;
    Button buttonnext;
    String confirmpassword,password, email, username;
    Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addEmail = findViewById(R.id.textInputemail);
        addUsername = findViewById(R.id.textInputusername);
        addPassword = findViewById(R.id.textInputPassword);
        addConfirmPassword = findViewById(R.id.textInputconfirm);
        buttonnext = findViewById(R.id.buttonnext);
        buttonnext.setOnClickListener(view -> toFavorite());

    }

    public void toLogin(View view) {
        Intent loginIntent = new Intent(Register.this, Login.class);
        startActivity(loginIntent);
    }

    public void toFavorite() {
        email = addEmail.getText().toString();
//        Toast.makeText(getApplicationContext(), email, Toast.LENGTH_SHORT).show();
        username = addUsername.getText().toString();
//        Toast.makeText(getApplicationContext(), username, Toast.LENGTH_SHORT).show();
        password = addPassword.getText().toString();
//        Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();
        confirmpassword = addConfirmPassword.getText().toString();

        if (password.isEmpty()) {
            Toast.makeText(this, "Mohon Password di Isi", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6) {
            Toast.makeText(this, "Password min 6 karakter", Toast.LENGTH_SHORT).show();
        } else if (password.equals(confirmpassword)) {
            Toast.makeText(this, "Password Sesuai", Toast.LENGTH_SHORT).show();

            EventClient eventClient = RetrofitClient.getEventClient();

            Call<RegisterUser> call = eventClient.addUser(email, username, password);

            call.enqueue(new Callback<RegisterUser>() {
                @Override
                public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                    RegisterUser user = response.body();
                    if (user != null) {
                        String token = user.getToken();
                        Integer userId = user.getIdUser();
                        SharedPreferences preferences = getSharedPreferences("com.example.smarthunter",MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("USERID",userId);
                        editor.putString("TOKEN",token);
                        editor.apply();

                    Intent regist = new Intent(getApplicationContext(), FavoriteRegister.class);
                    startActivity(regist);
                        Toast.makeText(getApplicationContext(), "Anda berhasil register akun anda,silahkan lanjutkan tambahkan kategori yang paling anda sukai", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Gagal", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterUser> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Gagal Mengakses Server", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (confirmpassword.isEmpty()) {
            Toast.makeText(this, "Mohon Konfirmasi Password", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_SHORT).show();
        }

    }

}