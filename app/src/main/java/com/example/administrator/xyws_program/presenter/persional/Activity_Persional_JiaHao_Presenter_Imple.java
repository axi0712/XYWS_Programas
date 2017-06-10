package com.example.administrator.xyws_program.presenter.persional;

import android.util.Log;

import com.example.administrator.xyws_program.model.bean.Persional_JiaHao_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_JiaHao_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_JiaHao_Inter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/10 0010 19:05
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


public class Activity_Persional_JiaHao_Presenter_Imple implements Activity_Persional_JiaHao_Presenter_Inter {
    private ModelInter model ;
    private Activity_Persional_JiaHao_Inter inter ;


    public Activity_Persional_JiaHao_Presenter_Imple(Activity_Persional_JiaHao_Inter inter) {
        this.inter = inter;
        model = new Modelimple();

    }

    @Override
    public void getCookie(String user_id) {
        Map<String,String> map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("pageSize","10");
        map.put("pageNum","1");
        model.getCookie(" http://api.wws.xywy.com/index.php?act=zhuanjia&fun=Plus&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&state=0", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.d("Activity_Persional_JiaH", strSuccess);
                Gson gson = new Gson();
                Persional_JiaHao_Bean bean = gson.fromJson(strSuccess, Persional_JiaHao_Bean.class);
                List<Persional_JiaHao_Bean.DataBeanX.DataBean> mList = bean.getData().getData();
                inter.loadData(mList);
            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
