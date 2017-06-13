package com.example.administrator.xyws_program.view.activity.persional;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_Setting_ZhangHu_Phone_YanZheng_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Setting_ZhangHu_Phone_YanZheng_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Setting_ZhangHu_Phone_YanZheng_Inter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/13 0013 9:40
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


public class Activity_Persional_Setting_ZhangHu_Phone_Yanheng extends BaseActivity implements Activity_Persional_Setting_ZhangHu_Phone_YanZheng_Inter {
    @BindView(R.id.activity_persional_setting_zhanghu_yanzheng_cancel)
    ImageView activityPersionalSettingZhanghuYanzhengCancel;
    @BindView(R.id.activity_persional_setting_zhanghu_yanzheng_yuan)
    TextView activityPersionalSettingZhanghuYanzhengYuan;
    @BindView(R.id.activity_persional_setting_zhanghu_yanzheng_hao)
    TextView activityPersionalSettingZhanghuYanzhengHao;
    @BindView(R.id.activity_persional_setting_zhanghu_yanzheng_edit)
    EditText activityPersionalSettingZhanghuYanzhengEdit;
    @BindView(R.id.activity_persional_setting_zhanghu_yanzheng_btn_yanzheng)
    Button activityPersionalSettingZhanghuYanzhengBtnYanzheng;
    private SharedPreferences share;
    private Activity_Persional_Setting_ZhangHu_Phone_YanZheng_Presenter_Inter inter;
    @Override
    protected int getLayout() {
        return R.layout.activity_persional_setting_zhanghu_yanzheng;
    }

    @Override
    protected void init() {
        share = getSharedPreferences("login",MODE_PRIVATE);
        activityPersionalSettingZhanghuYanzhengHao.setText(share.getString("phonenum",""));
        inter = new Activity_Persional_Setting_ZhangHu_Phone_YanZheng_Presenter_Imple(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {


    }



    @OnClick({R.id.activity_persional_setting_zhanghu_yanzheng_cancel, R.id.activity_persional_setting_zhanghu_yanzheng_btn_yanzheng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_setting_zhanghu_yanzheng_cancel:
                finish();
                break;
            case R.id.activity_persional_setting_zhanghu_yanzheng_btn_yanzheng:
                inter.yangzheng(getEdit());
                Intent in = new Intent(Activity_Persional_Setting_ZhangHu_Phone_Yanheng.this,Activity_Persional_Setting_ZhangHu_Phone_YanZheng_QueDing.class);
                startActivity(in);
                break;
        }
    }

    @Override
    public String getEdit() {
        return activityPersionalSettingZhanghuYanzhengEdit.getText().toString().trim();
    }
}
