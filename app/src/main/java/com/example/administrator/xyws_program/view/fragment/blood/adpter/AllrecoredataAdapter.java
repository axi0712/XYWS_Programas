package com.example.administrator.xyws_program.view.fragment.blood.adpter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.DeleteAlarmclickActivity;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.UpdataItemActivity;

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


public class AllrecoredataAdapter extends BaseAdapter<updatabloodpressure> {
    public AllrecoredataAdapter(Context context, List<updatabloodpressure> datas) {
        super(context, R.layout.allrecordata_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final updatabloodpressure dataBean) {
         if(!dataBean.equals("")){
             holder.setText(R.id.bloodpressuretv,dataBean.getHignpressure()+"/"+dataBean.getLowpressure());
             holder.setText(R.id.bloodpressuretime,dataBean.getTime());
             holder.setOnclickListener(R.id.bloodpressureonclick, new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                Intent intent=new Intent(context, UpdataItemActivity.class);
                     intent.putExtra("bean",dataBean);
                     context.startActivity(intent);
                 }
             });
         }
    }
}
