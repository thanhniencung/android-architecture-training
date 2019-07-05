package com.c4f.mvvm.repository.repoImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.c4f.mvvm.database.AppDatabase;
import com.c4f.mvvm.model.User;

public class DiskUserDataStore implements UserDataStore {
    AppDatabase appDatabase;

    public DiskUserDataStore(Context context) {
        appDatabase = new AppDatabase(context);
    }

    @Override
    public void storeUser(User user) {
        SQLiteDatabase db = appDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AppDatabase.FIELD_USER_ID, user.getId());
        values.put(AppDatabase.FIELD_USER_NAME, user.getName());

        db.insert(AppDatabase.TABLE_USER, null, values);
        db.close();
    }

    @Override
    public User getUserById(String id) {
        SQLiteDatabase db = appDatabase.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(AppDatabase.TABLE_USER, new String[]{
                            AppDatabase.FIELD_USER_ID,
                            AppDatabase.FIELD_USER_NAME},
                    AppDatabase.FIELD_USER_ID + "=?",
                    new String[]{id}, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();

            User user = new User(
                    cursor.getString(0),
                    cursor.getString(1)
            );
            return user;
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }
}
