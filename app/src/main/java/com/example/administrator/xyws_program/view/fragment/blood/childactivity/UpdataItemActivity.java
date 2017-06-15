package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdataItemActivity extends BaseActivity {

    @BindView(R.id.updataitem_toolbar_backimg)
    ImageView updataitemToolbarBackimg;
    @BindView(R.id.updataitem_toolbar)
    Toolbar updataitemToolbar;
    @BindView(R.id.updataitem_tv1)
    TextView updataitemTv1;
    @BindView(R.id.lin1)
    RelativeLayout lin1;
    @BindView(R.id.updataitem_tv2)
    TextView updataitemTv2;
    @BindView(R.id.lin2)
    RelativeLayout lin2;
    @BindView(R.id.updataitem_tv3)
    TextView updataitemTv3;
    @BindView(R.id.lin3)
    RelativeLayout lin3;
    @BindView(R.id.updataitem_tv4)
    TextView updataitemTv4;
    @BindView(R.id.lin4)
    RelativeLayout lin4;
    @BindView(R.id.activity_updata_item)
    RelativeLayout activityUpdataItem;
    private updatabloodpressure bean;

    @Override
    protected int getLayout() {
        return R.layout.activity_updata_item;
    }

    @Override
    protected void init() {
        ///
        Intent intent = getIntent();
        bean = (updatabloodpressure) intent.getSerializableExtra("bean");

        updataitemTv1.setText(bean.getHignpressure());
        updataitemTv2.setText("欧姆龙");
        updataitemTv3.setText(bean.getTime());
        updataitemTv4.setText("是");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.updataitem_toolbar_backimg)
    public void onViewClicked() {
        finish();
    }
}
