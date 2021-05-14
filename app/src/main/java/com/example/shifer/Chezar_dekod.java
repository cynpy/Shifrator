package com.example.shifer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chezar_dekod  extends AppCompatActivity {
    DBHelper dbHelper;
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
        Button save = findViewById(R.id.save);
        dbHelper = new DBHelper(this);
        int rot=1;
        String rots = getIntent().getExtras().getString("rot");
        String text="";
        String b = getIntent().getExtras().getString("b");
        final String b1 = b ;
        rot = Integer.parseInt(rots);
        shifer shifer = new  shifer();
        text = String.valueOf(shifer.chezardekod(b,rot));
        TextView texts = findViewById(R.id.Vivod);
        texts.setText(text);

        final String rots1=rots;
        final String text1= text;

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper.KEY_NAMESHIFR,"Chezar");
                contentValues.put(DBHelper.KEY_SHIFER,"Deshifer");
                contentValues.put(DBHelper.KEY_ROTR,rots1);
                contentValues.put(DBHelper.KEY_VOD,b1);
                contentValues.put(DBHelper.KEY_VIVOD, text1);
                database.insert(DBHelper.TABLE_CONST,null,contentValues);
            }
        });
    }
}

