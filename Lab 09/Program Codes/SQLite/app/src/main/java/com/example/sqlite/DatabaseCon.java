package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;

public class DatabaseCon extends SQLiteOpenHelper {

    private static final String DB_NAME = "registration_details";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String ID_COL = "id";
    private static final String FIRST_NAME_COL = "fname";
    private static final String LAST_NAME_COL = "lname";
    private static final String PHONE_NO_COL = "phone";

    public DatabaseCon(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIRST_NAME_COL + " TEXT,"
                + LAST_NAME_COL + " TEXT,"
                + PHONE_NO_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewUser(String fname, String lname, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIRST_NAME_COL, fname);
        values.put(LAST_NAME_COL, lname);
        values.put(PHONE_NO_COL, phone);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
