package com.example.administrator.xyws_program.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.xyws_program.MyApp;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:  retrofit工具类
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 8:59
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


public class RetrofitDemo implements IHttp {
    private static RetrofitDemo demo;
    private Retrofit re;
    private RetrofitInter inter;
    private static SharedPreferences share;
    protected RetrofitDemo(){
        re = new Retrofit.Builder().baseUrl("http://www.baidu.com/").build();
        inter =  re.create(RetrofitInter.class);

    }
    public synchronized static RetrofitDemo getInstance(){
        if(demo == null){
            demo = new RetrofitDemo();
            return demo;
        }
        return demo;
    }
    @Override
    public void get(String url, Map<String, String> map, MyCallBack callBack) {
        Call<ResponseBody> call = inter.get(url, map);
        initCall(callBack,call);
    }



    @Override
    public void getCookie(String url, Map<String, String> map, MyCallBack callBack) {
        SharedPreferences sha = MyApp.activity.getSharedPreferences("data", Context.MODE_PRIVATE);
        Call<ResponseBody> call = inter.getCookie(sha.getString("cookie",""),url, map);
        initCalls(callBack,call);
    }

    @Override
    public void getLogin(String url, Map<String, String> map, MyCallBack callBack) {
        Call<ResponseBody> call = inter.getLogin(url, map);
        initCall(callBack,call);
    }
    @Override
    public void post(String url, Map<String, String> map, MyCallBack callBack) {
        Call<ResponseBody> call = inter.post(url, map);
        initCalls(callBack,call);
    }

    @Override
    public void postCookie(String url, Map<String, String> map, MyCallBack callBack) {
        SharedPreferences sha = MyApp.activity.getSharedPreferences("data", Context.MODE_PRIVATE);
        Call<ResponseBody> call = inter.postCookie(sha.getString("cookie",""),url, map);
        initCalls(callBack,call);
    }

    @Override
    public void postLogin(String url, Map<String, String> map, MyCallBack callBack) {
        Call<ResponseBody> call = inter.postLogin(url, map);
        initCall(callBack,call);
    }

    @Override
    public void postFile(String url, Map<String, RequestBody> map, File file, String filekey, MyCallBack callBack) {
        RequestBody fileRequest = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part part = MultipartBody.Part.createFormData(filekey, file.getName(), fileRequest);
        SharedPreferences sha = MyApp.activity.getSharedPreferences("data",Context.MODE_PRIVATE);
        Call<ResponseBody> call = inter.postFiled(sha.getString("cookie",""),url, map,part);
        initCalls(callBack,call);
    }
    private void initCall(final MyCallBack callBack, Call<ResponseBody> call) {
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    saveCookie(response);
                    try {
                        callBack.onSuccess(response.body().string());
                    } catch (IOException e) {
                        callBack.onError(e.getMessage());
                    }
                }else{
                    try {
                        callBack.onError(response.body().string());
                    } catch (IOException e) {
                        callBack.onError(e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }


    private void initCalls(final MyCallBack callBack, Call<ResponseBody> call) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response!=null&&callBack!=null){
                    if(response.isSuccessful()){
                        try {
                            callBack.onSuccess(response.body().string());
                        } catch (IOException e) {
                            callBack.onError(e.getMessage());
                        }
                    }else{
                        try {
                            callBack.onError(response.body().string());
                        } catch (IOException e) {
                            callBack.onError(e.getMessage());
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {




            }

        });



    }

    private void saveCookie(Response<ResponseBody> response) {
        String cookie = "";
        Headers head = response.headers();
        Set<String> names = head.names();
        for (String key : names) {
            String value = head.get(key);
            if (key.contains("Set-Cookie")) {
                cookie += value + ";";
                share = MyApp.activity.getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = share.edit();
                editor.putString("cookie", cookie);
                Log.i("cookie________", cookie);
                editor.commit();
            }

        }
    }


}
