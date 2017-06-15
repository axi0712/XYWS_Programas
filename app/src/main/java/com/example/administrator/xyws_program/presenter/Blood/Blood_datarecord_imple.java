package com.example.administrator.xyws_program.presenter.Blood;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.model.bean.BloodBean.updata;
import com.example.administrator.xyws_program.model.callback.MyCallBack;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;
import com.example.administrator.xyws_program.model.model_persional.ModelInter;
import com.example.administrator.xyws_program.model.model_persional.Modelimple;
import com.example.administrator.xyws_program.presenter.Blood.inter.Blood_datarecord_Inter;
import com.example.administrator.xyws_program.util.DateTimeUils;
import com.example.administrator.xyws_program.util.MD5;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.util.hgetuid;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.Inter.Datarecord_Inter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/12 14:26
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


public class Blood_datarecord_imple implements Blood_datarecord_Inter{
    private Datarecord_Inter datarecord_inter;
    private ModelInter modelInter;
    public Blood_datarecord_imple(Datarecord_Inter datarecord_inter){
        this.datarecord_inter=datarecord_inter;
        modelInter=new Modelimple();
    }

    @Override
    public void updatadb(final Context context, final String time, final String hour, final String equipment, final String hignpressure, final String lowpressure) {
       updata updata=new updata();
        updata.setXywy_userid(hgetuid.getid());
        updata.setShou_data( "temp_handly_device_identify");
        updata.setLow(Double.parseDouble(lowpressure));
        updata.setHigh(Double.parseDouble(hignpressure));
        updata.setHeart(0.0);
        updata.setDatatime(Integer.parseInt(String.valueOf(DateTimeUils.gethaomiaoDate(time+"  "+hour))));
        updata.setApp_user_id("");
        updata.setApp_data("temp_automactily_device_identify");

        ArrayList<updata> minlist=new ArrayList<>();
        minlist.add(updata);
        minlist.add(updata);

         String dataType = "xueya";
         String SECRETKEY_WEIGHT_SCALEF = "6d4e09c47c2ce556e14ffb0e12415447";
        try {
           String sn = MD5.md5s(SECRETKEY_WEIGHT_SCALEF + hgetuid.getid() + dataType
                    + minlist.get(0)+minlist.get(1) + "xywy_tizhong");
            Map<String,String> map = new HashMap<>();
            map.put("sn",sn);
            modelInter.get("http://api.yun.xywy.com/index.php/app/collect/is_collected/?xywy_userid=116925765&sort=xueya&datatime=1497503325&data=[{\"app_data\":\"temp_automactily_device_identify\",\"app_user_id\":\"\",\"datatime\":1497503220,\"heart\":0.0,\"high\":120.0,\"low\":110.0,\"shou_data\":\"temp_handly_device_identify\",\"xywy_userid\":\"116925765\"}]&app_username=xywy_tizhong",
                    map, new MyCallBack() {
                        @Override
                        public void onSuccess(String strSuccess) {
                            //创建对象，并添加到数据库
                            updatabloodpressure updatabloodpressure=new updatabloodpressure();
                            updatabloodpressure.setEquipment(equipment);
                            updatabloodpressure.setTime(time+"  "+hour);
                            updatabloodpressure.setHignpressure(hignpressure);
                            updatabloodpressure.setLowpressure(lowpressure);
                            hgetdb.getdao(context).insert(updatabloodpressure);
                            datarecord_inter.getdata();
                            Log.e("TTTTTTTTTTTTTTTT","妈的");
                            Toast.makeText(MyApp.activity, "上传血压数据成功！", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(String strError) {

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }








       // Log.e("LIST", hgetdb.getlist(context).size()+""+hgetdb.getlist(context));
      /*  List<updatabloodpressure> list=hgetdb.getlist(context);
        for(updatabloodpressure s:list){
            hgetdb.getdao(context).delete(s);
        }*/

    }
}
