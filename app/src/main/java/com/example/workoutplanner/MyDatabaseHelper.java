package com.example.workoutplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    // 建表语句
    public static final String CREATE_Workout = "create table Workout ("
                            + "id integer primary key autoincrement,"
                            + "name text,"
                            + "number text)";

    private Context mcontext;
    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Workout);
        Toast.makeText(mcontext,"Database created",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
