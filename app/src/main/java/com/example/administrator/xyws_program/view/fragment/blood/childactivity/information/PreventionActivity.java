package com.example.administrator.xyws_program.view.fragment.blood.childactivity.information;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_commensence_Bean;
import com.example.administrator.xyws_program.presenter.Blood.Blood_information_prevention_Imple;
import com.example.administrator.xyws_program.presenter.Blood.inter.Blood_information_commensence_inter;
import com.example.administrator.xyws_program.view.fragment.blood.adpter.MyBloodcommmensenceAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreventionActivity extends BaseActivity  implements Informationcommensence_Inter{


    @BindView(R.id.prevention_toolbar_backimg)
    ImageView preventionToolbarBackimg;
    @BindView(R.id.prevention_toolbar)
    Toolbar preventionToolbar;
    @BindView(R.id.preventionrecyclerview)
    PullToRefreshRecyclerView preventionrecyclerview;
    @BindView(R.id.activity_infortiondetils)
    ScrollView activityInfortiondetils;
    private MyBloodcommmensenceAdapter adapter;
    private ArrayList<Blood_commensence_Bean.DataBean> arrayList;
    private Blood_information_commensence_inter inter;
    @Override
    protected int getLayout() {
        return R.layout.activity_prevention;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        inter = new Blood_information_prevention_Imple(this);

        inter.showcommonsencedata();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.prevention_toolbar_backimg)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showdata(List<Blood_commensence_Bean.DataBean> list) {
        adapter = new MyBloodcommmensenceAdapter(this, list);
        preventionrecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        preventionrecyclerview.setLayoutManager(manager);
        preventionrecyclerview.setPullRefreshEnabled(false);
        //设置下拉刷新下拉加载
        preventionrecyclerview.setLoadingMoreEnabled(false);
        preventionrecyclerview.setPullRefreshEnabled(false);
        preventionrecyclerview.displayLastRefreshTime(false);
    }
}
