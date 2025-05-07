package com.example.a3_l215819.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "task_manager.db";
    public static final int DB_VERSION = 1;

    public static final String TASKS_TABLE = "tasks";
    public static final String NOTIFICATIONS_TABLE = "notifications";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTasksTable = "CREATE TABLE " + TASKS_TABLE + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "description TEXT, " +
                "datetime TEXT, " +
                "status TEXT)";
        db.execSQL(createTasksTable);

        String createNotificationsTable = "CREATE TABLE " + NOTIFICATIONS_TABLE + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "message TEXT, " +
                "datetime TEXT)";
        db.execSQL(createNotificationsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TASKS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + NOTIFICATIONS_TABLE);
        onCreate(db);
    }
}
