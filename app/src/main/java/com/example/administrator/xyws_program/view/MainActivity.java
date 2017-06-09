package com.example.administrator.xyws_program.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:  主页面s
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 8:14
 * 修改人:x
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

public class MainActivity extends BaseActivity implements BaseActivity_Zhu {


    @BindView(R.id.main_tou_text)
    TextView mainTouText;
    @BindView(R.id.main_tou_linea)
    LinearLayout mainTouLinea;
    @BindView(R.id.main_zhu_frame)
    FrameLayout mainZhuFrame;
    @BindView(R.id.main_zhu_radio_btn_doctor)
    RadioButton mainZhuRadioBtnDoctor;
    @BindView(R.id.main_zhu_radio_btn_blood)
    RadioButton mainZhuRadioBtnBlood;
    @BindView(R.id.main_zhu_radio_btn_persional)
    RadioButton mainZhuRadioBtnPersional;
    @BindView(R.id.main_zhu_radio_group)
    RadioGroup mainZhuRadioGroup;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
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
    public void mFrame() {

    }

    @Override
    public void getText(String str) {

    }

    @Override
    public void getRadio(View.OnClickListener onClick) {

    }


    @OnClick({R.id.main_zhu_radio_btn_doctor, R.id.main_zhu_radio_btn_blood, R.id.main_zhu_radio_btn_persional})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_zhu_radio_btn_doctor:
                mainTouText.setText("医生在线");

                break;
            case R.id.main_zhu_radio_btn_blood:
                mainTouText.setText("血压管理");
                break;
            case R.id.main_zhu_radio_btn_persional:
                mainTouLinea.setVisibility(View.GONE);
                break;
        }
    }
}
