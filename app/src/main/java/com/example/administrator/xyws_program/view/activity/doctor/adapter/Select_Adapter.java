package com.example.administrator.xyws_program.view.activity.doctor.adapter;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.model.bean.doctor.Select_Bean;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_DetailsActivity;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/14 0014 10:59
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

public class Select_Adapter extends com.androidkun.adapter.BaseAdapter<Select_Bean.DataBean> {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public Select_Adapter(Context context, List<Select_Bean.DataBean> datas) {
        super(context, R.layout.select_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final Select_Bean.DataBean dataBean) {
        ImageView im = holder.getView(R.id.select_img);
        String app_image = dataBean.getApp_image();
        Glide.with(context).load(app_image).into(im);
        String name = dataBean.getName();
        holder.setText(R.id.select_tv_name, name);
        String title = dataBean.getTitle();
        holder.setText(R.id.select_yisheng, title);
        String hospital = dataBean.getHospital();
        holder.setText(R.id.select_hostial, hospital);
        String depart = dataBean.getDepart();
        holder.setText(R.id.select_yike, depart);
        String teach = dataBean.getTeach();
        holder.setText(R.id.select_xueli, teach);
        String goodat = dataBean.getGoodat();
        holder.setText(R.id.select_content, goodat);
        holder.setOnclickListener(R.id.select_item_layout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = context.getSharedPreferences("", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();

                String expert_id = dataBean.getExpert_id();
                editor.putString("expertid", expert_id);
                Log.i("shard",expert_id);
                editor.commit();


                Intent intent = new Intent(context, Doctor_DetailsActivity.class);
                //头像
                String app_image = dataBean.getApp_image();
                //名字
                String name = dataBean.getName();
                //什么医生
                String title = dataBean.getTitle();
                //学历
                String teach = dataBean.getTeach();
                //医院
                String hospital = dataBean.getHospital();
                //医科
                String depart = dataBean.getDepart();
                //内容
                String goodat = dataBean.getGoodat();
                String menzhen = dataBean.getMenzhen();
                intent.putExtra("menzhen", menzhen);

                intent.putExtra("app_image", app_image);
                intent.putExtra("name", name);
                intent.putExtra("title", title);
                intent.putExtra("teach", teach);
                intent.putExtra("hospital", hospital);
                intent.putExtra("depart", depart);
                intent.putExtra("goodat", goodat);
                context.startActivity(intent);


            }
        });
    }


}
