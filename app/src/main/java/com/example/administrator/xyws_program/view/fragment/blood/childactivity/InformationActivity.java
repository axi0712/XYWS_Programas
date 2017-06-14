package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.information.Informationcommensence;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.information.InspectActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.information.PreventionActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.information.RecipesActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.information.TreatmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InformationActivity extends BaseActivity {


    @BindView(R.id.information_toolbar_backimg)
    ImageView informationToolbarBackimg;
    @BindView(R.id.information_toolbar)
    Toolbar informationToolbar;
    @BindView(R.id.commonsence)
    TextView commonsence;
    @BindView(R.id.recipes)
    TextView recipes;
    @BindView(R.id.information_lin1)
    LinearLayout informationLin1;
    @BindView(R.id.prevention)
    TextView prevention;
    @BindView(R.id.treatment)
    TextView treatment;
    @BindView(R.id.information_lin2)
    LinearLayout informationLin2;
    @BindView(R.id.inspect)
    TextView inspect;
    @BindView(R.id.information_lin3)
    LinearLayout informationLin3;
    @BindView(R.id.activity_information)
    ScrollView activityInformation;
    private ImageView informationToolbarBackimg1;

    @Override
    protected int getLayout() {
        return R.layout.activity_information;
    }

    @Override
    protected void init() {
        informationToolbarBackimg1 = (ImageView) findViewById(R.id.information_toolbar_backimg);
    }

    @Override
    protected void initListener() {
        informationToolbarBackimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

    @OnClick({R.id.commonsence, R.id.recipes, R.id.prevention, R.id.treatment, R.id.inspect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.commonsence:
                Intent intent1=new Intent(this,Informationcommensence.class);
                startActivity(intent1);
                break;
            case R.id.recipes:
                Intent intent2=new Intent(this,RecipesActivity.class);
                startActivity(intent2);
                break;
            case R.id.prevention:
                Intent intent3=new Intent(this,PreventionActivity.class);
                startActivity(intent3);
                break;
            case R.id.treatment:
                Intent intent4=new Intent(this,TreatmentActivity.class);
                startActivity(intent4);
                break;
            case R.id.inspect:
                Intent intent5=new Intent(this,InspectActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
