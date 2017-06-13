package com.example.administrator.xyws_program.view.activity.persional;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/13 0013 8:19
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


public class Activity_Persional_Setting_Zhanghu_Phone extends BaseActivity {
    @BindView(R.id.activity_persional_setting_zhanghu_phone_cancel)
    ImageView activityPersionalSettingZhanghuPhoneCancel;
    @BindView(R.id.activity_persional_setting_zhanghu_phone_text_phone)
    TextView activityPersionalSettingZhanghuPhoneTextPhone;
    @BindView(R.id.activity_persional_setting_zhanghu_phone_btn)
    Button activityPersionalSettingZhanghuPhoneBtn;
    private SharedPreferences mShared ;
    @Override
    protected int getLayout() {
        return R.layout.activity_persional_setting_zhanghu_phone;
    }

    @Override
    protected void init() {
        mShared = getSharedPreferences("login",MODE_PRIVATE);
        activityPersionalSettingZhanghuPhoneTextPhone.setText(mShared.getString("phonenum",""));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.activity_persional_setting_zhanghu_phone_cancel, R.id.activity_persional_setting_zhanghu_phone_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_setting_zhanghu_phone_cancel:
                finish();
                break;
            case R.id.activity_persional_setting_zhanghu_phone_btn:
                Intent in = new Intent(Activity_Persional_Setting_Zhanghu_Phone.this,Activity_Persional_Setting_ZhangHu_Phone_Yanheng.class);
                startActivity(in);
                break;
        }
    }
}
