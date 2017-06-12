package com.example.administrator.xyws_program.view.fragment.blood.adpter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_commensence_Bean;
import com.example.administrator.xyws_program.util.DateTimeUils;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.informationInter.Blood_information_ItemActivity;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/12 14:52
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


public class MyBloodcommmensenceAdapter extends BaseAdapter<Blood_commensence_Bean.DataBean> {
    public MyBloodcommmensenceAdapter(Context context, List<Blood_commensence_Bean.DataBean> datas) {
        super(context, R.layout.bloodcommensence_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final Blood_commensence_Bean.DataBean dataBean) {
         if(!dataBean.equals("")){

             holder.setText(R.id.bloodcommensence_item_title,dataBean.getTitle());
             holder.setText(R.id.bloodcommensence_item_time,DateTimeUils.getDate(dataBean.getPubdate()));
             holder.setText(R.id.bloodcommensence_item_content,dataBean.getDescription());

             holder.setOnclickListener(R.id.bloodcommensence_item_onclick, new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     Intent intent=new Intent(context, Blood_information_ItemActivity.class);
                     intent.putExtra("id",dataBean.getId());
                     context.startActivity(intent);
                 }
             });

         }
    }
}
