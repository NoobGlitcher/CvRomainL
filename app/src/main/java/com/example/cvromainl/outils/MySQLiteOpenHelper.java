package com.example.cvromainl.outils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteOpenHelper extends SQLiteOpenHelper

{

    private String creation = "create table Chapitre("

            +"Numero INTEGER NOT NULL,"
            +"Ouvert INTEGER NOT NULL);";


    private String creationObjet = "create table Objet("

            +"Numero INTEGER NOT NULL,"
            +"Ouvert INTEGER NOT NULL);";


    private String creationActions = "create table Actions("

            +"Numero INTEGER NOT NULL,"
            +"Ouvert INTEGER NOT NULL);";





    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creation);
        sqLiteDatabase.execSQL(creationObjet);
        sqLiteDatabase.execSQL(creationActions);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @SuppressLint("Range")
    public List<String> getData(String parameter) {
        List<String> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM table WHERE column = ?", new String[] {parameter});
        if (cursor.moveToFirst()) {
            do {
                dataList.add(cursor.getString(cursor.getColumnIndex("column")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return dataList;
    }

}

