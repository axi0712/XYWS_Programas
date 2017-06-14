package com.example.administrator.xyws_program.view.fragment.doctor.detalis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.model.bean.doctor.Detalis_Bean;
import com.example.administrator.xyws_program.model.bean.doctor.HuiFu_XiangQing_Bean;
import com.example.administrator.xyws_program.presenter.doctor.detalis.Details_Fragment_HuiFu_presenter_Imple;
import com.example.administrator.xyws_program.presenter.doctor.detalis.Details_Fragment_huiFu_Presenter_Inter;
import com.example.administrator.xyws_program.presenter.doctor.detalis.DetalisHuifu;
import com.example.administrator.xyws_program.presenter.doctor.detalis.GetHuiFu;
import com.example.administrator.xyws_program.presenter.doctor.detalis.HuiFu_XiangQing_Inter;
import com.example.administrator.xyws_program.presenter.doctor.detalis.Huifu_XiangQing;
import com.example.administrator.xyws_program.view.activity.doctor.MyDoctor_Web;
import com.example.administrator.xyws_program.view.fragment.doctor.adapter.HuiFuAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.attr.data;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 0012 15:36
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

public class Details_Fragment_Huifu extends BaseFragment implements HuiFu_Inter {
    @BindView(R.id.huifu_listview)
    ListView huifuListview;
    Unbinder unbinder;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String expertid;
    private DetalisHuifu detalisHuifu;
    private List<Detalis_Bean.DataBean> mlist = new ArrayList<>();

    private Details_Fragment_huiFu_Presenter_Inter inter;
    private String url;

    @Override
    protected int layoutId() {
        return R.layout.fragment_details_huifu;
    }

    @Override
    protected void initView(View view) {
          inter = new Details_Fragment_HuiFu_presenter_Imple(this);
    }

    @Override
    protected void initData() {
        detalisHuifu = new GetHuiFu(this);
        sharedPreferences = getContext().getSharedPreferences("", getContext().MODE_PRIVATE);
        expertid = sharedPreferences.getString("expertid", "");
        Log.i("expertid", expertid);
        detalisHuifu.getHuifu(expertid, "1", "10");


    }

    @Override
    protected void initListener() {
        huifuListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String document_id1 = mlist.get(position).getDocument_id();
                Log.i("idididid", document_id1);
                inter.huiFu(document_id1);
                Intent intent = new Intent(getContext(), MyDoctor_Web.class);
                intent.putExtra("url",url);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void updateTitleBar() {

    }

    private HuiFuAdapter huiFuAdapter;

    @Override
    public void getHuiFuInfo(List<Detalis_Bean.DataBean> data) {
        this.mlist = data;

        huiFuAdapter = new HuiFuAdapter(data, getContext());
        huifuListview.setAdapter(huiFuAdapter);
        //


    }

    @Override
    public void getXQ(HuiFu_XiangQing_Bean.DataBean data) {
        url = data.getUrl();
        Log.i("DETAIL_URL",url);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
