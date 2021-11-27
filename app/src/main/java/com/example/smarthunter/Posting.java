package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;

public class Posting extends AppCompatActivity {

    ImageButton back_posting ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        back_posting = (ImageButton) findViewById(R.id.Button_back_posting);

        back_posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

    });
}
    public void main(View view) {
        Intent main= new Intent(Posting.this, MainActivity.class);
        startActivity(main);
    }

    public void toPostWebinar(View view) {
        Intent PostWebinarIntent = new Intent(Posting.this, PostWebinar.class);
        startActivity(PostWebinarIntent);
    }

    public void toPostSeminar(View view) {
        Intent PostSeminarIntent = new Intent(Posting.this, PostSeminar.class);
        startActivity(PostSeminarIntent);
    }

    public void account(View view) {
        Intent account= new Intent(Posting.this, Account.class);
        startActivity(account);
    }

}
