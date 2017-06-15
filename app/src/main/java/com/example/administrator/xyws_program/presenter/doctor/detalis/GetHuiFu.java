package com.example.administrator.xyws_program.presenter.doctor.detalis;

import android.util.Log;

import com.example.administrator.xyws_program.model.bean.doctor.Detalis_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.view.fragment.doctor.Fragment_Doctor_Inter;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.HuiFu_Inter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 0012 17:14
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

public class GetHuiFu implements DetalisHuifu {
    private ModelInter modelInter;
    private HuiFu_Inter huiFu_inter;

    public GetHuiFu(HuiFu_Inter huiFu_inter) {

        this.huiFu_inter = huiFu_inter;
        modelInter = new Modelimple();
    }

    @Override
    public void getHuifu(String Expertid, String pageNum, String pageCount) {
        Map<String, String> map = new HashMap<>();
        map.put("expertid", Expertid);
        map.put("pageNum", pageNum);
        map.put("pageCount", pageCount);
        Log.i("hehehehe",map.toString());
        modelInter.get("http://api.wws.xywy.com//index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia&fun=DoctorRely&", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.i("json---->",strSuccess);
                Gson gson = new Gson();
                Detalis_Bean detalis_bean = gson.fromJson(strSuccess, Detalis_Bean.class);
                List<Detalis_Bean.DataBean> data = detalis_bean.getData();
                huiFu_inter.getHuiFuInfo(data);

            }

            @Override
            public void onError(String strError) {


            }
        });

    }
}
