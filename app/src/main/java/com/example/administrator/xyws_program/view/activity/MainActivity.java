package com.example.administrator.xyws_program.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.inter.BaseActivity_Zhu;
import com.example.administrator.xyws_program.view.fragment.Fragment_Blood;
import com.example.administrator.xyws_program.view.fragment.Fragment_Doctor;
import com.example.administrator.xyws_program.view.fragment.Fragment_Persional;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.main_view)
    ViewPager mainView;
    private FragmentManager man;
    private FragmentTransaction tra;
    private long mExitTime;
    private List<Fragment> mFraList = new ArrayList<>();

    public LinearLayout getMainTouLinea() {
        return mainTouLinea;
    }

    public void setMainTouLinea(LinearLayout mainTouLinea) {
        this.mainTouLinea = mainTouLinea;
    }

    public TextView getMainTouText() {
        return mainTouText;
    }

    public void setMainTouText(TextView mainTouText) {
        this.mainTouText = mainTouText;
    }

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
        mFraList.add(new Fragment_Doctor());
        mFraList.add(new Fragment_Blood());
        mFraList.add(new Fragment_Persional());
        mainView.setAdapter(new MainAdapter(getSupportFragmentManager(), mFraList));


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

                mainView.setCurrentItem(0);

                break;
            case R.id.main_zhu_radio_btn_blood:


                mainView.setCurrentItem(1);

                break;
            case R.id.main_zhu_radio_btn_persional:

                mainView.setCurrentItem(2);

                break;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();

            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}