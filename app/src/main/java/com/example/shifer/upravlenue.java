package com.example.shifer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class upravlenue extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upravlenuedata);
        DBHelper dbHelper;
        int id;
        dbHelper = new DBHelper(this);
        final SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        boolean create=false;

        Button nazat = findViewById(R.id.nazat);
        nazat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(upravlenue.this, Data.class);
                startActivity(intent);
            }
        });
        Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText vod = findViewById(R.id.vod);
                final int id= getIntent().getExtras().getInt("id");
                database.delete(DBHelper.TABLE_CONST,DBHelper.KEY_ID + "=" + id,null);
            }
        });
        Button next = findViewById(R.id.watch);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(upravlenue.this, watch.class);
                EditText vod = findViewById(R.id.vod);
                final int id= getIntent().getExtras().getInt("id");
                        intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
