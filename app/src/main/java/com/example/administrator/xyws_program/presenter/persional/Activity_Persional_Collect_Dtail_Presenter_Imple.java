package com.example.administrator.xyws_program.presenter.persional;

import android.util.Log;

import com.example.administrator.xyws_program.model.bean.Persional_Collect_Detail_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Collect_Detail_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Collect_Detail_Inter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/12 0012 15:36
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


public class Activity_Persional_Collect_Dtail_Presenter_Imple implements Activity_Persional_Collect_Detail_Presenter_Inter {
    private ModelInter model;
    private Activity_Persional_Collect_Detail_Inter inter;

    public Activity_Persional_Collect_Dtail_Presenter_Imple(Activity_Persional_Collect_Detail_Inter inter) {
        this.inter = inter;
        model = new Modelimple();
    }


    @Override
    public void detail(String id, String dir) {
        Map<String,String> map = new HashMap<>();
//        map.put("id",id);
//        map.put("dir",dir);
        Log.d("Activity_Persional_Coll", map.toString());
        model.getCookie("http://api.wws.xywy.com/index.php?act=zixun&fun=getHealthPlazeDetail&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae&id=1494642&dir=zhuanti_nk", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.d("Activity_Persional_Coll", strSuccess);
                Gson gson = new Gson();
                Persional_Collect_Detail_Bean persional_collect_bean = gson.fromJson(strSuccess, Persional_Collect_Detail_Bean.class);
                inter.loadD(persional_collect_bean.getData());

            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
