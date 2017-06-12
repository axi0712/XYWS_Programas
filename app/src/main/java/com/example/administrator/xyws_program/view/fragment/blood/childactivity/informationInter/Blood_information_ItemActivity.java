package com.example.administrator.xyws_program.view.fragment.blood.childactivity.informationInter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_information_item_Bean;
import com.example.administrator.xyws_program.presenter.Blood.inter.Blood_information_commensence_item_inter;
import com.example.administrator.xyws_program.presenter.Blood.inter.Blood_information_commonsence_Item_Imple;
import com.example.administrator.xyws_program.util.DateTimeUils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Blood_information_ItemActivity extends BaseActivity implements Blood_information_Item_Inter {

    @BindView(R.id.blood_information_item_toolbar_backimg)
    ImageView bloodInformationItemToolbarBackimg;
    @BindView(R.id.blood_information_item_toolbar)
    Toolbar bloodInformationItemToolbar;
    @BindView(R.id.blood_information_item_title)
    TextView bloodInformationItemTitle;
    @BindView(R.id.blood_information_item_rln1)
    RelativeLayout bloodInformationItemRln1;
    @BindView(R.id.blood_information_item_time)
    TextView bloodInformationItemTime;
    @BindView(R.id.blood_information_item_rln2)
    RelativeLayout bloodInformationItemRln2;
    @BindView(R.id.blood_information_item_content)
    TextView bloodInformationItemContent;
    @BindView(R.id.blood_information_item_rln3)
    RelativeLayout bloodInformationItemRln3;
    @BindView(R.id.activity_infortiondetils)
    ScrollView activityInfortiondetils;
    private String id;
    private Blood_information_commensence_item_inter inter;
    private ImageView imageView;
    private TextView textView;
    private  boolean isfirst=true;
    @Override
    protected int getLayout() {

        return R.layout.activity_blood_information__item;

    }

    @Override
    protected void init() {
        imageView = (ImageView) findViewById(R.id.blood_information_item_toolbar_backimg);
        textView = (TextView) findViewById(R.id.blood_information_item_toolbar_collection);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.e("ID", id);

    }

    @Override
    protected void initListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //收藏
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isfirst){
                    textView.setBackgroundResource(R.drawable.entiny_star);
                    isfirst=false;
                }else {
                    textView.setBackgroundResource(R.drawable.empty_star);
                    isfirst=true;
                }

            }
        });
    }

    @Override
    protected void loadData() {
        inter = new Blood_information_commonsence_Item_Imple(this);
        inter.showcommonsencedata(id);
    }

    @Override
    public void showdata(Blood_information_item_Bean bean) {
        bloodInformationItemTitle.setText(bean.getData().getTitle());
        bloodInformationItemTime.setText(DateTimeUils.getDateday(bean.getData().getPubdate()));
        bloodInformationItemContent.setText(bean.getData().getBody());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
