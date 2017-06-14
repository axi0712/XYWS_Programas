package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.view.fragment.blood.adpter.AllrecoredataAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllrecoredataActivity extends BaseActivity {


    @BindView(R.id.allrecordatarecyclerview)
    PullToRefreshRecyclerView allrecordatarecyclerview;
    @BindView(R.id.activity_allrecoredata)
    RelativeLayout activityAllrecoredata;
    private AllrecoredataAdapter adapter;
    private ImageView imageView;

    @Override
    protected int getLayout() {
        return R.layout.activity_allrecoredata;
    }

    @Override
    protected void init() {
        imageView = (ImageView) findViewById(R.id.allrecordatare_toolbar_backimg);
    }

    @Override
    protected void initListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {
        //删除所有数据
     /*   List<updatabloodpressure> list=hgetdb.getlist(this);
        for(updatabloodpressure s:list){
            hgetdb.getdao(this).delete(s);
        }*/

        adapter = new AllrecoredataAdapter(this, hgetdb.getlist(this));
        allrecordatarecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        allrecordatarecyclerview.setLayoutManager(manager);
        allrecordatarecyclerview.setPullRefreshEnabled(false);
        //设置下拉刷新下拉加载
        allrecordatarecyclerview.setLoadingMoreEnabled(false);
        allrecordatarecyclerview.setPullRefreshEnabled(false);
        allrecordatarecyclerview.displayLastRefreshTime(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
