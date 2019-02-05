package com.example.administrator.studentregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Dbname="MYDB.db";
    public static final String TableName="student";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="email";
    public static final String col4="mob";
    public static final String col5="username";
    public static final String col6="password";


    public DatabaseHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+TableName+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query=" drop table if exists " +TableName;
        db.execSQL(query);
        onCreate(db);

    }

    public boolean insertdata(String name,String email,String mob,String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,email);
        contentValues.put(col4,mob);
        contentValues.put(col5,username);
        contentValues.put(col6,password);

        long status=db.insert(TableName,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor searchdata(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery("SELECT * FROM "+TableName+" WHERE "+col5+"='"+username+"'",null);
        return cur;
    }
}

