package com.example.administrator.xyws_program.view.activity.persional;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Setting_ZhangHu_Phone_YanZheng_QueDing_Inter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/13 0013 14:19
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


public class Activity_Persional_Setting_ZhangHu_Phone_YanZheng_QueDing extends BaseActivity implements Activity_Persional_Setting_ZhangHu_Phone_YanZheng_QueDing_Inter {
    @BindView(R.id.activity_persional_setting_zhanghu_phone_yanzheng_queding_cancel)
    ImageView activityPersionalSettingZhanghuPhoneYanzhengQuedingCancel;
    @BindView(R.id.activity_persional_setting_zhanghu_yanzheng_queding_edit)
    EditText activityPersionalSettingZhanghuYanzhengQuedingEdit;
    @BindView(R.id.activity_persional_setting_zhanghu_phone_yanzheng_queding_btn)
    Button activityPersionalSettingZhanghuPhoneYanzhengQuedingBtn;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_setting_zhanghu_phone_yanzheng_queding;
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
    public String getEdit() {
        return activityPersionalSettingZhanghuYanzhengQuedingEdit.getText().toString().trim();
    }



    @OnClick({R.id.activity_persional_setting_zhanghu_phone_yanzheng_queding_cancel, R.id.activity_persional_setting_zhanghu_phone_yanzheng_queding_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_setting_zhanghu_phone_yanzheng_queding_cancel:
                finish();
                break;
            case R.id.activity_persional_setting_zhanghu_phone_yanzheng_queding_btn:
                break;
        }
    }
}
