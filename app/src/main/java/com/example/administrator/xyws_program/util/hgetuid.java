package com.example.administrator.xyws_program.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.xyws_program.MyApp;

import static android.content.Context.MODE_PRIVATE;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:得到登陆后的UID
 * 创建人: 黑明阳
 * 创建时间: 2017/6/14 9:42
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


public class hgetuid {
    public static String getid(){
        SharedPreferences mShared= MyApp.activity.getSharedPreferences("login",MODE_PRIVATE);
        return  mShared.getString("userid","") ;
    }


}
