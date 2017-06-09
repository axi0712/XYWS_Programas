package com.example.administrator.xyws_program.model;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:   retrofit的接口
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 9:05
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


public interface RetrofitInter {
    //普通的get请求
    @GET
    Call<ResponseBody> get(@Url String url, @QueryMap Map<String, String> map);

    //带cookie值得get请求
    @GET
    Call<ResponseBody> getCookie(@Header("cookie") String cookie, @Url String url, @QueryMap Map<String, String> map);

    //获取cookie值得get请求
    @GET
    Call<ResponseBody> getLogin(@Url String url, @QueryMap Map<String, String> map);

    //普通的post请求
    @FormUrlEncoded
    @POST
    Call<ResponseBody> post(@Url String url, @FieldMap Map<String, String> map);

    //带cookie值得post请求
    @FormUrlEncoded
    @POST
    Call<ResponseBody> postCookie(@Header("cookie") String cookie, @Url String url, @QueryMap Map<String, String> map);

    //获取cookie值得post请求
    @FormUrlEncoded
    @POST
    Call<ResponseBody> postLogin(@Url String url, @QueryMap Map<String, String> map);

    //上传文件的post请求
    @Multipart
    @POST
    Call<ResponseBody> postFiled(@Header("Cookie") String cookie, @Url String url, @PartMap Map<String, RequestBody> params, @Part MultipartBody.Part file);
}
