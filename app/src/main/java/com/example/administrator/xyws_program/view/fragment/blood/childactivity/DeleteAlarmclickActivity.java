package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.util.DateTimeUils;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.view.fragment.blood.service.MyService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeleteAlarmclickActivity extends BaseActivity {

    @BindView(R.id.deletealarmclock_toolbar_backimg)
    ImageView deletealarmclockToolbarBackimg;
    @BindView(R.id.deletealarmclock_toolbar)
    Toolbar deletealarmclockToolbar;
    @BindView(R.id.alarmclock_lin2)
    RelativeLayout alarmclockLin2;
    @BindView(R.id.deletealarmclock_time)
    Button deletealarmclockTime;
    @BindView(R.id.alarmclock_lin11)
    LinearLayout alarmclockLin11;
    @BindView(R.id.alarmclock_title)
    TextView alarmclockTitle;
    @BindView(R.id.alarmclock_tv)
    TextView alarmclockTv;
    @BindView(R.id.deletealarmclock_et1)
    EditText deletealarmclockEt1;
    @BindView(R.id.alarmclock_lin3)
    RelativeLayout alarmclockLin3;
    @BindView(R.id.alarmclock_tv2)
    TextView alarmclockTv2;
    @BindView(R.id.deletealarmclock_et2)
    EditText deletealarmclockEt2;
    @BindView(R.id.alarmclock_lin4)
    RelativeLayout alarmclockLin4;
    @BindView(R.id.alarmclock_delete)
    Button alarmclockDelete;
    @BindView(R.id.alarmclock_lin5)
    RelativeLayout alarmclockLin5;
    @BindView(R.id.activity_delete_alarmclick)
    ScrollView activityDeleteAlarmclick;
    private alarmclickitem bean;
    private RadioButton textView;
    private  boolean isfirst=true;
    @Override
    protected int getLayout() {
        return R.layout.activity_delete_alarmclick;
    }

    @Override
    protected void init() {
        textView = (RadioButton) findViewById(R.id.service);

    }

    @Override
    protected void initListener() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfirst){
                    textView.setText("关闭");
                    textView.setChecked(false);
                    isfirst=false;
                }else {
                    textView.setText("开启");
                    textView.setChecked(true);
                    isfirst=true;
                }
            }
        });

    }

    @Override
    protected void loadData() {

        Intent intent=getIntent();
        bean = (alarmclickitem) intent.getSerializableExtra("bean");
        deletealarmclockTime.setText(bean.getTime());
        deletealarmclockEt1.setText(bean.getName());
        deletealarmclockEt2.setText(bean.getNumber());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.alarmclock_delete)
    public void onViewClicked() {
        hgetdb.gettwodao(this).delete(bean);
        Intent intent4=new Intent(DeleteAlarmclickActivity.this,AlarmclickActivity.class);
        startActivity(intent4);
        Toast.makeText(DeleteAlarmclickActivity.this,"删除用药提醒！",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();


        if(textView.isChecked()){

            startRemind();

        }else {

            stopRemind();

        }
    }

    /**
     * 开启提醒
     */
    private void startRemind(){

        //得到日历实例，主要是为了下面的获取时间
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(System.currentTimeMillis());

        //获取当前毫秒值
        long systemTime = System.currentTimeMillis();

        //是设置日历的时间，主要是让日历的年月日和当前同步
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        // 这里时区需要设置一下，不然可能个别手机会有8个小时的时间差
        mCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //设置在几点提醒  设置的为13点
        mCalendar.set(Calendar.HOUR_OF_DAY, 8);
        //设置在几分提醒  设置的为25分
        mCalendar.set(Calendar.MINUTE, 38);
        //下面这两个看字面意思也知道
        mCalendar.set(Calendar.SECOND, 0);

        //上面设置的就是13点25分的时间点

        //获取上面设置的13点25分的毫秒值
        long selectTime = mCalendar.getTimeInMillis();

        // 如果当前时间大于设置的时间，那么就从第二天的设定时间开始
        if(systemTime > selectTime) {
            mCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        //AlarmReceiver.class为广播接受者
        Intent intent = new Intent(DeleteAlarmclickActivity.this,
                OneShotAlarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(DeleteAlarmclickActivity.this, 0, intent, 0);
        //得到AlarmManager实例
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);

        //**********注意！！下面的两个根据实际需求任选其一即可*********

        /**
         * 单次提醒
         * mCalendar.getTimeInMillis() 上面设置的13点25分的时间点毫秒值
         */
        am.set(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), pi);

    }


    /**
     * 关闭提醒
     */
    private void stopRemind(){

        Intent intent = new Intent(DeleteAlarmclickActivity.this,
                OneShotAlarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(DeleteAlarmclickActivity.this, 0,
                intent, 0);
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        //取消警报
        am.cancel(pi);
        Toast.makeText(this, "关闭了提醒", Toast.LENGTH_SHORT).show();

    }
}
