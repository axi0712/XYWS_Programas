package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DatarecordActivity extends BaseActivity {

    @BindView(R.id.datarecore_toolbar_backimg)
    ImageView datarecoreToolbarBackimg;
    @BindView(R.id.datarecore_toolbar)
    Toolbar datarecoreToolbar;
    @BindView(R.id.datarecore_rlin1)
    RelativeLayout datarecoreRlin1;
    @BindView(R.id.datarecore_rlin2)
    RelativeLayout datarecoreRlin2;
    @BindView(R.id.datarecore_tv)
    TextView datarecoreTv;
    @BindView(R.id.datarecore_equipment)
    EditText datarecoreEquipment;
    @BindView(R.id.datarecore_rlin3)
    RelativeLayout datarecoreRlin3;
    @BindView(R.id.datarecore_tv2)
    TextView datarecoreTv2;
    @BindView(R.id.datarecore_high)
    EditText datarecoreHigh;
    @BindView(R.id.datarecore_rlin4)
    RelativeLayout datarecoreRlin4;
    @BindView(R.id.datarecore_tv3)
    TextView datarecoreTv3;
    @BindView(R.id.datarecore_low)
    EditText datarecoreLow;
    @BindView(R.id.datarecore_rlin5)
    RelativeLayout datarecoreRlin5;
    @BindView(R.id.datarecore_bt)
    Button datarecoreBt;
    @BindView(R.id.datarecore_rlin6)
    RelativeLayout datarecoreRlin6;
    @BindView(R.id.activity_datarecord)
    ScrollView activityDatarecord;

    @Override
    protected int getLayout() {
        return R.layout.activity_datarecord;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {

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

    @OnClick({R.id.datarecore_toolbar_backimg, R.id.datarecore_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.datarecore_toolbar_backimg:
                finish();
                break;
            case R.id.datarecore_bt:
                //上传血压数据

                break;
        }
    }
}
