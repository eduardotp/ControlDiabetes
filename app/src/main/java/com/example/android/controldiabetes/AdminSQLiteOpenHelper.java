package com.example.android.controldiabetes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eduardo on 23/04/2016.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Pac.db";
    public static final String TABLE_NAME = "person";

    //llamamos al constructor
    //public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {
        //super(context, nombre, factory, version);
    public AdminSQLiteOpenHelper(Context context){
        super(context, DATABASE_NAME, null,1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    //creamos la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidop TEXT, apellidom TEXT, celular TEXT)");
    }

    //borrar la tabla y crear la nueva tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("DROP TABLE IF EXISTS");
        onCreate(db);
    }
}
