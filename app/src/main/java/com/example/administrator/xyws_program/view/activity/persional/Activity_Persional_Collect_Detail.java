package com.example.administrator.xyws_program.view.activity.persional;

import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.Persional_Collect_Detail_Bean;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_Collect_Dtail_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Collect_Detail_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Collect_Detail_Inter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/12 0012 15:11
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


public class Activity_Persional_Collect_Detail extends BaseActivity implements Activity_Persional_Collect_Detail_Inter {
    @BindView(R.id.activity_persional_collect_detail_cancel)
    ImageView activityPersionalCollectDetailCancel;
    @BindView(R.id.activity_persional_collect_detail_collect)
    ImageView activityPersionalCollectDetailCollect;
    @BindView(R.id.activity_persional_collect_detail_title)
    TextView activityPersionalCollectDetailTitle;
    @BindView(R.id.activity_persional_collect_detail_body)
    TextView activityPersionalCollectDetailBody;
    @BindView(R.id.activity_persional_collect_detail_time)
    TextView activityPersionalCollectDetailTime;
    private Activity_Persional_Collect_Detail_Presenter_Inter inter;
    private SharedPreferences mShared;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_collect_detail;
    }

    @Override
    protected void init() {
        inter = new Activity_Persional_Collect_Dtail_Presenter_Imple(this);
        mShared = getSharedPreferences("collects", MODE_PRIVATE);


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        inter.detail("","");
    }

    @Override
    public void loadD(Persional_Collect_Detail_Bean.DataBean mList) {
        activityPersionalCollectDetailTitle.setText(mList.getTitle());
//        String date = Dates.getDate(mList.getPubdate()+"");
         activityPersionalCollectDetailTime.setText(mList.getPubdate());
        activityPersionalCollectDetailBody.setText(mList.getBody());
    }


    @OnClick(R.id.activity_persional_collect_detail_cancel)
    public void onViewClicked() {
        finish();
    }


}
