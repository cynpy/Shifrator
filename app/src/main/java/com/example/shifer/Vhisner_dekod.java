package com.example.shifer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Vhisner_dekod extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vhisner_dekod);
        Button nazat = findViewById(R.id.nazat);
        nazat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vhisner_dekod.this, Vhisner.class);
                startActivity(intent);
            }
        });
        String text=" ";
        String b = getIntent().getExtras().getString("b");
        String rot = getIntent().getExtras().getString("rot");
        shifer shifer = new  shifer();
        text = text= String.valueOf(shifer.vhisnerdekod(b,rot));
        TextView texts = findViewById(R.id.vivod);
        texts.setText(text);
    }
}

