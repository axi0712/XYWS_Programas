package com.example.administrator.xyws_program.presenter.doctor.select;

import com.example.administrator.xyws_program.model.bean.doctor.Select_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.view.activity.doctor.Ac_Select_Inter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;

import static com.baidu.location.g.j.G;
import static com.baidu.location.g.j.H;
import static com.baidu.location.g.j.g;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/14 0014 10:36
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

public class GetSelect implements My_Select_Inter {
    private ModelInter modelInter;
    private Ac_Select_Inter ac_select_inter;

    public GetSelect(Ac_Select_Inter ac_select_inter) {
        this.ac_select_inter = ac_select_inter;
        modelInter = new Modelimple();
    }

    @Override
    public void getInfo(String pageCount, String pageNum, String province, String title, String keyword, String illid, String IsPlus, String level) {
        Map<String, String> map = new HashMap<>();
        map.put("pageCount", pageCount);
        map.put("pageNum", pageNum);
        map.put("province", province);
        map.put("title", title);
        map.put("keyword", keyword);
        map.put("illid", illid);
        map.put("IsPlus", IsPlus);
        map.put("level", level);
        modelInter.get("http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia&fun=SearchDoctor&", map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                Gson gson = new Gson();
                Select_Bean select_bean = null;
                try {
                    select_bean = gson.fromJson(strSuccess, Select_Bean.class);
                    ac_select_inter.getinfo(select_bean.getData());


                } catch (JsonSyntaxException e) {

                }

            }

            @Override
            public void onError(String strError) {

            }
        });

    }
}
