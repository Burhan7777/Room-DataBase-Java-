package com.example.room.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {ContactEntity.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {


    public abstract ContactDAO getDAO();


    private static MyDatabase database = null;

    // MAKING DATABASE OBJECT SINGLETON
    public static MyDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "contacts").allowMainThreadQueries().build();
        }
        return database;
    }

}
