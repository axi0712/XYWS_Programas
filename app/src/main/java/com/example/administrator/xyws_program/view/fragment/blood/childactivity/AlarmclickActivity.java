package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

public class AlarmclickActivity extends BaseActivity {


    private ImageView back;

    @Override
    protected int getLayout() {
        return R.layout.activity_alarmclick;
    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.alarmclock_toolbar_backimg);
    }

    @Override
    protected void initListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
