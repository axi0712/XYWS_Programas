package com.example.administrator.xyws_program.view.activity.persional;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/13 0013 8:09
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


public class Activity_persional_Setting_ZhangHu extends BaseActivity {
  //
    @BindView(R.id.activity_persional_setting_zhanghu_cancel)
    ImageView activityPersionalSettingZhanghuCancel;
    @BindView(R.id.activity_persional_info_sex)
    ImageView activityPersionalInfoSex;
    @BindView(R.id.activity_persional_setting_zhanghu_phone_text)
    TextView activityPersionalSettingZhanghuPhoneText;
    @BindView(R.id.activity_persional_setting_zhanghu_phone)
    RelativeLayout activityPersionalSettingZhanghuPhone;
    @BindView(R.id.activity_persional_setting_zhanghu_pwd)
    RelativeLayout activityPersionalSettingZhanghuPwd;
    @BindView(R.id.activity_persional_setting_zhanghu_btn)
    Button activityPersionalSettingZhanghuBtn;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    @Override
    protected int getLayout() {
        return R.layout.activity_persional_setting_zhanghu;
    }

    @Override
    protected void init() {
            mShared = getSharedPreferences("login",MODE_PRIVATE);
        mEditor = mShared.edit();
        activityPersionalSettingZhanghuPhoneText.setText(mShared.getString("phonenum",""));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }



    @OnClick({R.id.activity_persional_setting_zhanghu_cancel, R.id.activity_persional_setting_zhanghu_phone, R.id.activity_persional_setting_zhanghu_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_setting_zhanghu_cancel:
                finish();
                break;
            case R.id.activity_persional_setting_zhanghu_phone:
                Intent in = new Intent(Activity_persional_Setting_ZhangHu.this,Activity_Persional_Setting_Zhanghu_Phone.class);
                startActivity(in);
                break;
            case R.id.activity_persional_setting_zhanghu_pwd:
                Intent in1 = new Intent(Activity_persional_Setting_ZhangHu.this,Activity_Persional_Setting_Zhnaghu_Pwd.class);
                startActivity(in1);
                break;
        }
    }

    @OnClick(R.id.activity_persional_setting_zhanghu_btn)
    public void onViewClicked() {
        Dialog dia = new AlertDialog.Builder(Activity_persional_Setting_ZhangHu.this).setTitle("退出登录").setMessage("退出不会删除任何数据，下次登录可使用本账号")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setPositiveButton("确定",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mEditor.remove("userid");
                        mEditor.commit();
                        Toast.makeText(Activity_persional_Setting_ZhangHu.this, "注销成功", Toast.LENGTH_SHORT).show();
                    }
                }).create();
        dia.show();

    }
}
