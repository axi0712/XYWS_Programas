package com.example.administrator.xyws_program.view.fragment.blood.childactivity.information;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_commensence_Bean;
import com.example.administrator.xyws_program.presenter.Blood.Blood_information_commonsence_Imple;
import com.example.administrator.xyws_program.presenter.Blood.inter.Blood_information_commensence_inter;
import com.example.administrator.xyws_program.view.fragment.blood.adpter.MyBloodcommmensenceAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class Informationcommensence extends BaseActivity implements Informationcommensence_Inter {


    @BindView(R.id.informationdatils_toolbar_backimg)
    ImageView informationdatilsToolbarBackimg;
    @BindView(R.id.informationdatils_toolbar)
    Toolbar informationdatilsToolbar;
    @BindView(R.id.commonsencerecyclerview)
    PullToRefreshRecyclerView commonsencerecyclerview;
    @BindView(R.id.activity_infortiondetils)
    ScrollView activityInfortiondetils;
    private MyBloodcommmensenceAdapter adapter;
    private ArrayList<Blood_commensence_Bean.DataBean> arrayList;
    private Blood_information_commensence_inter inter;

    @Override
    protected int getLayout() {
        return R.layout.activity_infortiondetils;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        inter = new Blood_information_commonsence_Imple(this);
        inter.showcommonsencedata();

    }

    @Override
    public void showdata(List<Blood_commensence_Bean.DataBean> list) {

        adapter = new MyBloodcommmensenceAdapter(this, list);
        commonsencerecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        commonsencerecyclerview.setLayoutManager(manager);
        commonsencerecyclerview.setPullRefreshEnabled(false);
        //设置下拉刷新下拉加载
        commonsencerecyclerview.setLoadingMoreEnabled(false);
        commonsencerecyclerview.setPullRefreshEnabled(false);
        commonsencerecyclerview.displayLastRefreshTime(false);

    }



    @OnClick(R.id.informationdatils_toolbar_backimg)
    public void onViewClicked() {
        finish();
    }
}
