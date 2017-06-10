package com.example.administrator.xyws_program.model.model_persional;

import com.example.administrator.xyws_program.model.callback.MyCallBack;

import java.io.File;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/10 0010 8:44
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


public interface ModelInter {
    void get(String url,Map<String, String> map, MyCallBack callBack);
    void getLogin(String url,Map<String, String> map, MyCallBack callBack);
    void getCookie(String url,Map<String, String> map, MyCallBack callBack);
    void post(String url,Map<String, String> map, MyCallBack callBack);
    void postLogin(String url,Map<String, String> map, MyCallBack callBack);
    void postCookie(String url,Map<String, String> map, MyCallBack callBack);
    void postFile(String url, Map<String, RequestBody> map, File file, String filekey, MyCallBack callBack);
}
