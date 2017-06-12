package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class RequstdoctorActivity extends BaseActivity {

    @BindView(R.id.requstdoctor_toolbar)
    Toolbar requstdoctorToolbar;
    @BindView(R.id.requstdoctor)
    RelativeLayout requstdoctor;
    @BindView(R.id.requst)
    PullToRefreshRecyclerView requst;
    @BindView(R.id.activity_requstdoctor)
    RelativeLayout activityRequstdoctor;
    private ImageView requstdoctorToolbarBackimg1;

    @Override
    protected int getLayout() {
        return R.layout.activity_requstdoctor;
    }

    @Override
    protected void init() {
        requstdoctorToolbarBackimg1 = (ImageView) findViewById(R.id.requstdoctor_toolbar_backimg);
    }

    @Override
    protected void initListener() {
        requstdoctorToolbarBackimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.requstdoctor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.requstdoctor:
                //跳转到免费提问

                break;
        }
    }
}
