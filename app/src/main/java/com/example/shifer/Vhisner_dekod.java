package com.example.shifer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Vhisner_dekod extends AppCompatActivity {
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vhisner_dekod);
        Button nazat = findViewById(R.id.nazat);
        Button save = findViewById(R.id.save);
        dbHelper = new DBHelper(this);
        nazat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vhisner_dekod.this, Vhisner.class);
                startActivity(intent);
            }
        });
        String text=" ";
        String b = getIntent().getExtras().getString("b");
        final String b1 = b ;
        String rot = getIntent().getExtras().getString("rot");
        shifer shifer = new  shifer();
        text = text= String.valueOf(shifer.vhisnerdekod(b,rot));
        TextView texts = findViewById(R.id.Vivod);
        texts.setText(text);
        final String text1= text;

        final String rot1=rot;

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper.KEY_NAMESHIFR,"Vhisner");
                contentValues.put(DBHelper.KEY_SHIFER,"Deshifer");
                contentValues.put(DBHelper.KEY_ROTR,rot1);
                contentValues.put(DBHelper.KEY_VOD,b1);
                contentValues.put(DBHelper.KEY_VIVOD, text1);
                database.insert(DBHelper.TABLE_CONST,null,contentValues);
            }
        });
    }
}

