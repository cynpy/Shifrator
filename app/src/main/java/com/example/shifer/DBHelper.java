package com.example.shifer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static  final int DATABAZE_VERSION=3;
    public static  final String DATABAZE_NAME="Shifer";
    public static  final String TABLE_CONST="Shifer";

    public static  final String KEY_ID="_id";
    public static  final String KEY_NAMESHIFR="NameShifer";
    public static  final String KEY_SHIFER="Shifr";
    public static  final String KEY_VOD="Vod";
    public static  final String KEY_ROTR="Rort";
    public   static  final String KEY_VIVOD="Vivod";
    public DBHelper(@Nullable Context context) {
        super(context, DATABAZE_NAME, null, DATABAZE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_CONST + " ( "+ KEY_ID
        + " integer primary key, " + KEY_NAMESHIFR + " text, " + KEY_SHIFER + " text, " + KEY_VOD + " text, " +
                KEY_ROTR + " text, " + KEY_VIVOD + " text" + " ) "
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONST );
        onCreate(db);
    }
}
