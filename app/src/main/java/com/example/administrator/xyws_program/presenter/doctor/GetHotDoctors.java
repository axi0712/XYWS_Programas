package com.example.administrator.xyws_program.presenter.doctor;

import android.util.Log;

import com.example.administrator.xyws_program.model.bean.doctor.HotDoctor_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.view.fragment.doctor.Fragment_Doctor_Inter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 0012 10:38
 * 修改人:杨金阳
 * 修改内容:医生在线的四个医生的数据请求
 * 修改时间:2017-06-12
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

public class GetHotDoctors implements HotDoctor {
    private ModelInter modelInter;
    private Fragment_Doctor_Inter fragment_doctor_inter;

    public GetHotDoctors(Fragment_Doctor_Inter fragment_doctor_inter) {
        this.fragment_doctor_inter = fragment_doctor_inter;
        modelInter = new Modelimple();
    }

    @Override
    public void getHotDoctor(String pageNum, String PageCount) {
        Map<String, String> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("PageCount", PageCount);
        modelInter.get("http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia&fun=HotDoctor&", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Log.e("Json", strSuccess);
                Gson gson = new Gson();
                HotDoctor_Bean hotDoctor_bean = gson.fromJson(strSuccess, HotDoctor_Bean.class);
                List<HotDoctor_Bean.DataBean> data = hotDoctor_bean.getData();
                fragment_doctor_inter.getInfo(hotDoctor_bean);


            }

            @Override
            public void onError(String strError) {

            }
        });

    }
}
