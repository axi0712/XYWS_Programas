package com.example.administrator.xyws_program.presenter.persional;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.model.bean.Persional_Collect_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Collect_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Collect_Inter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/12 0012 14:18
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


public class Activity_Persional_Collect_Presenter_Imple implements Activity_Persional_Collect_Presenter_Inter {
    private ModelInter model;
    private Activity_Persional_Collect_Inter inter;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    public Activity_Persional_Collect_Presenter_Imple(Activity_Persional_Collect_Inter inter) {
        this.inter = inter;
        model = new Modelimple();
        mShared = MyApp.activity.getSharedPreferences("collects", Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    @Override
    public void collect(String xywy_userid, String app_id, String sign, String tag) {
        Map<String,String> map = new HashMap<>();
        map.put("xywy_userid",xywy_userid);
        map.put("app_id",app_id);
        map.put("sign",sign);
        map.put("tag",tag);
        model.postCookie("http://api.yun.xywy.com/index.php/app/collect/list_data/111", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.e("kankanjson",strSuccess);
                Gson gson = new Gson();
                Persional_Collect_Bean persional_collect_bean = null;
                try {
                    persional_collect_bean = gson.fromJson(strSuccess, Persional_Collect_Bean.class);
                    List<Persional_Collect_Bean.Data> mList = persional_collect_bean.getData();
                    inter.loadData(mList);
                    mEditor.putString("id",persional_collect_bean.getData().get(0).getCategoryid());
//                mEditor.putString("meta",persional_collect_bean.getData().get(0).getMeta());
                    Log.d("Activity_Persional_Coll", "mEditor.putString(\"id\",persional_collect_bean.getData().get(0).getCategoryid()):" + mEditor.putString("id", persional_collect_bean.getData().get(0).getCategoryid()));
                    mEditor.commit();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
