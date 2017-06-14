package com.example.administrator.xyws_program.view.fragment.doctor.detalis;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaCodecList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.model.bean.doctor.Details_Share;
import com.example.administrator.xyws_program.presenter.doctor.detalis.Details_Fragment_JinYang_Presenter_Inter;
import com.example.administrator.xyws_program.presenter.doctor.detalis.Details_Frgament_JinYang_Presenter_Imple;
import com.example.administrator.xyws_program.view.fragment.doctor.adapter.JingYanAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 0012 15:49
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

public class Details_Fragment_Jingyan extends BaseFragment implements Details_Fragment_JinYang_Inter {
    @BindView(R.id.jingyan_listview)
    ListView jingyanListview;
    Unbinder unbinder;
    private Details_Fragment_JinYang_Presenter_Inter inter;
    private SharedPreferences mShared;

    private JingYanAdapter jingYanAdapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_details_jingyan;
    }

    @Override
    protected void initView(View view) {
        mShared = MyApp.activity.getSharedPreferences("", Context.MODE_PRIVATE);
        inter = new Details_Frgament_JinYang_Presenter_Imple(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        inter.jinyang(mShared.getString("expertid", ""), "1", "20");
    }

    @Override
    protected void updateTitleBar() {

    }

    @Override
    public void load(List<Details_Share.DataBean> mList) {
        jingYanAdapter = new JingYanAdapter(mList, getContext());
        jingyanListview.setAdapter(jingYanAdapter);

    }



}
