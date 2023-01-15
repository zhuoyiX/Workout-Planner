package com.example.workoutplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {
    private Button mbtn_Home;
    private Button mbtn_Library;
    private Button mbtn_Timer;
    private Button mbtn_GoogleMap;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        //找到 button 控件
        mbtn_Home = findViewById(R.id.btn_ProfilePage_Home);
        mbtn_Timer = findViewById(R.id.btn_ProfilePage_Timer);
        mbtn_Library = findViewById(R.id.btn_ProfilePageLibrary);
        mbtn_GoogleMap = findViewById(R.id.btn_ProfilePage_googleMap);

//        //设置监听器
//        //跳转到Home
//        mbtn_Home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProfilePage.this,HomePage.class);
//                startActivity(intent);
//
//            }
//        });
//        //跳转到Timer
//        mbtn_Timer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProfilePage.this,TimerPage.class);
//                startActivity(intent);
//            }
//        });
//        //跳转到Profile
//        mbtn_Library.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProfilePage.this,LibraryPage.class);
//                startActivity(intent);
//            }
//        });
        setClickListener();

        //获取地图监听跳转
        mbtn_GoogleMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this,GoogleMapPage.class);
                startActivity(intent);
            }
        });
    }
    private void setClickListener(){
        onClick onClick = new onClick();
        mbtn_Library.setOnClickListener(onClick);
        mbtn_Timer.setOnClickListener(onClick);
        mbtn_Home.setOnClickListener(onClick);



    }
    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch(view.getId()){
                case R.id.btn_ProfilePageLibrary:
                    intent = new Intent(ProfilePage.this, LibraryPage.class);
                    break;
                case R.id.btn_ProfilePage_Home:
                    intent = new Intent(ProfilePage.this, HomePage.class);
                    break;
                case R.id.btn_ProfilePage_Timer:
                    intent = new Intent(ProfilePage.this, TimerPage.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }



}