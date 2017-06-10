package com.example.administrator.xyws_program.model.model_persional;

import com.example.administrator.xyws_program.model.HttpFactory;
import com.example.administrator.xyws_program.model.callback.MyCallBack;

import java.io.File;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 23:18
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


public class Modelimple implements ModelInter {
    @Override
    public void get(String url, Map<String, String> map, MyCallBack callBack) {
        HttpFactory.initParsing().get(url, map, callBack);
    }

    //
    @Override
     public void getLogin(String url,Map<String, String> map, MyCallBack callBack) {
        HttpFactory.initParsing().getLogin(url, map, callBack);
    }

    @Override
    public void getCookie(String url, Map<String, String> map, MyCallBack callBack) {
        HttpFactory.initParsing().getCookie(url, map, callBack);
    }

    @Override
    public void post(String url, Map<String, String> map, MyCallBack callBack) {
        HttpFactory.initParsing().post(url, map, callBack);
    }

    @Override
    public void postLogin(String url,Map<String, String> map, MyCallBack callBack) {
        HttpFactory.initParsing().postLogin(url, map, callBack);
    }

    @Override
    public void postCookie(String url, Map<String, String> map, MyCallBack callBack) {
        HttpFactory.initParsing().postCookie(url, map, callBack);
    }

    @Override
    public void postFile(String url, Map<String, RequestBody> map, File file, String filekey, MyCallBack callBack) {
        HttpFactory.initParsing().postFile(url, map, file,filekey,callBack);
    }
}
