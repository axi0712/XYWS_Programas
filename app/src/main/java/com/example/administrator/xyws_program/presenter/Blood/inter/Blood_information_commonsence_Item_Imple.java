package com.example.administrator.xyws_program.presenter.Blood.inter;

import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_commensence_Bean;
import com.example.administrator.xyws_program.model.bean.BloodBean.Blood_information_item_Bean;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.informationInter.Blood_information_Item_Inter;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.informationInter.Informationcommensence_Inter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/12 14:25
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


public class Blood_information_commonsence_Item_Imple implements Blood_information_commensence_item_inter {
   private Blood_information_Item_Inter bloodInformationItemInter;
   private ModelInter modelInter;
    public Blood_information_commonsence_Item_Imple(Blood_information_Item_Inter informationdetilsInter){
        this.bloodInformationItemInter=informationdetilsInter;
        modelInter=new Modelimple();
    }
    @Override
    public void showcommonsencedata(String id) {
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("dir","zhuanti_nk");

        //map.put("dir","zhuzhan_ys");

        modelInter.get("http://api.wws.xywy.com?act=zixun&fun=getHealthPlazeDetail&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae",
                map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
              //Log.e("FLOOD_INFORMATION_COMMONSENCE_IMPLE",strSuccess);
                Gson gson=new Gson();
                Blood_information_item_Bean bean=gson.fromJson(strSuccess,Blood_information_item_Bean.class);

                //Log.e("FLOOD_INFORMATION_COMMONSENCE_IMPLE", String.valueOf(list.size()));
                bloodInformationItemInter.showdata(bean);

            }

            @Override
            public void onError(String strError) {

            }
        });
    }
}
