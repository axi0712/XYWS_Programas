package com.example.administrator.xyws_program.view.activity.persional;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.presenter.Activity_Persional_Login_Presenter_Inter;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_login_Presenter_Imple;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Login_view_Inter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 20:30
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


public class Activity_Persional_View_Login extends BaseActivity implements Activity_Persional_Login_view_Inter {
    @BindView(R.id.persional_login_edit_name_phone)
    ImageView persionalLoginEditNamePhone;
    @BindView(R.id.persional_login_edit_name)
    EditText persionalLoginEditName;
    @BindView(R.id.persional_login_edit_pwd_lock)
    ImageView persionalLoginEditPwdLock;
    @BindView(R.id.persional_login_edit_pwd)
    EditText persionalLoginEditPwd;
    @BindView(R.id.persional_login_text_pwd)
    TextView persionalLoginTextPwd;
    @BindView(R.id.persional_login_btn_login)
    Button persionalLoginBtnLogin;
    private Activity_Persional_Login_Presenter_Inter inter ;
    @Override
    protected int getLayout() {
        return R.layout.activity_persional_login;
    }

    @Override
    protected void init() {
        inter = new Activity_Persional_login_Presenter_Imple(this);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public String getName() {
        return persionalLoginEditName.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return persionalLoginEditPwd.getText().toString().trim();
    }

    @Override
    public void login() {

    }

    @Override
    public void loginPwd() {

    }

    @Override
    public String doToast(String toast) {
        return null;
    }


    @OnClick({R.id.persional_login_text_pwd, R.id.persional_login_btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.persional_login_text_pwd:
                break;
            case R.id.persional_login_btn_login:
                inter.login(getName(),getPwd());
                finish();
                break;
        }
    }
}
