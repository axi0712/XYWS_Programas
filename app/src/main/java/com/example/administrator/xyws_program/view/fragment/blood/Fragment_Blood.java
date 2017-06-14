package com.example.administrator.xyws_program.view.fragment.blood;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.view.activity.MainActivity;
import com.example.administrator.xyws_program.view.fragment.blood.adpter.FloodViewpageAdapter;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.AlarmclickActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.AllrecoredataActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.DatarecordActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.InformationActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.RequstdoctorActivity;
import com.example.administrator.xyws_program.view.fragment.blood.viewpagerFragment.DayFragment;
import com.example.administrator.xyws_program.view.fragment.blood.viewpagerFragment.MonthFragment;
import com.example.administrator.xyws_program.view.fragment.blood.viewpagerFragment.WeekFragment;
import com.example.administrator.xyws_program.view.fragment.blood.viewpagerFragment.YearFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 16:05
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


public class Fragment_Blood extends BaseFragment implements fragment_Blood_Inter, View.OnClickListener {

    @BindView(R.id.hupdatafloodpressure)
    ImageView hupdatafloodpressure;
    @BindView(R.id.hlatelydata)
    TextView hlatelydata;
    @BindView(R.id.hdatatime)
    TextView hdatatime;
    @BindView(R.id.hday)
    RadioButton hday;
    @BindView(R.id.hweek)
    RadioButton hweek;
    @BindView(R.id.hmonth)
    RadioButton hmonth;
    @BindView(R.id.hyear)
    RadioButton hyear;
    @BindView(R.id.hradiogroup)
    RadioGroup hradiogroup;
    @BindView(R.id.hmaxminrln)
    LinearLayout hmaxminrln;
    @BindView(R.id.hviewpager)
    ViewPager hviewpager;
    @BindView(R.id.requstionddoctor)
    TextView requstionddoctor;
    @BindView(R.id.information)
    TextView information;
    @BindView(R.id.alarmclock)
    TextView alarmclock;
    Unbinder unbinder;

    private ArrayList<Fragment> fragments=new ArrayList<>();
    private FloodViewpageAdapter adapter;
    private RelativeLayout viewpageronclick;

    @Override
    protected int layoutId() {
        return R.layout.fragment_blood;
    }

    @Override
    protected void initView(View view) {
        viewpageronclick = (RelativeLayout) view.findViewById(R.id.viewpageronclick);
    }

    @Override
    protected void initData() {

        fragments.add(new DayFragment());
        fragments.add(new WeekFragment());
        fragments.add(new MonthFragment());
        fragments.add(new YearFragment());

        adapter = new FloodViewpageAdapter(getChildFragmentManager(),fragments);

        hviewpager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void initListener() {
        hupdatafloodpressure.setOnClickListener(this);
        hday.setOnClickListener(this);
        hweek.setOnClickListener(this);
        hmonth.setOnClickListener(this);
        hyear.setOnClickListener(this);
        requstionddoctor.setOnClickListener(this);
        information.setOnClickListener(this);
        alarmclock.setOnClickListener(this);
        viewpageronclick.setOnClickListener(this);
        hviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String id = String.valueOf(position);
                if (id.equals("0")) {
                    hday.setChecked(true);
                } else if (id.equals("1")) {
                    hweek.setChecked(true);
                } else if (id.equals("2")) {
                    hmonth.setChecked(true);
                } else if (id.equals("3")) {
                    hyear.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void loadData() {
    }

    @Override
    protected void updateTitleBar() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.VISIBLE);
            ((MainActivity) MyApp.activity).getMainTouText().setText("血压管理");
            ((MainActivity) MyApp.activity).getBloodBtn().setChecked(true);

        } else {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.GONE);
            ((MainActivity) MyApp.activity).getBloodBtn().setChecked(true);
        }
        //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void showupdatalateiy() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //上传血压数据的点击事件，跳转页面
            case R.id.hupdatafloodpressure:
                Intent intent=new Intent(getActivity(),DatarecordActivity.class);
                getActivity().startActivity(intent);
                break;
            //日点击跳转Fragment
            case R.id.hday:
                hviewpager.setCurrentItem(0);
                break;
            //周点击跳转Fragment
            case R.id.hweek:
                hviewpager.setCurrentItem(1);
                break;
            //月点击跳转Fragment
            case R.id.hmonth:
                hviewpager.setCurrentItem(2);
                break;
            //年点击跳转Fragment
            case R.id.hyear:
                hviewpager.setCurrentItem(3);
                break;
            //viewpager点击跳转页面
            case R.id.viewpageronclick:
                Intent intent1=new Intent(getActivity(),AllrecoredataActivity.class);
                getActivity().startActivity(intent1);
                break;
            //问医生跳转页面
            case R.id.requstionddoctor:
                Intent intent2=new Intent(getActivity(),RequstdoctorActivity.class);
                getActivity().startActivity(intent2);
                break;
            //资讯跳转页面
            case R.id.information:
                Intent intent3=new Intent(getActivity(),InformationActivity.class);
                getActivity().startActivity(intent3);
                break;
            //提醒跳转页面
            case R.id.alarmclock:
                Intent intent4=new Intent(getActivity(),AlarmclickActivity.class);
                getActivity().startActivity(intent4);
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        List<updatabloodpressure> list=  hgetdb.getlist(getActivity());
        updatabloodpressure bean= list.get(list.size()-1);
        hlatelydata.setText(bean.getHignpressure()+"/"+bean.getLowpressure());
        hdatatime.setText(bean.getTime());
    }
}
