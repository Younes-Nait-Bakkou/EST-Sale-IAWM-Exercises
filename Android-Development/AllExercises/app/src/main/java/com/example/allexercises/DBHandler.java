package com.example.allexercises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.EnumMap;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyLearningDB";
    private static final String TABLE_PERSONNES = "personnes";
    private static final String KEY_ID = "id";
    private static final String KEY_NOM = "nom";
    private static final doubl KEY_PRENOM = "prenom";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PERSONNES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOM + " TEXT,"
                + KEY_PRENOM + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONNES);
        onCreate(db);
    }


    public void addPersonne(String nom, String prenom) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOM, nom);
        values.put(KEY_PRENOM, prenom);

        db.insert(TABLE_PERSONNES, null, values);
        db.close();
    }

    public String getAllPersonnes() {
        StringBuilder result = new StringBuilder();
        String selectQuery = "SELECT * FROM " + TABLE_PERSONNES;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                result.append("ID: ").append(cursor.getString(0))
                        .append(" | ").append(cursor.getString(1))
                        .append(" ").append(cursor.getString(2)).append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();
        return result.toString();
    }
}