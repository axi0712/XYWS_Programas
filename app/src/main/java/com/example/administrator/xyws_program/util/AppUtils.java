package com.example.administrator.xyws_program.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.example.administrator.xyws_program.MyApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2017/6/9.
 */

public class AppUtils {
    public static String COOKIE="cookie";
    private static ProgressDialog dialog;
    private static SharedPreferences preferences= MyApp.activity.getSharedPreferences("data", Context.MODE_PRIVATE);
    private static SharedPreferences.Editor editor=preferences.edit();

    public static void dialog(){
        dialog=new ProgressDialog(MyApp.activity);
        dialog.setMax(100);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求数据");
        dialog.show();
    }
    public static void dismiss(){
        dialog.dismiss();
    }

    public static void toast(String str){
        Toast.makeText(MyApp.activity,str,Toast.LENGTH_SHORT).show();
    }

    public static SharedPreferences get(){
        return preferences;
    }

    public static SharedPreferences.Editor put(){
        return editor;
    }

    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    public static String longToString(long dateTime,String formatType){
        SimpleDateFormat format=new SimpleDateFormat(formatType);
        Date date=new Date(dateTime);
        String format1 = format.format(date);
        return format1;
    }

    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static void isPression(String permission, final String[] permissions){
        if (ContextCompat.checkSelfPermission(MyApp.activity,
                permission)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MyApp.activity,
                    permission)) {
                toast("程序应用需要此权限,请给予授权");
            } else {
                new AlertDialog.Builder(MyApp.activity)
                        .setTitle("权限申请")
                        .setMessage("你当前需要一个权限，是否给予授权")
                        .setNeutralButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(MyApp.activity,
                                        permissions,
                                        1);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toast("您当前没有这个权限，可能会导致某些问题");
                    }
                }).show();
            }
        }else{

        }
    }
}
