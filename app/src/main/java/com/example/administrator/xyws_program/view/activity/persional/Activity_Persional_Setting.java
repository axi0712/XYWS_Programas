package com.example.administrator.xyws_program.view.activity.persional;

import android.content.Intent;
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
 * 创建时间: 2017/6/13 0013 7:55
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


public class Activity_Persional_Setting extends BaseActivity {

    @BindView(R.id.activity_persional_setting_cancel)
    ImageView activityPersionalSettingCancel;
    @BindView(R.id.activity_persional_setting_zhanghu)
    RelativeLayout activityPersionalSettingZhanghu;
    @BindView(R.id.activity_persional_setting_clear)
    RelativeLayout activityPersionalSettingClear;
    @BindView(R.id.activity_persional_setting_about)
    RelativeLayout activityPersionalSettingAbout;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_setting;
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


    @OnClick({R.id.activity_persional_setting_cancel, R.id.activity_persional_setting_zhanghu, R.id.activity_persional_setting_clear, R.id.activity_persional_setting_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_setting_cancel:
                finish();
                break;
            case R.id.activity_persional_setting_zhanghu:
                Intent in = new Intent(Activity_Persional_Setting.this,Activity_persional_Setting_ZhangHu.class);
                startActivity(in);
                break;
            case R.id.activity_persional_setting_clear:
                Intent is = new Intent(Activity_Persional_Setting.this,Activity_Persional_Clear.class);
                startActivity(is);
                break;
            case R.id.activity_persional_setting_about:
                Intent ia = new Intent(Activity_Persional_Setting.this,Activity_Persional_Setting_About.class);
                startActivity(ia);
                break;
        }
    }
}
