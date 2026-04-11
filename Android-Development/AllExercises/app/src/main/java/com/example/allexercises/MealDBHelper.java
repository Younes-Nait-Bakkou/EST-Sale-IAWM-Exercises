package com.example.allexercises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class MealDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RestaurantDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_MEALS = "meals";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESC = "description";

    public MealDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_MEALS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);

        insertInitialMeal(db, "Tajine de Poulet", "Un délicieux tajine marocain avec des olives, du citron confit et des frites.");
        insertInitialMeal(db, "Couscous Royal", "Couscous traditionnel aux sept légumes avec viande de bœuf, poulet et merguez.");
        insertInitialMeal(db, "Pastilla aux Fruits de Mer", "Pâte feuilletée croustillante farcie de poissons, crevettes, calamars et vermicelles.");
        insertInitialMeal(db, "Salade Marocaine", "Tomates, concombres et oignons finement coupés avec une vinaigrette légère.");
        insertInitialMeal(db, "Thé à la Menthe", "Thé vert traditionnel infusé avec de la menthe fraîche et du sucre.");
    }

    private void insertInitialMeal(SQLiteDatabase db, String name, String desc) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_DESC, desc);
        db.insert(TABLE_MEALS, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEALS);
        onCreate(db);
    }

    public ArrayList<Meal> getAllMeals() {
        ArrayList<Meal> mealList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_MEALS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Meal meal = new Meal(
                        cursor.getInt(0),     // ID
                        cursor.getString(1),  // Name
                        cursor.getString(2)   // Description
                );
                mealList.add(meal);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mealList;
    }
}