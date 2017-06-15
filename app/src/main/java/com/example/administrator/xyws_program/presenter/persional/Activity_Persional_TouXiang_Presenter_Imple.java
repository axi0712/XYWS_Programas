package com.example.administrator.xyws_program.presenter.persional;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.model.bean.TouXiang_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_TouXiang_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_TouXiang_Inter;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/14 0014 12:03
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


public class Activity_Persional_TouXiang_Presenter_Imple implements Activity_Persional_TouXiang_Presenter_Inter {
    private ModelInter model;
    private Activity_Persional_TouXiang_Inter inter;
   private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    public Activity_Persional_TouXiang_Presenter_Imple(Activity_Persional_TouXiang_Inter inter) {
        this.inter = inter;
        model = new Modelimple();
        mShared = MyApp.activity.getSharedPreferences("login", Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }


    private RequestBody text2RequestBody(String value) {

        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

    @Override
    public void photo(String button, final File file, String filekey) {
        Map<String, RequestBody> map = new HashMap<>();
        map.put("button",text2RequestBody(button));
        model.postFile("http://api.wws.xywy.com/upload_avatar.php", map, file, filekey, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.d("Activity_Persional_TouX", strSuccess);
                Gson gson = new Gson();
                TouXiang_Bean touXiang_bean = gson.fromJson(strSuccess, TouXiang_Bean.class);
                Log.d("Activity_Persional_TouX", touXiang_bean.getData());
                EventBus.getDefault().postSticky(touXiang_bean);
            }

            @Override
            public void onError(String strError) {

            }
        });
    }

    @Override
    public void camer(String button, File file, String filekey) {
        Map<String, RequestBody> map = new HashMap<>();
        map.put("button",text2RequestBody(button));
        model.postFile("http://api.wws.xywy.com/upload_avatar.php", map, file, filekey, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.d("Activity_Persional_TouX", strSuccess);
                Gson gson = new Gson();
                TouXiang_Bean touXiang_bean = gson.fromJson(strSuccess, TouXiang_Bean.class);
                Log.d("Activity_Persional_TouX", touXiang_bean.getData());
                EventBus.getDefault().postSticky(touXiang_bean);
            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
