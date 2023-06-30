package com.example.appmovie.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng để lưu thông tin người dùng
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT,email TEXT ,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Cập nhật bảng
        db.execSQL("DROP TABLE IF EXISTS users");

        onCreate(db);
    }
    public boolean checkLogin( String account , String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                "users",
                new String[]{"id"},
                "username = ? AND password = ?",
                new String[]{account , password},
                null,null,null
        );
        if(cursor.moveToFirst()){
            cursor.close();
            return true;
        }
        return false;
    }
    public String checkEmail(String username ,  String email){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                "users" ,
                new String[]{"password"} ,
                "email = ? AND username = ?" ,
                new String[]{email , username} ,
                null , null , null);
        if(cursor.moveToFirst()){
            String pass = cursor.getString(0);
            cursor.close();
            return pass;
        }
        return "";
    }


    public boolean checkOldpassword( String oldpassword){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                "users",
                new String[]{"id"},
                " password = ?",
                new String[]{ oldpassword},
                null,null,null
        );
        if(cursor.moveToFirst()){
            cursor.close();
            return true;
        }
        return false;
    }

    public boolean updatePassword( String newpassword) {
        SQLiteDatabase db = getWritableDatabase();

        // Thay đổi mật khẩu của người dùng
        String id  = "1";
        String newPassword = newpassword;
        ContentValues values = new ContentValues();
        values.put("password", newpassword);
        int rows = db.update("users", values, "id = ?", new String[] { id });

        // Đóng cơ sở dữ liệu khi hoàn thành các thao tác cập nhật
        db.close();
        return rows >0;
    }


    public  boolean addAccount(String username , String email , String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);


        // after adding all values we are passing
        // content values to our table.

        long row = db.insert("users", null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
        return row >0;
    }


}