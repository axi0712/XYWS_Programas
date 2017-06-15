package com.example.administrator.xyws_program.presenter.doctor.detalis;

import android.util.Log;

import com.example.administrator.xyws_program.model.bean.doctor.HuiFu_XiangQing_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.Details_Fragment_Huifu;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.MyHuiFu_XiangQing_Inter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/13 0013 15:31
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

public class Details_Fragment_HuiFu_presenter_Imple implements Details_Fragment_huiFu_Presenter_Inter {
    private ModelInter modelInter;
    private Details_Fragment_Huifu myhuiFu_xiangQing_inter;

    public Details_Fragment_HuiFu_presenter_Imple(Details_Fragment_Huifu myhuiFu_xiangQing_inter) {
        this.myhuiFu_xiangQing_inter = myhuiFu_xiangQing_inter;
        modelInter = new Modelimple();
    }

    private List<HuiFu_XiangQing_Bean.DataBean> mlist = new ArrayList<>();
    @Override
    public void huiFu(String document_id) {
        Map<String, String> map = new HashMap<>();
        map.put("art_id", document_id);
        modelInter.get("http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=club&fun=Club_quesDetail", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.i("json---asda--->",strSuccess);
                Gson gson = new Gson();
                HuiFu_XiangQing_Bean huiFu_xiangQing_bean = gson.fromJson(strSuccess, HuiFu_XiangQing_Bean.class);
                HuiFu_XiangQing_Bean.DataBean data = huiFu_xiangQing_bean.getData();
                String url = data.getUrl();
                Log.i("url---->", url);
                myhuiFu_xiangQing_inter.getXQ(data);

            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
