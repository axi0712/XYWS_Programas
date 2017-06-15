package com.example.administrator.xyws_program.view.activity.doctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.doctor.adapter.Details_pageAdapter;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.Details_Fragment_Huifu;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.Details_Fragment_Jingyan;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.Details_Fragment_ZuoZhenTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Doctor_DetailsActivity extends BaseActivity {


    @BindView(R.id.Details_back)
    ImageView DetailsBack;
    @BindView(R.id.details_linlayout)
    LinearLayout detailsLinlayout;
    @BindView(R.id.details_img)
    ImageView detailsImg;
    @BindView(R.id.details_tv_name)
    TextView detailsTvName;
    @BindView(R.id.details_hostial)
    TextView detailsHostial;
    @BindView(R.id.details_yisheng)
    TextView detailsYisheng;
    @BindView(R.id.details_yike)
    TextView detailsYike;
    @BindView(R.id.details_xueli)
    TextView detailsXueli;
    @BindView(R.id.details_content)
    TextView detailsContent;
    @BindView(R.id.details_huifu)
    RadioButton detailsHuifu;
    @BindView(R.id.details_time)
    RadioButton detailsTime;
    @BindView(R.id.details_jingyan)
    RadioButton detailsJingyan;
    @BindView(R.id.details_group)
    RadioGroup detailsGroup;
    @BindView(R.id.details_viewpager)
    ViewPager detailsViewpager;
    private String app_image;
    private String name;
    private Intent intent;
    private String title;
    private String teach;
    private String hospital;
    private String depart;
    private String goodat;
    //viewpager适配器
    private Details_pageAdapter details_pageAdapter;
    private List<Fragment> mflist = new ArrayList<>();
    private Details_Fragment_Huifu details_fragment_huifu;
    private Details_Fragment_ZuoZhenTime details_fragment_zuoZhenTime;
    private Details_Fragment_Jingyan details_fragment_jingyan;

    private SharedPreferences sharedPreferences;
    private String menzhen;

    @Override
    protected int getLayout() {
        return R.layout.activity_doctor__details;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        app_image = intent.getStringExtra("app_image");
        name = intent.getStringExtra("name");
        title = intent.getStringExtra("title");
        teach = intent.getStringExtra("teach");
        hospital = intent.getStringExtra("hospital");
        depart = intent.getStringExtra("depart");
        goodat = intent.getStringExtra("goodat");

        menzhen = intent.getStringExtra("menzhen");


        details_fragment_huifu = new Details_Fragment_Huifu();
        details_fragment_zuoZhenTime = new Details_Fragment_ZuoZhenTime();

        details_fragment_jingyan = new Details_Fragment_Jingyan();
        mflist.add(details_fragment_huifu);
        mflist.add(details_fragment_zuoZhenTime);
        mflist.add(details_fragment_jingyan);

        details_pageAdapter = new Details_pageAdapter(getSupportFragmentManager(), mflist);
        detailsViewpager.setAdapter(details_pageAdapter);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        //头像
        Glide.with(this).load(app_image).into(detailsImg);
        //名字
        detailsTvName.setText(name);
        //医院
        detailsHostial.setText(hospital);
        //医生
        detailsYisheng.setText(title);
        //医科
        detailsYike.setText(depart);
        //学历
        detailsXueli.setText(teach);
        //内容
        detailsContent.setText(goodat);

    }


    @OnClick({R.id.Details_back, R.id.details_huifu, R.id.details_time, R.id.details_jingyan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Details_back:
                finish();
                break;
            case R.id.details_huifu:
                detailsViewpager.setCurrentItem(0);

                break;
            case R.id.details_time:
                detailsViewpager.setCurrentItem(1);

                break;
            case R.id.details_jingyan:
                detailsViewpager.setCurrentItem(2);

                break;
        }
    }
}
