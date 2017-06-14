package com.example.administrator.xyws_program.view.fragment.blood.adpter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_commensence_Bean;
import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.util.DateTimeUils;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.DeleteAlarmclickActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.information.Blood_information_ItemActivity;

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


public class AlarmclickAdapter extends BaseAdapter<alarmclickitem> {
    public AlarmclickAdapter(Context context, List<alarmclickitem> datas) {
        super(context, R.layout.alarmclick_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final alarmclickitem dataBean) {
         if(!dataBean.equals("")){
             holder.setText(R.id.time,dataBean.getTime());
             holder.setText(R.id.name,dataBean.getName());
             holder.setText(R.id.number,dataBean.getNumber());
             holder.setOnclickListener(R.id.alarmclickonclick, new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                Intent intent=new Intent(context, DeleteAlarmclickActivity.class);
                     intent.putExtra("bean",dataBean);
                     context.startActivity(intent);
                 }
             });
         }
    }
}
