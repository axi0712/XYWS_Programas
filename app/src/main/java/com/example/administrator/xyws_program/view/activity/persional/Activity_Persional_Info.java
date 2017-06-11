package com.example.administrator.xyws_program.view.activity.persional;

import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.MainActivity;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Info_Inter;
import com.example.administrator.xyws_program.view.zidingyiview.WheelView;

import java.util.Arrays;

import butterknife.BindView;
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

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_info;
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


    @OnClick({R.id.activity_persional_name, R.id.activity_persional_sex, R.id.activity_persional_height, R.id.activity_persional_weight, R.id.activity_persional_birthday})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_name:
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
                    }
                });

                // 展示弹出框
                new AlertDialog.Builder(Activity_Persional_Info.this)
                        .setTitle("设置性别").setView(outerView)
                        .setPositiveButton("OK", null).show();


                break;
            case R.id.activity_persional_height:
                break;
            case R.id.activity_persional_weight:
                break;
            case R.id.activity_persional_birthday:
                break;
        }
    }

    @Override
    public void getRela() {

    }
}
