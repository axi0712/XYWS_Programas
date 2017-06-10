package com.example.administrator.xyws_program.view.fragment.persional;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_Info_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_persional_Info_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.MainActivity;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_View_Login;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 16:06
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


public class Fragment_Persional extends BaseFragment implements View.OnClickListener,Fragment_Persional_Inter{

    @BindView(R.id.fragment_persional_text)
    TextView fragmentPersionalText;
    @BindView(R.id.fragment_persional_btn_login)
    Button fragmentPersionalBtnLogin;
    @BindView(R.id.persional_btn_jiahao)
    Button persionalBtnJiahao;
    @BindView(R.id.persional_btn_collect)
    Button persionalBtnCollect;
    @BindView(R.id.persional_btn_info)
    Button persionalBtnInfo;
    @BindView(R.id.persional_btn_message)
    Button persionalBtnMessage;
    @BindView(R.id.persional_btn_Setting)
    Button persionalBtnSetting;
    Unbinder unbinder;
    private Activity_persional_Info_Presenter_Inter inter;
    private SharedPreferences mShared;
    @Override
    protected int layoutId() {
        return R.layout.fragment_persional;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        inter = new Activity_Persional_Info_Presenter_Imple(this);
        mShared = MyApp.activity.getSharedPreferences("login", Context.MODE_PRIVATE);
        getBtn();
    }

    @Override
    public void onResume() {
        super.onResume();
        getBtn();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void updateTitleBar() {

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.GONE);

            ((MainActivity) MyApp.activity).getPersionalBtn().setChecked(true);


        } else {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.VISIBLE);
            ((MainActivity) MyApp.activity).getPersionalBtn().setChecked(false);


        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_persional_btn_login:
                Log.d("Fragment_Persional", mShared.getString("userid", ""));
                if(mShared.getString("userid","").isEmpty()) {
                    Intent in = new Intent(MyApp.activity, Activity_Persional_View_Login.class);
                    startActivity(in);
                }else {

                }
                break;
            case R.id.persional_btn_jiahao:
                break;
            case R.id.persional_btn_collect:
                break;
            case R.id.persional_btn_info:
                break;
            case R.id.persional_btn_message:
                break;
            case R.id.persional_btn_Setting:
                break;
        }
    }

    @Override
    public void getBtn() {
        if(mShared.getString("userid","").isEmpty()){
            fragmentPersionalBtnLogin.setOnClickListener(this);
        }else {
            fragmentPersionalText.setVisibility(View.GONE);
            fragmentPersionalBtnLogin.setVisibility(View.GONE);
            inter.info(userId());
//            ImageView im = new ImageView(MyApp.activity);
//            Glide.with(MyApp.activity).load().
        }
    }

    @Override
    public String userId() {
        return mShared.getString("userid","");
    }
}
