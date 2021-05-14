package com.example.shifer;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class watch extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.watch);
        int id = getIntent().getExtras().getInt("id");
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(DBHelper.TABLE_CONST,null,null,null,null,null,null);



        if(cursor.moveToFirst()){
            for(int i=1;i!=id;i++){
                cursor.moveToNext();
            }
            TextView iddata= findViewById(R.id.id);
            TextView NameShiferdata= findViewById(R.id.NameShifer);
            TextView Shiferdata= findViewById(R.id.Shifer);
            TextView Voddata= findViewById(R.id.Vod);
            TextView Rotrdata= findViewById(R.id.Rotr);
            TextView Itogdata= findViewById(R.id.Itog);
            int idIndex  =cursor.getColumnIndex(DBHelper.KEY_ID);
            int shifernameIndex= cursor.getColumnIndex(DBHelper.KEY_NAMESHIFR);
            int shiferIndex= cursor.getColumnIndex(DBHelper.KEY_SHIFER);
            int vodIndex =cursor.getColumnIndex(DBHelper.KEY_VOD);
            int rotrIndex =cursor.getColumnIndex(DBHelper.KEY_ROTR);
            int vivodIndex = cursor.getColumnIndex(DBHelper.KEY_VIVOD);


            iddata.setText("ID:= "+cursor.getString(idIndex));
            NameShiferdata.setText("Shifername:= "+cursor.getString(shifernameIndex));
            Shiferdata.setText("Shifer or deshifer:= "+cursor.getString(shiferIndex));
            Voddata.setText("Vod:= "+cursor.getString(vodIndex));
            Rotrdata.setText("Rotr:= "+cursor.getString(rotrIndex));
            Itogdata.setText("Itog:= "+cursor.getString(vivodIndex));
        }
        cursor.close();
    }

}
