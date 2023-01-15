package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LibraryPage extends AppCompatActivity {
    private Button mbtn_Home;
    private Button mbtn_Timer;
    private Button mbtn_Profile;

    //icon button
    private Button mbtn_pushUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_page);


        //找到 button 控件
        mbtn_Home = findViewById(R.id.btn_LibraryPage_Home);
        mbtn_Timer = findViewById(R.id.btn_LibraryPage_Timer);
        mbtn_Profile = findViewById(R.id.btn_LibraryPage_Profile);
        mbtn_pushUp = findViewById(R.id.btn_pushUp);



        setClickListener();

    }

    private void setClickListener(){
        onClick onClick = new onClick();
        mbtn_Home.setOnClickListener(onClick);
        mbtn_Timer.setOnClickListener(onClick);
        mbtn_Profile.setOnClickListener(onClick);
        mbtn_pushUp.setOnClickListener(onClick);




    }
    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch(view.getId()){
                case R.id.btn_LibraryPage_Home:
                    intent = new Intent(LibraryPage.this, HomePage.class);
                    break;
                case R.id.btn_LibraryPage_Timer:
                    intent = new Intent(LibraryPage.this, TimerPage.class);
                    break;
                case R.id.btn_LibraryPage_Profile:
                    intent = new Intent(LibraryPage.this, ProfilePage.class);
                    break;
                case R.id.btn_pushUp:
                    intent = new Intent(LibraryPage.this, PushUp.class);
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}