package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.workoutplanner.until.ToastUtil;

import pl.com.salsoft.sqlitestudioremote.internal.SQLiteStudioDbService;


public class LoginPage extends AppCompatActivity {
    //声明控件
    private Button mbtnLogin;
    private EditText etUsername;
    private EditText etPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //找到控件
        mbtnLogin = findViewById(R.id.btn_login);
        etPassword = findViewById(R.id.et_2);


        //无脑login跳转
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginPage.this,HomePage.class);
                startActivity(intent);

            }
        });

//        //实现用户名和密码匹配跳转
//        mbtnLogin.setOnClickListener(new View.OnClickListener() {
//            private static final int REQUEST_LOCATION_PERMISSION = 1;
//            private static final String TAG = "LoginPage";
//
//            @Override
//            public void onClick(View view) {
//                String username = etUsername.getText().toString();
//                String password = etPassword.getText().toString();
//                //Toast 内容设置
//                String success = "Login successful";
//                String fail = "Login fail!";
//                Intent intent = null;
//
//                //当前测试username是 xzy， 密码为123456
//                if(username.equals("xzy") && password.equals("123456")){
//                    //Toast 提示
//                    ToastUtil.showMsgBot(LoginPage.this, success);
//                    //匹配的话进行跳转
//                    intent = new Intent(LoginPage.this,HomePage.class);
//                    startActivity(intent);
//                }else{
//                    //Toast提示
//                    ToastUtil.showMsgCenter(LoginPage.this,fail);
//                    //失败的话，弹出登录失败
//
//
//                }
//                dpHelper.getWritableDatabase();
//            }
//
//        });


    }
}