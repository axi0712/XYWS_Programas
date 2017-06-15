package com.example.administrator.xyws_program.presenter.doctor;

import android.util.Log;

import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.view.activity.doctor.Ac_Questions_Inter;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/13 0013 11:35
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

public class MyQuestions implements Questions_Inter {
    private ModelInter modelInter;
    private Ac_Questions_Inter inter;

    public MyQuestions(Ac_Questions_Inter inter) {
        this.inter = inter;
        modelInter = new Modelimple();


    }

    @Override
    public void getInfo(String fromurl, String userid, String title, String sex, String detail, String age) {
        Map<String,String> map = new HashMap<>();
        map.put("fromurl",fromurl);
        map.put("userid",userid);
        map.put("title",title);
        map.put("sex",sex);
        map.put("detail",detail);
        map.put("age",age);
        modelInter.postCookie("http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=club&fun=Club_ask", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                 Log.i("MyQuestion",strSuccess);
            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
