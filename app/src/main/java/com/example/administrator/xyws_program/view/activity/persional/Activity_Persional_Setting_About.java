package com.example.administrator.xyws_program.view.activity.persional;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/13 0013 20:21
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


public class Activity_Persional_Setting_About extends BaseActivity {
    @BindView(R.id.activity_persional_setting_about_cancel)
    ImageView activityPersionalSettingAboutCancel;
    @BindView(R.id.activity_persional_setting_about_pinfen)
    RelativeLayout activityPersionalSettingAboutPinfen;
    @BindView(R.id.activity_persional_setting_about_fankui)
    RelativeLayout activityPersionalSettingAboutFankui;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_setting_about;
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


    @OnClick({R.id.activity_persional_setting_about_cancel, R.id.activity_persional_setting_about_pinfen, R.id.activity_persional_setting_about_fankui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_setting_about_cancel:
                finish();
                break;
            case R.id.activity_persional_setting_about_pinfen:
                Uri uri = Uri.parse("market://details?id="+getPackageName());
                Intent intentpf = new Intent(Intent.ACTION_VIEW,uri);
                intentpf.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentpf);
                break;
            case R.id.activity_persional_setting_about_fankui:
                Intent in = new Intent(Activity_Persional_Setting_About.this, Activity_Persional_Setting_About_FanKui.class);
                startActivity(in);
                break;
        }
    }

}
