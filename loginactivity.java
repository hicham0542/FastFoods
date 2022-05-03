package com.sari3food.sari3fooooooooood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginactivity extends AppCompatActivity {
    Button btnsignup,btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        btnsignup = findViewById(R.id.button4);
        btnlogin = findViewById(R.id.button2);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(loginactivity.this,signupactivity.class);
                startActivity(in);

            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2= new Intent(loginactivity.this,homeactivity.class);
                startActivity(in2);

            }
        });
    }
}
