package com.example.administrator.xyws_program.view.activity.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.doctor.Select_Bean;
import com.example.administrator.xyws_program.presenter.doctor.select.GetSelect;
import com.example.administrator.xyws_program.presenter.doctor.select.My_Select_Inter;
import com.example.administrator.xyws_program.view.activity.doctor.adapter.Select_Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.data;

public class Doactor_SelectActivity extends BaseActivity implements Ac_Select_Inter {
    private int count = 1;

    @BindView(R.id.select_recycleview)
    PullToRefreshRecyclerView selectRecycleview;

    private Select_Adapter select_adapter;
    private My_Select_Inter my_select_inter;
    private List<Select_Bean.DataBean> mList = new ArrayList<>();
    private String province;
    private String title;
    private String keyword;
    private String illid;
    private String isPlus;
    private String level;

    @Override
    protected int getLayout() {
        return R.layout.activity_doactor__select;
    }

    @Override
    protected void init() {
        my_select_inter = new GetSelect(this);
        Intent intent = getIntent();
        //省份
        province = intent.getStringExtra("province");
        //医生
        title = intent.getStringExtra("title");
        //关键词
        keyword = intent.getStringExtra("keyword");
        //参数 illid

        illid = intent.getStringExtra("illid");
        //参数IsPlus

        isPlus = intent.getStringExtra("IsPlus");
        //参数level

        level = intent.getStringExtra("level");


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        selectRecycleview.setLayoutManager(layoutManager);

        //是否开启下拉刷新功能
        selectRecycleview.setPullRefreshEnabled(false);
//是否开启上拉加载功能
        selectRecycleview.setLoadingMoreEnabled(true);

        //设置是否显示上次刷新的时间
        selectRecycleview.displayLastRefreshTime(false);

        //主动触发下拉刷新操作
        //pullToRefreshRV.onRefresh();
        selectRecycleview.postDelayed(new Runnable() {
            @Override
            public void run() {
                count = count + 1;
                loadData();
//                selectRecycleview.setLoadMoreComplete();
                select_adapter.notifyDataSetChanged();

                //模拟加载数据的情况


            }
        }, 3000);

    }

    @Override
    protected void initListener() {

    }


    @Override
    protected void loadData() {

        my_select_inter.getInfo("10", "1", province, title, keyword, illid, isPlus, level);

    }


    @Override
    public void getinfo(List<Select_Bean.DataBean> mlist) {
        this.mList = mlist;
        select_adapter = new Select_Adapter(this, mList);

        selectRecycleview.setAdapter(select_adapter);


    }
}
