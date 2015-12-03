package com.example.dell.sqlite_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

/**
 * Created by DELL on 02/12/2015.
 */
public class HandlerSQLite extends SQLiteOpenHelper {
    public HandlerSQLite(Context context) {
        super(context, "Mi base", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, user TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST usuarios");
        onCreate(db);

    }

    public void abrir() {
        this.getWritableDatabase();
    }


    public void cerrar() {
        this.close();
    }

    public void insertarReg (String user, String password) {
        ContentValues values = new ContentValues();
        values.put("user", user);
        values.put("password", password);
        this.getWritableDatabase().insert("usuarios", null, values);

    }

    public String leer() {
        String resultado = "";
        String columnas[] = {_ID, "user", "password"};
        Cursor cursor = this.getReadableDatabase().query("usuarios", columnas, null, null, null, null, null);
        int id, iu, ip;
        id = cursor.getColumnIndex(_ID);
        iu = cursor.getColumnIndex("user");
        ip = cursor.getColumnIndex("password");
        cursor.moveToLast();
        resultado = cursor.getString(id) + ", " + cursor.getString(iu) + ", "+cursor.getString(ip);
        return resultado;
    }
}
