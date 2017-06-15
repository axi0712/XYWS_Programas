package com.example.administrator.xyws_program.view.activity.persional;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.Persional_JiaHao_Bean;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/15 0015 12:29
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


public class Activity_Persional_JiaHao_Detail extends BaseActivity {
    @BindView(R.id.activity_persional_jiahao_detail_cancel)
    ImageView activityPersionalJiahaoDetailCancel;
    @BindView(R.id.details_tv1_hospital)
    TextView detailsTv1Hospital;
    @BindView(R.id.details_tv2_name)
    TextView detailsTv2Name;
    @BindView(R.id.details_tv3_time)
    TextView detailsTv3Time;
    @BindView(R.id.details_tv4_type)
    TextView detailsTv4Type;
    @BindView(R.id.details_tv5_money)
    TextView detailsTv5Money;
    @BindView(R.id.details_tv6_address)
    TextView detailsTv6Address;
    @BindView(R.id.details_tv8)
    TextView detailsTv8;
    private SharedPreferences mShared;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_jiahao_detail;
    }

    @Override
    protected void init() {
       mShared = getSharedPreferences("data",MODE_PRIVATE);
        detailsTv1Hospital.setText(mShared.getString("hos",""));

        detailsTv2Name.setText("专家姓名："+mShared.getString("name",""));
        detailsTv3Time.setText("预约就诊时间："+mShared.getString("time",""));
        detailsTv4Type.setText("门诊类型:"+mShared.getString("type",""));
        detailsTv5Money.setText("门诊费:");
        detailsTv6Address.setText("就诊地址:"+mShared.getString("address",""));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }


    @OnClick(R.id.activity_persional_jiahao_detail_cancel)
    public void onViewClicked() {
        finish();
    }
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onTouXiang(Persional_JiaHao_Bean.DataBeanX.DataBean tuXiang_bean) {
        Log.d("Activity_Persional_JiaH", "tuXiang_bean:" + tuXiang_bean);

    }
}
