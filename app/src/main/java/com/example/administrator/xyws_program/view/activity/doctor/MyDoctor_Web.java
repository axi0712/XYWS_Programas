package com.example.administrator.xyws_program.view.activity.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.doctor.HuiFu_XiangQing_Bean;
import com.example.administrator.xyws_program.presenter.doctor.detalis.Huifu_XiangQing;
import com.example.administrator.xyws_program.view.fragment.doctor.detalis.MyHuiFu_XiangQing_Inter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/13 0013 8:05
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

public class MyDoctor_Web extends BaseActivity  {
    @BindView(R.id.Details_back)
    ImageView DetailsBack;
    @BindView(R.id.web_linlayout)
    LinearLayout webLinlayout;
    @BindView(R.id.doctor_webview)
    WebView doctorWebview;
    private String url2;


    @Override
    protected int getLayout() {
        return R.layout.doctor_webview;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        url2 = intent.getStringExtra("url");




    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        doctorWebview.loadUrl(url2);

        doctorWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });

    }


    @OnClick(R.id.Details_back)
    public void onViewClicked() {
        finish();
    }

//    @Override
//    public void getXQ(List<HuiFu_XiangQing_Bean.DataBean> mlist) {
//        url = mlist.get(count).getUrl();
//        Log.i("url---------------->",url);
//    }


}
