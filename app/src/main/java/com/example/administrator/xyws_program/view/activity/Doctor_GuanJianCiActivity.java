package com.example.administrator.xyws_program.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Doctor_GuanJianCiActivity extends BaseActivity {


    @BindView(R.id.Details_back)
    ImageView DetailsBack;
    @BindView(R.id.gjc_linlayout)
    LinearLayout gjcLinlayout;
    @BindView(R.id.gjc_btn)
    Button gjcBtn;
    @BindView(R.id.gjc_edit)
    EditText gjcEdit;
    @BindView(R.id.gjc_listview)
    ListView gjcListview;

    @Override
    protected int getLayout() {
        return R.layout.activity_doctor__guan_jian_ci;
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

    @OnClick({R.id.Details_back, R.id.gjc_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Details_back:
                finish();
                break;
            case R.id.gjc_btn:
                String trim = gjcEdit.getText().toString().trim();
                if (trim != "") {
                    Intent intent = getIntent();
                    intent.putExtra("gjc", trim);
                    setResult(400,intent);

                } else {
                    Toast.makeText(this, "关键词不能为空", Toast.LENGTH_SHORT).show();
                }
                onBackPressed();
                break;
        }
    }
}
