package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

import pl.com.salsoft.sqlitestudioremote.internal.SQLiteStudioDbService;

public class HomePage extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private Button mbtn_Library;
    private Button mbtn_Timer;
    private Button mbtn_Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        dbHelper = new MyDatabaseHelper(this, "workoutLibrary.db", null, 1 );

        //找到 button 控件
        mbtn_Library = findViewById(R.id.btn_homePage_Library);
        mbtn_Timer = findViewById(R.id.btn_homePage_Timer);
        mbtn_Profile = findViewById(R.id.btn_homePage_profile);
        //database button
        Button createDatabase = findViewById(R.id.create_database);
        Button addData = findViewById(R.id.add_database);
        Button queryData = findViewById(R.id.query_data);
        Button updateData = findViewById(R.id.update_data);
        Button deleteData = findViewById(R.id.delete_data);


        //创建dataBase监听
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        //add data 监听器
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取database对象，getwriteabledatabase会返回一个对象
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //使用contentValues 对象对插入的数据进行组装
                ContentValues values = new ContentValues();
                values.put("name", "push up");
                values.put("number","12");
                db.insert("Workout",null,values);
                //插入第二条数据之前需要clear清楚数据
                values.clear();
                values.put("name", "dumbbell lift");
                values.put("number","12");
                db.insert("Workout",null,values);

            }
        });
        //query data 监听器
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Workout",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") String number = cursor.getString(cursor.getColumnIndex("number"));
                        Log.d("HomePage", "name: " + name);
                        Log.d("HomePage","number: " + number);
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });

        //updateData 监听器
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("name", "running");
                    values.put("number","100");
                    //将名字为push up 的行更新为 running 和 100
                    db.update("Workout", values, "name = ?", new String[]{"push up"});
            }
        });

        //delete Data 监听器
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Workout", "name = ?", new String[]{"push up"});
                db.delete("Workout", "name = ?", new String[]{"dumbbell lift"});

            }
        });

        setClickListener();


//
//        //跳转到library
//        mbtn_Library.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomePage.this,LibraryPage.class);
//                startActivity(intent);
//
//            }
//        });
//        //跳转到Timer
//        mbtn_Timer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomePage.this,TimerPage.class);
//                startActivity(intent);
//            }
//        });
//        //跳转到Profile
//        mbtn_Profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomePage.this,ProfilePage.class);
//                startActivity(intent);
//            }
//        });

    }
    private void setClickListener(){
        onClick onClick = new onClick();
        mbtn_Library.setOnClickListener(onClick);
        mbtn_Timer.setOnClickListener(onClick);
        mbtn_Profile.setOnClickListener(onClick);



    }
    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch(view.getId()){
                case R.id.btn_homePage_Library:
                    intent = new Intent(HomePage.this, LibraryPage.class);
                    break;
                case R.id.btn_homePage_Timer:
                    intent = new Intent(HomePage.this, TimerPage.class);
                    break;
                case R.id.btn_homePage_profile:
                    intent = new Intent(HomePage.this, ProfilePage.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}
