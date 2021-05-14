package com.example.shifer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class Data extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
        Button nazat = findViewById(R.id.nazat);
        Button next = findViewById(R.id.next);
        nazat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Data.this, MainActivity.class);
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Data.this, upravlenue.class);
                startActivity(intent);
            }
        });
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        GridView gridView = findViewById(R.id.gridview);

        Cursor cursor = database.query(DBHelper.TABLE_CONST, null, null, null, null, null, null);

        ArrayList<String> data = null;
        if (cursor.moveToFirst()) {
            boolean create = false;
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int shifernameIndex = cursor.getColumnIndex(DBHelper.KEY_NAMESHIFR);
            int shiferIndex = cursor.getColumnIndex(DBHelper.KEY_SHIFER);
            int vodIndex = cursor.getColumnIndex(DBHelper.KEY_VOD);
            int rotrIndex = cursor.getColumnIndex(DBHelper.KEY_ROTR);
            int vivodIndex = cursor.getColumnIndex(DBHelper.KEY_VIVOD);
            data = new ArrayList<>();
            do {

                if (!create) {
                    data = new ArrayList<String>(Arrays.asList(cursor.getString(idIndex) + " "
                            + cursor.getString(vivodIndex)));
                    create = true;
                } else {
                    data.add(cursor.getString(idIndex) + " "
                            + cursor.getString(vivodIndex));
                }
            } while (cursor.moveToNext());
            create = true;
        }
        cursor.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        gridView.setAdapter(adapter);
    }

}




