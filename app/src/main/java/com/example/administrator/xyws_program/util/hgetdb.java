package com.example.administrator.xyws_program.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.xyws_program.model.db.DaoMaster;
import com.example.administrator.xyws_program.model.db.DaoSession;
import com.example.administrator.xyws_program.model.db.alarmclickitem;
import com.example.administrator.xyws_program.model.db.alarmclickitemDao;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;
import com.example.administrator.xyws_program.model.db.updatabloodpressureDao;

import java.util.List;




/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:数据库工具类
 * 创建人: 黑明阳
 * 创建时间: 2017/6/13 11:56
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


public class hgetdb {


    public static updatabloodpressureDao getdao(Context context){

      DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "updatabloodpressure.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        updatabloodpressureDao userDao=daoSession.getUpdatabloodpressureDao();

        return  userDao;
    }

    public static List getlist(Context context){
        List<updatabloodpressure> list = getdao(context).queryBuilder().list();
        return list;
    }
    public static alarmclickitemDao gettwodao(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "alarmclickitem.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        alarmclickitemDao userDao=daoSession.getAlarmclickitemDao();
        return  userDao;
    }

    public static List gettwolist(Context context){
        List<alarmclickitem> list = gettwodao(context).queryBuilder().list();
        return list;
    }

}
