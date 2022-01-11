package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smarthunter.model.Message;
import com.example.smarthunter.retrofit.EventClient;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Edit extends AppCompatActivity {

    Button update;
    TextInputEditText nama, email, oldPassword, newPassword;
    String name, mail, oldPass, newPass;

    EventClient eventClient = RetrofitClient.getEventClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        nama = findViewById(R.id.inputname);
        email = findViewById(R.id.inputemail);
        update = findViewById(R.id.update);
        oldPassword = findViewById(R.id.inputpassword);
        newPassword = findViewById(R.id.inputpassword5);
        update.setOnClickListener(view -> goupdate());

//        nama = findViewById(R.id.inputname);
//        email =
    }

    public void goupdate() {
        SharedPreferences preferences = getSharedPreferences(
                "com.example.smarthunter",
                MODE_PRIVATE
        );

        String token = preferences.getString("TOKEN", null);
        Integer userId = preferences.getInt("USERID",0);

        name = nama.getText().toString();
        mail = email.getText().toString();
        oldPass = oldPassword.getText().toString();
        newPass = newPassword.getText().toString();


      EventClient eventClient = RetrofitClient.getEventClient();
      Call<Message> call = eventClient.updateProfile(token ,userId ,name, mail, oldPass, newPass);

      call.enqueue(new Callback<Message>() {
          @Override
          public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
              if (message!=null) {
                  Intent update = new Intent(getApplicationContext(), Account.class);
                  startActivity(update);
                  Toast.makeText(getApplicationContext(), "Data anda berhasil dirubah", Toast.LENGTH_SHORT).show();
              }
              else {
                  Toast.makeText(getApplicationContext(), "Gagal Merubah data", Toast.LENGTH_SHORT).show();
              }

          }

          @Override
          public void onFailure(Call<Message> call, Throwable t) {
              Toast.makeText(getApplicationContext(), "Gagal Mengakses Server", Toast.LENGTH_SHORT).show();
          }
      });
//        Intent mainIntent = new Intent(this, Account.class);
//        startActivity(mainIntent);
    }

    public void gprofil(View view) {
        Intent mainIntent = new Intent(this, Account.class);
        startActivity(mainIntent);
    }

    public void posting(View view) {
        Intent mainIntent = new Intent(this, Posting.class);
        startActivity(mainIntent);
    }

    public void main(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    public void account(View view) {
        Intent account= new Intent(Edit.this, Account.class);
        startActivity(account);
    }



}