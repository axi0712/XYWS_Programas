package com.example.administrator.xyws_program.presenter.persional;

import android.util.Log;

import com.example.administrator.xyws_program.model.ModelInter;
import com.example.administrator.xyws_program.model.Modelimple;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.presenter.Activity_Persional_Login_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Login_view_Inter;

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
    public Activity_Persional_login_Presenter_Imple(Activity_Persional_Login_view_Inter inter) {
        this.inter = inter;
        inters = new Modelimple();
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
            inters.get(map, new MyCallBack() {
                @Override
                public void onSuccess(String strSuccess) {
                    Log.d("Activity_Persional_logi", strSuccess);
                }

                @Override
                public void onError(String strError) {
                    Log.d("Activity_Persional_logi", strError);
                }
            });
        }
    }
}
