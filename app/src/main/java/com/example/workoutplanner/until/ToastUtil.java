package com.example.workoutplanner.until;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {
    private static Toast mToast_bot;
    private static Toast mToast_center;


    //打印Toast在底部的方法
    public static void showMsgBot(Context context,String msg){
        if(mToast_bot == null){
            mToast_bot = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else{
            mToast_bot.setText(msg);
        }
        mToast_bot.show();
    }

    //打印Toast在中间的方法
    public static void showMsgCenter(Context context, String msg){
        if(mToast_center == null){
            mToast_center = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else{
            mToast_center.setText(msg);
            mToast_center.setGravity(Gravity.CENTER,0,0);
        }
        mToast_center.show();

    }

}
