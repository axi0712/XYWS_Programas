package com.example.administrator.xyws_program.view.activity.persional;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_Info_ZiLiao_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Info_ZiLiao_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.MainActivity;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Info_Inter;
import com.example.administrator.xyws_program.view.zidingyiview.WheelView;

import java.util.Arrays;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/11 0011 19:58
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


public class Activity_Persional_Info extends BaseActivity implements Activity_Persional_Info_Inter {
    @BindView(R.id.activity_persional_info_cancel)
    ImageView activityPersionalInfoCancel;
    @BindView(R.id.activity_persional_name)
    RelativeLayout activityPersionalName;
    @BindView(R.id.activity_persional_info_sex)
    ImageView activityPersionalInfoSex;
    @BindView(R.id.activity_persional_info_sex_text)
    TextView activityPersionalInfoSexText;
    @BindView(R.id.activity_persional_sex)
    RelativeLayout activityPersionalSex;
    @BindView(R.id.activity_persional_info_height)
    ImageView activityPersionalInfoHeight;
    @BindView(R.id.activity_persional_info_height_text)
    TextView activityPersionalInfoHeightText;
    @BindView(R.id.activity_persional_height)
    RelativeLayout activityPersionalHeight;
    @BindView(R.id.activity_persional_info_weight)
    ImageView activityPersionalInfoWeight;
    @BindView(R.id.activity_persional_info_weight_text)
    TextView activityPersionalInfoWeightText;
    @BindView(R.id.activity_persional_weight)
    RelativeLayout activityPersionalWeight;
    @BindView(R.id.activity_persional_info_birthday)
    ImageView activityPersionalInfoBirthday;
    @BindView(R.id.activity_persional_info_birthday_text)
    TextView activityPersionalInfoBirthdayText;
    @BindView(R.id.activity_persional_birthday)
    RelativeLayout activityPersionalBirthday;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String[] PLANETS = new String[]{"男", "女"};
    @BindView(R.id.activity_persional_info_name_text)
    TextView activityPersionalInfoNameText;
    @BindView(R.id.activity_persional_info_name_image)
    ImageView activityPersionalInfoNameImage;
    private SharedPreferences mShared;
    private Activity_Persional_Info_ZiLiao_Presenter_Inter inter;
    int mYear, mMonth, mDay;
    final int DATE_DIALOG = 1;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_info;
    }

    @Override
    protected void init() {
        inter = new Activity_Persional_Info_ZiLiao_Presenter_Imple(this);
        mShared = getSharedPreferences("login", MODE_PRIVATE);
        activityPersionalInfoSexText.setText(mShared.getString("sex", ""));
        activityPersionalInfoHeightText.setText(mShared.getString("height", ""));
        activityPersionalInfoWeightText.setText("62");
        activityPersionalInfoBirthdayText.setText(mShared.getString("birthday", ""));
        activityPersionalInfoNameText.setText(mShared.getString("name", ""));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        inter.ziLiao(mShared.getString("userid", ""), mShared.getString("height", ""),
                "2", mShared.getString("sex", ""), mShared.getString("birthday", ""), "edit", mShared.getString("name", "")
        );
    }


    @OnClick({R.id.activity_persional_name, R.id.activity_persional_sex, R.id.activity_persional_height, R.id.activity_persional_weight, R.id.activity_persional_birthday})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_name:

                Intent in = new Intent(MyApp.activity, Activity_Persional_Info_Name.class);
                startActivity(in);
                String userName = mShared.getString("userName", "");
                activityPersionalInfoNameText.setText(userName);
                break;
            case R.id.activity_persional_sex:
                // 构建弹出框View
                View outerView = LayoutInflater.from(Activity_Persional_Info.this)
                        .inflate(R.layout.wheel_view, null);

                WheelView wv = (WheelView) outerView
                        .findViewById(R.id.wheel_view_wv);
                // wv.setOffset(0);// 偏移量
                wv.setOffset(2);

                wv.setItems(Arrays.asList(PLANETS));// 实际内容
                wv.setSeletion(0);// 设置默认被选中的项目
                // wv.setSeletion(3);
                wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                    @Override
                    public void onSelected(int selectedIndex, String item) {
                        // 选中后的处理事件
                        Log.d(TAG, "[Dialog]selectedIndex: " + selectedIndex
                                + ", item: " + item);
                        inter.ziLiao(mShared.getString("userid", ""), mShared.getString("height", ""),
                                "2", item, mShared.getString("birthday", ""), "edit", mShared.getString("name", "")
                        );
                        activityPersionalInfoSexText.setText(item);
                        Toast.makeText(Activity_Persional_Info.this, selectedIndex + ", item: " + item, Toast.LENGTH_SHORT).show();
                    }
                });

                // 展示弹出框
                new AlertDialog.Builder(Activity_Persional_Info.this)
                        .setTitle("设置性别").setView(outerView)
                        .setPositiveButton("OK", null)
                        .show();


                break;
            case R.id.activity_persional_height:

                // 构建弹出框View
                View va = LayoutInflater.from(Activity_Persional_Info.this)
                        .inflate(R.layout.activity_persional_info_num, null);
                NumberPicker num = (NumberPicker) va.findViewById(R.id.activity_persional_info_num_picker);
                final int[] minPrice = {0};
                num.setMinValue(0);
                num.setMaxValue(250);
                //设置np1的当前值
                num.setValue(minPrice[0]);
                num.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        // TODO Auto-generated method stub
                        minPrice[0] = newVal;
                        inter.ziLiao(mShared.getString("userid", ""), newVal + "",
                                "2", mShared.getString("sex", ""), mShared.getString("birthday", ""), "edit", mShared.getString("name", "")
                        );
                        activityPersionalInfoHeightText.setText(newVal + "");
                    }

                });
//                WheelView wa = (WheelView) va
//                        .findViewById(R.id.wheel_view_wv);
//                // wv.setOffset(0);// 偏移量
//                wa.setOffset(2);
//                for(int i = 0;i<200;i++) {
//                   // 实际内容
//                }
//                wa.setSeletion(0);// 设置默认被选中的项目
//                // wv.setSeletion(3);
//                wa.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//                    @Override
//                    public void onSelected(int selectedIndex, String item) {
//                        // 选中后的处理事件
//                        Log.d(TAG, "[Dialog]selectedIndex: " + selectedIndex
//                                + ", item: " + item);
//
//                        activityPersionalInfoHeightText.setText(item);
//                        Toast.makeText(Activity_Persional_Info.this, selectedIndex + ", item: " + item, Toast.LENGTH_SHORT).show();
//                    }
//                });

                // 展示弹出框
                new AlertDialog.Builder(Activity_Persional_Info.this)
                        .setTitle("选择身高").setView(va)
                        .setPositiveButton("OK", null).show();

                break;
            case R.id.activity_persional_weight:
                // 构建弹出框View
                View vb = LayoutInflater.from(Activity_Persional_Info.this)
                        .inflate(R.layout.activity_persional_info_num, null);
                NumberPicker numb = (NumberPicker) vb.findViewById(R.id.activity_persional_info_num_picker);
                final int[] minPriceb = {0};
                numb.setMinValue(0);
                numb.setMaxValue(250);
                //设置np1的当前值
                numb.setValue(minPriceb[0]);
                numb.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        // TODO Auto-generated method stub
                        minPriceb[0] = newVal;
                        inter.ziLiao(mShared.getString("userid", ""), mShared.getString("height", ""),
                                "2", mShared.getString("sex", ""), mShared.getString("birthday", ""), "edit", mShared.getString("name", "")
                        );
                        activityPersionalInfoWeightText.setText(newVal + "");
                    }

                });
                new AlertDialog.Builder(Activity_Persional_Info.this)
                        .setTitle("选择体重").setView(vb)
                        .setPositiveButton("OK", null).show();


                break;
            case R.id.activity_persional_birthday:
                final Calendar ca = Calendar.getInstance();
                mYear = ca.get(Calendar.YEAR);
                mMonth = ca.get(Calendar.MONTH);
                mDay = ca.get(Calendar.DAY_OF_MONTH);
                showDialog(DATE_DIALOG);
                StringBuffer sb = new StringBuffer().append(mMonth + 1).append("-").append(mDay).append("-").append(mYear).append(" ");
                String str = sb.toString();
                activityPersionalInfoBirthdayText.setText(str);
                inter.ziLiao(mShared.getString("userid", ""), mShared.getString("height", ""),
                        "2", mShared.getString("sex", ""), str, "edit", mShared.getString("name", "")
                );
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        activityPersionalInfoBirthdayText.setText(new StringBuffer().append(mMonth + 1).append("-").append(mDay).append("-").append(mYear).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };

    @Override
    public void getRela() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_persional_info_cancel)
    public void onViewClicked() {
        finish();
    }
}
