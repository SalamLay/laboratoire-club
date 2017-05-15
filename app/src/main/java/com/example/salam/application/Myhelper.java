package com.example.salam.application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by salam on 24/04/17.
 */

public class Myhelper extends SQLiteOpenHelper {




    public Myhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table club(_id integer primary key, name text, local text, site text");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists club;");

    }
    /*public  void insert_club(String name, String local, String site){
        Con
    }*/
}
