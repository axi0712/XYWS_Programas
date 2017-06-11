package com.example.administrator.xyws_program.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.view.activity.MainActivity;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_ProvinceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 16:01
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


public class Fragment_Doctor extends BaseFragment {

    @BindView(R.id.doctor_title)
    TextView doctorTitle;
    @BindView(R.id.doctor_img)
    ImageView doctorImg;
    @BindView(R.id.doctor_province)
    TextView doctorProvince;
    @BindView(R.id.fengexian1)
    TextView fengexian1;
    @BindView(R.id.doctor_mydoctor)
    TextView doctorMydoctor;
    @BindView(R.id.fengexian2)
    TextView fengexian2;
    @BindView(R.id.doctor_grade)
    TextView doctorGrade;
    @BindView(R.id.fengexian3)
    TextView fengexian3;
    @BindView(R.id.doctor_guanjianci)
    TextView doctorGuanjianci;
    @BindView(R.id.fengexian4)
    TextView fengexian4;
    @BindView(R.id.doctor_checkbox)
    CheckBox doctorCheckbox;
    @BindView(R.id.doctor_select)
    Button doctorSelect;
    @BindView(R.id.fengexian5)
    TextView fengexian5;
    @BindView(R.id.doctor_question)
    Button doctorQuestion;
    @BindView(R.id.doctor_phone)
    Button doctorPhone;
    @BindView(R.id.doctor_linear)
    LinearLayout doctorLinear;
    @BindView(R.id.fengexian6)
    TextView fengexian6;
    @BindView(R.id.doctor_trade)
    TextView doctorTrade;
    @BindView(R.id.doctor_relative2)
    RelativeLayout doctorRelative2;
    @BindView(R.id.doctor_btn_doctor1)
    Button doctorBtnDoctor1;
    @BindView(R.id.doctor_btn_doctor2)
    Button doctorBtnDoctor2;
    @BindView(R.id.doctor_btn_doctor3)
    Button doctorBtnDoctor3;
    @BindView(R.id.doctor_btn_doctor4)
    Button doctorBtnDoctor4;
    Unbinder unbinder;

    //判断是否是第一次进入
    private Boolean isFirst = false;
    private SharedPreferences sharedPreferences;


    @Override
    protected int layoutId() {
        return R.layout.fragment_doctor;
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected void initData() {

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
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.VISIBLE);
            ((MainActivity) MyApp.activity).getMainTouText().setText("医生在线");
            ((MainActivity) MyApp.activity).getDoctorBtn().setChecked(true);


        } else {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.GONE);
            ((MainActivity) MyApp.activity).getDoctorBtn().setChecked(false);


        }
    }


    @OnClick({R.id.doctor_select, R.id.doctor_question, R.id.doctor_phone, R.id.doctor_btn_doctor1, R.id.doctor_btn_doctor2, R.id.doctor_btn_doctor3, R.id.doctor_btn_doctor4, R.id.doctor_province, R.id.doctor_mydoctor, R.id.doctor_grade, R.id.doctor_guanjianci, R.id.doctor_trade})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //查询专家
            case R.id.doctor_select:

                break;
            //免费问医生
            case R.id.doctor_question:
                break;

            //健康顾问
            case R.id.doctor_phone:
                break;
            //主页医生1
            case R.id.doctor_btn_doctor1:
                break;
            //主页医生2

            case R.id.doctor_btn_doctor2:
                break;
            //主页医生3

            case R.id.doctor_btn_doctor3:
                break;
            //主页医生4
            case R.id.doctor_btn_doctor4:
                break;

            //省份
            case R.id.doctor_province:
                Intent intent = new Intent(Fragment_Doctor.this.getContext(), Doctor_ProvinceActivity.class);
                startActivity(intent);

                break;
            //医生职称
            case R.id.doctor_mydoctor:
                break;
            //医院等级
            case R.id.doctor_grade:
                break;
            //关键词
            case R.id.doctor_guanjianci:
                break;
            //换一组
            case R.id.doctor_trade:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (isFirst) {
            sharedPreferences = getContext().getSharedPreferences("province", Context.MODE_PRIVATE);
            String province = sharedPreferences.getString("province", "");
            if (province == "") {
                doctorProvince.setText("省份");

            }
            doctorProvince.setText(province);
        } else {
            isFirst = !isFirst;

        }
    }
}
