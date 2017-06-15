package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.presenter.Blood.Blood_datarecord_imple;
import com.example.administrator.xyws_program.util.DateTimeUils;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.util.hgetuid;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_View_Login;
import com.example.administrator.xyws_program.view.fragment.blood.adpter.AlarmclickAdapter;
import com.example.administrator.xyws_program.view.fragment.blood.service.MyService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AlarmclickActivity extends BaseActivity  {


    private ImageView back;
    private ImageView addalarmclick;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private AlarmclickAdapter adapter1;
    private List<alarmclickitem> list;
    private MyService myService;

    @Override
    protected int getLayout() {
        return R.layout.activity_alarmclick;
    }

    @Override
    protected void init() {
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) findViewById(R.id.clickrecyclerview);
        back = (ImageView) findViewById(R.id.alarmclock_toolbar_backimg);
        addalarmclick = (ImageView) findViewById(R.id.alarmclock_toolbar_add);

    }

    @Override
    protected void initListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        addalarmclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent=new Intent(AlarmclickActivity.this,AlarmcliickItemActivity.class);
                    startActivity(intent);

            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!hgetuid.getid().isEmpty()){
            list = hgetdb.gettwolist(this);

            //删除数据库的数据
     /*   for(alarmclickitem s:list){
            hgetdb.gettwodao(this).delete(s);
        }*/
         if(!list.isEmpty()){
             adapter1= new AlarmclickAdapter(this, list);
             pullToRefreshRecyclerView.setAdapter(adapter1);
             adapter1.notifyDataSetChanged();

             LinearLayoutManager manager = new LinearLayoutManager(this);
             manager.setOrientation(LinearLayoutManager.VERTICAL);
             pullToRefreshRecyclerView.setLayoutManager(manager);
             pullToRefreshRecyclerView.setPullRefreshEnabled(false);
             //设置下拉刷新下拉加载
             pullToRefreshRecyclerView.setLoadingMoreEnabled(false);
             pullToRefreshRecyclerView.setPullRefreshEnabled(false);
             pullToRefreshRecyclerView.displayLastRefreshTime(false);

         }
        }else {
            Toast.makeText(AlarmclickActivity.this,"请先登录！",Toast.LENGTH_SHORT).show();
        }
    }


    private  String getDate(long time, String geshi) {
        SimpleDateFormat sdf = new SimpleDateFormat(geshi);
        Date date = new Date(time);
        return sdf.format(date);
    }

}
