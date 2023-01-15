package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TimerPage extends AppCompatActivity {
    //底部跳转按钮
    private Button mbtn_Home;
    private Button mbtn_Library;
    private Button mbtn_Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_page);

        //找到控件
        mbtn_Home = findViewById(R.id.btn_TimerPage_Home);
        mbtn_Library = findViewById(R.id.btn_TimerPage_Library);
        mbtn_Profile = findViewById(R.id.btn_TimerPage_profile);

//        //跳转到Home
//        mbtn_Home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TimerPage.this,HomePage.class);
//                startActivity(intent);
//
//            }
//        });
//        //跳转到Library
//        mbtn_Library.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TimerPage.this,LibraryPage.class);
//                startActivity(intent);
//            }
//        });
//        //跳转到Profile
//        mbtn_Profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TimerPage.this,ProfilePage.class);
//                startActivity(intent);
//            }
//        });
        setClickListener();

    }
    private void setClickListener(){
        onClick onClick = new onClick();
        mbtn_Library.setOnClickListener(onClick);
        mbtn_Home.setOnClickListener(onClick);
        mbtn_Profile.setOnClickListener(onClick);



    }
    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch(view.getId()){
                case R.id.btn_TimerPage_Library:
                    intent = new Intent(TimerPage.this, LibraryPage.class);
                    break;
                case R.id.btn_TimerPage_Home:
                    intent = new Intent(TimerPage.this, HomePage.class);
                    break;
                case R.id.btn_TimerPage_profile:
                    intent = new Intent(TimerPage.this, ProfilePage.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}