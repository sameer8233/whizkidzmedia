package com.kidz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kidz.modal.pojo.Dbpojo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "videodb";

    private static final String TABLE_VIDEOS = "watchedvideos";

    private static final String KEY_ID = "videoid";
    private static final String KEY_NAME = "title";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_VIDEOS_TABLE = "CREATE TABLE " + TABLE_VIDEOS + "("
                + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT"+ ")";
        db.execSQL(CREATE_VIDEOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIDEOS);

        // Create tables again
        onCreate(db);
    }


    public void addVideo(Dbpojo dbpojo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, dbpojo.getVideoid());
        values.put(KEY_NAME, dbpojo.getTitile());

        // Inserting Row
        db.insert(TABLE_VIDEOS, null, values);
        db.close(); // Closing database connection
    }


    public List<Dbpojo> getAllVideos() {
        List<Dbpojo> videolist = new ArrayList();
        String selectQuery = "SELECT  * FROM " + TABLE_VIDEOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Dbpojo i = new Dbpojo();
                i.setVideoid(cursor.getString(0));
                i.setTitile(cursor.getString(1));
                videolist.add(i);
            } while (cursor.moveToNext());
        }

        return videolist;
    }


}