package com.example.administrator.xyws_program.view.activity.doctor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.doctor.adapter.MyProvinceAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/11 0011 19:48
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

public class Doctor_ProvinceActivity extends BaseActivity {
    @BindView(R.id.province_listview)
    ListView provinceListview;
    @BindView(R.id.Province_back)
    ImageView ProvinceBack;
    //省份数据
    private String[] srt = {"不限", "北京市", "山东省", "山西省", "河北省", "河南省", "天津市 ", "辽宁省", "黑龙江省", "吉林省", "湖北省", "湖南省", "上海市", "四川省",
            "重庆市", "陕西省", "甘肃省", "云南省", "新疆维吾尔自治区", "内蒙古自治区", "海南省", "贵州省", "青海省", "广东省", "宁夏回族自治区", "西藏自治区", "广西壮族自治区", "江苏省", "浙江省", "安徽省", "江西省", "福建省",
    };
    //Listview适配器
    private MyProvinceAdapter myProvinceAdapter;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;


    @Override
    protected int getLayout() {
        return R.layout.activity_province;
    }

    @Override
    protected void init() {
        myProvinceAdapter = new MyProvinceAdapter(srt, Doctor_ProvinceActivity.this);
        provinceListview.setAdapter(myProvinceAdapter);
        sharedPreferences = getSharedPreferences("province", MODE_PRIVATE);


    }

    @Override
    protected void initListener() {
        provinceListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = srt[position];

                edit = sharedPreferences.edit();
                edit.putString("province", s);
                edit.commit();
                finish();
//                finish();
//                Toast.makeText(Doctor_ProvinceActivity.this, srt[position] + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void loadData() {

    }


    @OnClick(R.id.Province_back)
    public void onViewClicked() {

        edit.putString("province", "");
        edit.commit();
        finish();

    }
}
