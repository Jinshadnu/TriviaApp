package com.example.triviaapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.triviaapp.Model.Answers;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="triviaapp";// Database Name
    public static final String TABLE_NAME="Quiz";// Table Name
    private static final int DATABASE_Version = 1;// Database Version
    public static final String Name="name";
    public static final String Cricketer_name="cricketer_name";
    public static final String Flag_colors="flag_colors";
    private static final String CREATE_TABLE="CREATE TABLE " +TABLE_NAME+ "("+Name+" VARCHAR(255) ,"+Cricketer_name+" VARCHAR(500),"+Flag_colors+" VARCHAR(600));";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DROP_TABLE);
    onCreate(db);
    }
    //To insert Data in to Database
    public long insert(String name,String cricketer_name,String colors){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Name,name);
        values.put(Cricketer_name,cricketer_name);
        values.put(Flag_colors,colors);
        long id = sqLiteDatabase.insert(TABLE_NAME, null , values);
        return id;
    }
// to fetch all data from the database
    public List<Answers>getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<Answers> list = new ArrayList<>();
        String select_query = "Select * from " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(select_query, null);
        if (cursor.moveToNext()) {
            do {
                Answers answers = new Answers();
                answers.name = cursor.getString(cursor.getColumnIndex(Name));
                answers.cricketer_name = cursor.getString(cursor.getColumnIndex(Cricketer_name));
                answers.flag_color = cursor.getString(cursor.getColumnIndex(Flag_colors));
                list.add(answers);
            }
         while (cursor.moveToNext()) ;
    }

        return list;
    }
}
