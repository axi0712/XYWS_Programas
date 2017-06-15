package com.example.administrator.xyws_program.view.fragment.blood.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.AlarmclickActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.DeleteAlarmclickActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/14 16:23
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */


public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        List<alarmclickitem> list=hgetdb.gettwolist(this);
        for(alarmclickitem s:list){
            //当前的时间毫秒值
            long systemLong = new Date(System.currentTimeMillis()).getTime();
            String current = getDate(systemLong, "HH:mm");
            //判断是否到当前时间
            if(current.equals( s.getTime())){

               /* Intent intent1=new Intent(this, DeleteAlarmclickActivity.class);
                intent.putExtra("bean",s);
                startActivity(intent1);*/
                Toast.makeText(this,"启动Service！",Toast.LENGTH_SHORT).show();

            }
        }

        return flags;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private  String getDate(long time, String geshi) {
        SimpleDateFormat sdf = new SimpleDateFormat(geshi);
        Date date = new Date(time);
        return sdf.format(date);
    }
}
