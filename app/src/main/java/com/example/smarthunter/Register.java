package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smarthunter.model.RegisterUser;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.eventClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    TextInputEditText addUsername, addEmail, addPassword, addConfirmPassword;
    Button buttonnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addEmail = findViewById(R.id.textInputemail);
        addUsername = findViewById(R.id.textInputUser);
        addPassword = findViewById(R.id.textInputPassword);
        addConfirmPassword = findViewById(R.id.textInputconfirm);
        buttonnext = findViewById(R.id.buttonnext);
        buttonnext.setOnClickListener(v -> confirmPw(addPassword));
    }

    private void confirmPw(TextInputEditText addPassword) {
        String password = addPassword.getText().toString();
        String confirmpassword = addConfirmPassword.getText().toString();

        if (password.isEmpty()) {
            Toast.makeText(this, "Mohon Password di Isi", Toast.LENGTH_SHORT).show();
        } else if (addPassword.length() < 6) {
            Toast.makeText(this, "Password min 6 karakter", Toast.LENGTH_SHORT).show();
        } else if (addPassword.equals(confirmpassword)) {
            Toast.makeText(this, "Password Sesuai", Toast.LENGTH_SHORT).show();
            TextInputLayout cekLayout = findViewById(R.id.textInputconfirm);
            cekLayout.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
            cekLayout.setEndIconDrawable(R.drawable.ic_baseline_check_circle_24);
        } else if (confirmpassword.isEmpty()) {
            Toast.makeText(this, "Mohon Konfirmasi Password", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_SHORT).show();
        }
    }

    public void toLogin(View view) {
        Intent loginIntent = new Intent(Register.this, Login.class);
        startActivity(loginIntent);
    }

    public void toFavorite(View view) {
        String email = addEmail.getText().toString();
        String username = addUsername.getText().toString();
        String password = addPassword.getText().toString();

        eventClient eventClient = RetrofitClient.getEventClient();

        Call<RegisterUser> call = eventClient.addUser(email, username, password);

        call.enqueue(new Callback<RegisterUser>() {
            @Override
            public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                RegisterUser user = response.body();
                if (user != null) {

                }
            }

            @Override
            public void onFailure(Call<RegisterUser> call, Throwable t) {

            }
        });



        Intent favoriteIntent = new Intent(Register.this, Favorite.class);
        startActivity(favoriteIntent);
    }
}