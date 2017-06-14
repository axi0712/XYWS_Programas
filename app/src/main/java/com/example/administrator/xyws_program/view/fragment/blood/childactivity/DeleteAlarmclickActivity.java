package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.util.hgetdb;

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

    @Override
    protected int getLayout() {
        return R.layout.activity_delete_alarmclick;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {

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
        finish();
        Toast.makeText(DeleteAlarmclickActivity.this,"删除用药提醒！",Toast.LENGTH_SHORT).show();
    }
}
