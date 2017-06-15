package com.example.administrator.xyws_program.view.activity.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.view.activity.doctor.adapter.MyNameAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.id;
import static android.R.attr.theme;
import static android.R.id.list;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 0012 8:05
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

public class Doctor_NameActivity extends BaseActivity {


    @BindView(R.id.btn_name_ok)
    Button btnNameOk;
    @BindView(R.id.name_gridview)
    GridView nameGridview;
    private MyNameAdapter myNameAdapter;
    private String s;


    private ArrayList<String> list = new ArrayList<>();


    @Override
    protected int getLayout() {
        return R.layout.activity_province_name;
    }


    protected void init() {
        list.clear();

        Intent intent = getIntent();
        ArrayList<String> list1 = intent.getStringArrayListExtra("list");
//contains判断是否含有
        //equest 是判断是否相同
        if (list1.contains("医师")) {
            this.list = list1;
        } else if (list1.contains("三级")) {
            this.list = list1;

        }
        myNameAdapter = new MyNameAdapter(this.list, this);
        nameGridview.setAdapter(myNameAdapter);


    }


    protected void initListener() {
        nameGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myNameAdapter.setSeclection(position);
                myNameAdapter.notifyDataSetChanged();
                s = list.get(position);
                Toast.makeText(Doctor_NameActivity.this, s, Toast.LENGTH_SHORT).show();

            }
        });

    }


    protected void loadData() {

    }


    @OnClick(R.id.btn_name_ok)
    public void onViewClicked() {

        Intent intent = getIntent();
        if (list.contains("三级")) {
            intent.putExtra("name", s);
            setResult(300, intent);
        } else if (list.contains("医师")) {
            intent.putExtra("name", s);
            setResult(200, intent);
        }

        onBackPressed();

    }
}
