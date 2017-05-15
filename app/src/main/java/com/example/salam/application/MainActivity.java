package com.example.salam.application;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mNomET;
    private EditText mLocalET;
    private Myhelper mMayHelper;
    private SQLiteDatabase mSQLiteDb;
    private EditText mSite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNomET = (EditText) findViewById(R.id.editText);
        mLocalET= (EditText) findViewById(R.id.editText2);
        mSite= (EditText) findViewById(R.id.editText3);
        mMayHelper = new Myhelper(MainActivity.this,"STUDDB", null,1);
        mSQLiteDb =mMayHelper.getWritableDatabase();

    }

    public void insertData(View view) {
        ContentValues cv= new ContentValues();
        cv.put("name",mNomET.getText().toString());
        cv.put("local", mLocalET.getText().toString());
        cv.put("site", mSite.getText().toString());

        long id = mSQLiteDb.insert("club",null,cv);
        Toast.makeText(MainActivity.this,String.valueOf(id), Toast.LENGTH_LONG).show();

    }

    public void readData(View view) {

        Cursor c =mSQLiteDb.query("club", null, null, null, null, null, null);
        while(c.moveToNext()){
            Toast.makeText(MainActivity.this, c.getString(c.getColumnIndex("name")), Toast.LENGTH_LONG).show();
           // Toast.makeText(MainActivity.this, c.getString(c.getColumnIndex("local")), Toast.LENGTH_LONG).show();
            //Toast.makeText(MainActivity.this, c.getString(c.getColumnIndex("site")), Toast.LENGTH_LONG).show();
        }
    }
}
