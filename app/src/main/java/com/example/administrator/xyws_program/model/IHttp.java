package com.example.administrator.xyws_program.model;

import java.io.File;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述: 网络请求的方法
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 8:44
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


public interface IHttp {
    //普通的get请求
    void get(String url, Map<String,String> map,MyCallBack callBack);
    //带cookie值得get请求
    void getCookie(String url,Map<String,String> map,MyCallBack callBack);
    //获取cookie值得get请求
    void getLogin(String url,Map<String,String> map,MyCallBack callBack);
    //普通的post请求
    void post(String url, Map<String,String> map,MyCallBack callBack);
    //带cookie值得post请求
    void postCookie(String url,Map<String,String> map, MyCallBack callBack);
    //获取cookie值得post请求
    void postLogin(String url,Map<String,String> map,MyCallBack callBack);
    //上传文件的post请求
    void postFile(String url, Map<String, RequestBody> map, File file, String filekey, MyCallBack callBack);
}
