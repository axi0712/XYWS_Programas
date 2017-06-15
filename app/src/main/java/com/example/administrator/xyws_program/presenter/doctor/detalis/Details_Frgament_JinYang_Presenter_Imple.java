package com.example.administrator.xyws_program.presenter.doctor.detalis;

import android.util.Log;

import com.example.administrator.xyws_program.model.bean.doctor.Details_Share;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.Details_Fragment_JinYang_Inter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/13 0013 16:55
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

public class Details_Frgament_JinYang_Presenter_Imple implements Details_Fragment_JinYang_Presenter_Inter {
    private ModelInter model;
    private Details_Fragment_JinYang_Inter inter;

    public Details_Frgament_JinYang_Presenter_Imple(Details_Fragment_JinYang_Inter inter) {
        this.inter = inter;
        model = new Modelimple();
    }

    @Override
    public void jinyang(String id, String page, String size) {
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("page",page);
        map.put("size",size);
        model.get("http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia&fun=Article&source=cdsb", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.i("kankan_jy",strSuccess);
                Gson gson = new Gson();
                Details_Share details_share = null;

                try {
                    details_share = gson.fromJson(strSuccess, Details_Share.class);
                    List<Details_Share.DataBean> data = details_share.getData();
                    inter.load(data);
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
