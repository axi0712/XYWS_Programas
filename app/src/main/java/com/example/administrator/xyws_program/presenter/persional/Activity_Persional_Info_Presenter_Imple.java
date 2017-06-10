package com.example.administrator.xyws_program.presenter.persional;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_persional_Info_Presenter_Inter;
import com.example.administrator.xyws_program.view.fragment.persional.Fragment_Persional_Inter;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/10 0010 10:26
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


public class Activity_Persional_Info_Presenter_Imple implements Activity_persional_Info_Presenter_Inter {
    private ModelInter model;
    private Fragment_Persional_Inter inter;

    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    public Activity_Persional_Info_Presenter_Imple(Fragment_Persional_Inter inter) {
        this.inter = inter;
        model = new Modelimple();
        mShared = MyApp.activity.getSharedPreferences("login", Context.MODE_PRIVATE);
        mEditor = mShared.edit();

    }

    @Override
    public void info(String userid) {
        Map<String,String> map = new HashMap<>();
        map.put("userid",userid);
        model.getCookie("http://api.wws.xywy.com/index.php?act=kbb&fun=users&type=pullAccountInfo&tag=wjk&sign=ee3dd4651821d3a45f4329a86d459cb7", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.d("Activity_Persional_Info", strSuccess);

            }

            @Override
            public void onError(String strError) {

            }
        });

    }
}
