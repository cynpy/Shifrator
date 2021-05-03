package com.example.shifer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chezar_dekod  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chezar_dekod);
        Button nazat = findViewById(R.id.nazat);
        nazat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chezar_dekod.this, Chezar.class);
                startActivity(intent);
            }
        });

        int rot=1;
        String rots = getIntent().getExtras().getString("rot");
        String text="";
        String b = getIntent().getExtras().getString("b");
        rot = Integer.parseInt(rots);
        shifer shifer = new  shifer();
        text = String.valueOf(shifer.chezardekod(b,rot));
        TextView texts = findViewById(R.id.vivod);
        texts.setText(text);
    }
}

