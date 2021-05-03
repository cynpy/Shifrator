package com.example.shifer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next= findViewById(R.id.next);
       next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spiner = findViewById(R.id.spinner);
                int f= (int) spiner.getSelectedItemPosition();
                if(f==0) {
                    Intent intent = new Intent(MainActivity.this, Chezar.class);
                    startActivity(intent);
                }
                if(f==1) {
                    Intent intent = new Intent(MainActivity.this, Vhisner.class);
                    startActivity(intent);
                }
            }
        });





    }
}