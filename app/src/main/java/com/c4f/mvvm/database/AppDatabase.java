package com.c4f.mvvm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class AppDatabase extends SQLiteOpenHelper {
    private static final String TAG = "SmartProSQLite";

    private static final String DATABASE_NAME = "smart_pro";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "users";
    public static final String FIELD_USER_ID = "user_id";
    public static final String FIELD_USER_NAME = "user_name";

    public AppDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        db.execSQL("CREATE TABLE " + TABLE_USER + "("
                + FIELD_USER_ID + " INTEGER PRIMARY KEY,"
                + FIELD_USER_NAME + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
