package com.example.administrator.xyws_program.view.activity.persional;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Setting_ZhangHu_Pwd_Inter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/13 0013 21:43
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


public class Activity_Persional_Setting_Zhnaghu_Pwd extends BaseActivity implements Activity_Persional_Setting_ZhangHu_Pwd_Inter{
    @BindView(R.id.modify_back)
    ImageView modifyBack;
    @BindView(R.id.modify_title)
    RelativeLayout modifyTitle;
    @BindView(R.id.modify_pwd)
    EditText modifyPwd;
    @BindView(R.id.modify_pwdOne)
    EditText modifyPwdOne;
    @BindView(R.id.xiugai)
    Button xiugai;

    @Override
    protected int getLayout() {
        return R.layout.activity_modifypwd;
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



    @OnClick({R.id.modify_back, R.id.modify_title, R.id.xiugai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_back:
                finish();
                break;
            case R.id.modify_title:
                break;
            case R.id.xiugai:
                break;
        }
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public String getPwdTwo() {
        return null;
    }
}
