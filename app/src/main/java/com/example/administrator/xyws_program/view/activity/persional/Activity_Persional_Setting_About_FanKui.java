package com.example.administrator.xyws_program.view.activity.persional;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Setting_About_FanKui_Inter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/13 0013 20:14
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


public class Activity_Persional_Setting_About_FanKui extends BaseActivity implements Activity_Persional_Setting_About_FanKui_Inter {
    @BindView(R.id.feed_back)
    ImageView feedBack;

    @BindView(R.id.feed_fasong)
    TextView feedFasong;
    @BindView(R.id.feed_title)
    RelativeLayout feedTitle;
    @BindView(R.id.feed_back_edit)
    EditText feedBackEdit;

    @Override
    protected int getLayout() {
        return R.layout.activity_feedback;
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



    @OnClick({R.id.feed_back, R.id.feed_fasong, R.id.feed_back_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feed_back:
                finish();
                break;
            case R.id.feed_fasong:
                break;
            case R.id.feed_back_edit:
                break;
        }
    }

    @Override
    public String getEdit() {
        return feedBackEdit.getText().toString().trim();
    }
}
