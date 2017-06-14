package com.example.administrator.xyws_program.presenter.Blood;

import android.content.Context;
import android.util.Log;

import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;
import com.example.administrator.xyws_program.presenter.Blood.inter.BloodAlarmclickItem_Inter;
import com.example.administrator.xyws_program.presenter.Blood.inter.Blood_datarecord_Inter;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.Inter.AlarmclickItem_Inter;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.Inter.Datarecord_Inter;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/12 14:26
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


public class BloodAlarmclickItem_imple implements BloodAlarmclickItem_Inter {
    private AlarmclickItem_Inter datarecord_inter;

    public BloodAlarmclickItem_imple(AlarmclickItem_Inter datarecord_inter){
        this.datarecord_inter=datarecord_inter;
    }


    @Override
    public void updatadb(Context context, String time, String name, String number) {
        alarmclickitem alarmclickitem=new alarmclickitem();
        alarmclickitem.setName(name);
        alarmclickitem.setTime(time);
        alarmclickitem.setNumber(number);

        hgetdb.gettwodao(context).insert(alarmclickitem);

        datarecord_inter.getdata();
        //Log.e("LIST", hgetdb.getlist(context).size()+""+hgetdb.gettwolist(context));

    }
}
