package com.example.administrator.xyws_program.presenter.persional;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;


import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.model.bean.Persional_Login_Bean;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Login_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Login_view_Inter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 21:32
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


public class Activity_Persional_login_Presenter_Imple implements Activity_Persional_Login_Presenter_Inter {
    private Activity_Persional_Login_view_Inter inter;
    private ModelInter inters ;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    public Activity_Persional_login_Presenter_Imple(Activity_Persional_Login_view_Inter inter) {
        this.inter = inter;
        inters = new Modelimple();
        mShared = MyApp.activity.getSharedPreferences("login", Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    @Override
    public void login(String name, String pwd) {
        //name..
        if(name.isEmpty()||pwd.isEmpty()){
            return;
        }else {
            Map<String, String> map = new HashMap<>();
            map.put("phonenum", name);
            map.put("password", pwd);
            inters.post("http://api.wws.xywy.com/index.php?tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=kbb&fun=users&type=login",map, new MyCallBack() {
                @Override
                public void onSuccess(String strSuccess) {
                    Log.d("Activity_Persional_logi", strSuccess);
                    Gson gson = new Gson();
                    Persional_Login_Bean persional_login_bean = gson.fromJson(strSuccess, Persional_Login_Bean.class);
                    mEditor.putString("userid",persional_login_bean.getUserid()+"");
                    mEditor.putString("phonenum",persional_login_bean.getPhonenum()+"");
                    mEditor.commit();
//                    Log.d("Activity_Persional_logi", persional_login_bean.getUserid());
                    Toast.makeText(MyApp.activity, persional_login_bean.getUserid(), Toast.LENGTH_SHORT).show();
                    inter.getimg();
                }

                @Override
                public void onError(String strError) {

                    Log.d("Activity_Persional_logi", strError);
                }
            });
        }
    }
}
