package com.example.administrator.xyws_program.view.fragment.blood.childactivity.informationInter;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_commensence_Bean;
import com.example.administrator.xyws_program.presenter.Blood.Blood_information_commonsence_Imple;
import com.example.administrator.xyws_program.presenter.Blood.Blood_information_inspect_Imple;
import com.example.administrator.xyws_program.presenter.Blood.Blood_information_recipes_Imple;
import com.example.administrator.xyws_program.presenter.Blood.inter.Blood_information_commensence_inter;
import com.example.administrator.xyws_program.view.fragment.blood.adpter.MyBloodcommmensenceAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InspectActivity extends BaseActivity implements Informationcommensence_Inter {


    @BindView(R.id.inspect_toolbar_backimg)
    ImageView inspectToolbarBackimg;
    @BindView(R.id.inspect_toolbar)
    Toolbar inspectToolbar;
    @BindView(R.id.inspectrecyclerview)
    PullToRefreshRecyclerView inspectrecyclerview;
    @BindView(R.id.activity_infortiondetils)
    ScrollView activityInfortiondetils;
    private MyBloodcommmensenceAdapter adapter;
    private ArrayList<Blood_commensence_Bean.DataBean> arrayList;
    private Blood_information_commensence_inter inter;
    @Override
    protected int getLayout() {
        return R.layout.activity_inspect;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        inter = new Blood_information_inspect_Imple(this);

        inter.showcommonsencedata();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.inspect_toolbar_backimg)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showdata(List<Blood_commensence_Bean.DataBean> list) {
        adapter = new MyBloodcommmensenceAdapter(this, list);
        inspectrecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        inspectrecyclerview.setLayoutManager(manager);
        inspectrecyclerview.setPullRefreshEnabled(false);
        //设置下拉刷新下拉加载
        inspectrecyclerview.setLoadingMoreEnabled(false);
        inspectrecyclerview.setPullRefreshEnabled(false);
        inspectrecyclerview.displayLastRefreshTime(false);
    }
}
