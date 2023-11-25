package com.example.loginandsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DaoUser {
    private Db_Helper dbHelper;

    public DaoUser(Context context){
        dbHelper = new Db_Helper(context);
    }

    public boolean CheckLogin(String email, String pass, String er_pass){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * From KhachHang Where email = ? AND matkhau = ? And nhaplaiMK", new String[]{email, pass, er_pass});
        return cursor.getCount() > 0;
    }

    public boolean Register(String email, String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("matkhau", password);

        long check = sqLiteDatabase.insert("KhachHang", null, contentValues);
        return check != -1;
    }
}
