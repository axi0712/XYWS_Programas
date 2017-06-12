package com.example.administrator.xyws_program.presenter.persional;

import android.util.Log;

import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Info_ZiLiao_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Info_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Info_Name_Inter;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/12 0012 8:51
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


public class Activity_Persional_Info_ZiLiao_Presenter_Imple implements Activity_Persional_Info_ZiLiao_Presenter_Inter {
    private ModelInter model;
    private Activity_Persional_Info_Inter inter;
    private Activity_Persional_Info_Name_Inter ziliao;

    public Activity_Persional_Info_ZiLiao_Presenter_Imple(Activity_Persional_Info_Name_Inter ziliao) {
        this.ziliao = ziliao;
        model = new Modelimple();
    }

    public Activity_Persional_Info_ZiLiao_Presenter_Imple(Activity_Persional_Info_Inter inter) {
        this.inter = inter;
        model = new Modelimple();
    }

    @Override
    public void ziLiao(String userid, String height, String app_id, String sex, String birthday, String keyword, String accountstr) {
        Map<String,String> map = new HashMap<>();
        map.put("userid",userid);
        map.put("height",height);
        map.put("app_id",app_id);
        map.put("sex",sex);
        map.put("birthday",birthday);
        map.put("keyword",keyword);
        model.postCookie("http://api.wws.xywy.com/index.php?act=kbb&fun=resetProperty&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.d("Actiional_ZiLiao", strSuccess);
            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
