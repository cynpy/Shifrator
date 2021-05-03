package com.example.shifer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Chezar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chezar);

        Button kod = findViewById(R.id.kod);
        Button dekod = findViewById(R.id.dekod);
        Button nazat = findViewById(R.id.nazat);
        nazat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chezar.this, MainActivity.class);
                startActivity(intent);
            }
        });
        kod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText vod =findViewById(R.id.vod);
                EditText rotr =findViewById(R.id.rotr);

                Intent intent = new Intent(Chezar.this,Chezar_kod.class);
                intent.putExtra("b", vod.getText().toString());
                intent.putExtra("rot",rotr.getText().toString());
                startActivity(intent);
            }
        });
        dekod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText vod =findViewById(R.id.vod);
                EditText rotr =findViewById(R.id.rotr);
                Intent intent = new Intent(Chezar.this,Chezar_dekod.class);
                intent.putExtra("b", vod.getText().toString());
                intent.putExtra("rot",rotr.getText().toString());
                startActivity(intent);
            }
        });



    }
}
