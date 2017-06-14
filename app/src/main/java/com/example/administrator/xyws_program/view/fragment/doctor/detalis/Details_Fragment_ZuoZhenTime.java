package com.example.administrator.xyws_program.view.fragment.doctor.detalis;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.view.fragment.doctor.adapter.ChuZhenAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 0012 15:46
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

public class Details_Fragment_ZuoZhenTime extends BaseFragment {
    @BindView(R.id.chuzhen_gridview)
    GridView chuzhenGridview;
    Unbinder unbinder;

    private ChuZhenAdapter chuzhenadapter;
    private List<Integer> mlist = new ArrayList<>();

    @Override
    protected int layoutId() {
        return R.layout.fragment_details_zuozhentime;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        mlist.clear();
        Intent intent = getActivity().getIntent();
        String menzhen = intent.getStringExtra("menzhen");
        Log.e("--->", " " + menzhen);
        if (menzhen.contains("星期一") && menzhen.contains("上午")) {
            mlist.add(0);
        }
        if (menzhen.contains("星期二") && menzhen.contains("上午")) {
            mlist.add(1);
        }
        if (menzhen.contains("星期三") && menzhen.contains("上午")) {
            mlist.add(2);
        }
        if (menzhen.contains("星期四") && menzhen.contains("上午")) {
            mlist.add(3);
        }
        if (menzhen.contains("星期五") && menzhen.contains("上午")) {
            mlist.add(4);
        }
        if (menzhen.contains("星期六") && menzhen.contains("上午")) {
            mlist.add(5);
        }
        if (menzhen.contains("星期日") && menzhen.contains("上午")) {
            mlist.add(6);
        }

        if (menzhen.contains("星期一") && menzhen.contains("下午")) {
            mlist.add(7);
        }
        if (menzhen.contains("星期二") && menzhen.contains("下午")) {
            mlist.add(8);
        }
        if (menzhen.contains("星期三") && menzhen.contains("下午")) {
            mlist.add(9);
        }
        if (menzhen.contains("星期四") && menzhen.contains("下午")) {
            mlist.add(10);
        }
        if (menzhen.contains("星期五") && menzhen.contains("下午")) {
            mlist.add(11);
        }
        if (menzhen.contains("星期六") && menzhen.contains("下午")) {
            mlist.add(12);
        }
        if (menzhen.contains("星期日") && menzhen.contains("下午")) {
            mlist.add(13);
        }
//晚上
        if (menzhen.contains("星期一") && menzhen.contains("晚上")) {
            mlist.add(14);
        }
        if (menzhen.contains("星期二") && menzhen.contains("晚上")) {
            mlist.add(15);
        }
        if (menzhen.contains("星期三") && menzhen.contains("晚上")) {
            mlist.add(16);
        }
        if (menzhen.contains("星期四") && menzhen.contains("晚上")) {
            mlist.add(17);
        }
        if (menzhen.contains("星期五") && menzhen.contains("晚上")) {
            mlist.add(18);
        }
        if (menzhen.contains("星期六") && menzhen.contains("晚上")) {
            mlist.add(19);
        }
        if (menzhen.contains("星期日") && menzhen.contains("晚上")) {
            mlist.add(20);
        }

        chuzhenadapter = new ChuZhenAdapter("出诊",mlist,getContext());
        chuzhenGridview.setAdapter(chuzhenadapter);


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


}
