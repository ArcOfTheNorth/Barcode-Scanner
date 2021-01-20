package com.example.qrscanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;

import static android.os.Build.ID;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String databaseName = "ID.Name";
    private static final String tableName = "teacher_table";



    public DataBaseHelper(Context context) {
        super(context, databaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table " + tableName +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT, barcode INTEGER )";
        db.execSQL(createTable);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    public boolean addText(String text, String barcode) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", text);
        contentValues.put("barcode", barcode);
        sqLiteDatabase.insert(tableName, null, contentValues);
        return true;
    }

    public ArrayList getAllText(){
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    ArrayList<String> arrayList = new ArrayList<String>();
    return arrayList;
    }


}