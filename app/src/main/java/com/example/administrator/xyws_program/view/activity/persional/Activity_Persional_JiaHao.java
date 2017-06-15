package com.example.administrator.xyws_program.view.activity.persional;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.Persional_JiaHao_Bean;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_JiaHao_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_JiaHao_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_JiaHao_Inter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/10 0010 18:35
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


public class Activity_Persional_JiaHao extends BaseActivity implements Activity_Persional_JiaHao_Inter {
    @BindView(R.id.activity_persional_jiahao_cancel)
    ImageView activityPersionalJiahaoCancel;
    @BindView(R.id.activity_persional_jiahao_recycle)
    RecyclerView activityPersionalJiahaoRecycle;
    private List<Persional_JiaHao_Bean.DataBeanX.DataBean> mLists = new ArrayList<>();
    private Activity_Persional_JiaHao_Presenter_Inter inter;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_jiahao;
    }

    @Override
    protected void init() {
        mShared = getSharedPreferences("login", MODE_PRIVATE);
        mEditor = mShared.edit();
        inter = new Activity_Persional_JiaHao_Presenter_Imple(this);
        getCancel();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        LinearLayoutManager man = new LinearLayoutManager(Activity_Persional_JiaHao.this);
        getJia();

        activityPersionalJiahaoRecycle.setLayoutManager(man);
    }

    private void getJia() {
        inter.getCookie(mShared.getString("userid", ""));

    }

    @Override
    public void getCancel() {
        activityPersionalJiahaoCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    @Override
    public void loadData(List<Persional_JiaHao_Bean.DataBeanX.DataBean> mList) {
        Log.d("Activity_Persional_JiaH", "mList:" + mList);
        activityPersionalJiahaoRecycle.setAdapter(new MyApdater(mList));

    }

    class MyApdater extends RecyclerView.Adapter<MyApdater.MyViewHolder> {
          private List<Persional_JiaHao_Bean.DataBeanX.DataBean> mList;

        public MyApdater(List<Persional_JiaHao_Bean.DataBeanX.DataBean> mList) {
            this.mList = mList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(Activity_Persional_JiaHao.this).inflate(R.layout.activity_persional_jiahao_item, null);
            MyViewHolder holder = new MyViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Persional_JiaHao_Bean.DataBeanX.DataBean bean = mList.get(position);
            Glide.with(Activity_Persional_JiaHao.this).load(bean.getExpert_pic()).into(holder.mImage);
            holder.mName.setText("专家姓名：" + bean.getExpert() + "");
            holder.mTime.setText("预约就诊时间：" + bean.getTodate() + "");
            holder.mShenHe.setText("未通过审核");
            holder.mResult.setText(bean.getReason() + "");
            holder.li.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Activity_Persional_JiaHao.this,Activity_Persional_JiaHao_Detail.class);
                    startActivity(in);
                }
            });
            Log.d("MyApdater", bean.toString());
        }


        @Override
        public int getItemCount() {
            return mList.isEmpty() ? 0 : mList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private ImageView mImage;
            private TextView mName, mTime, mShenHe, mResult;
             private LinearLayout li;
            public MyViewHolder(View v) {
                super(v);
                mImage = (ImageView) v.findViewById(R.id.activity_persional_jiahao_item_image);
                mName = (TextView) v.findViewById(R.id.activity_persional_jiahao_item_name);
                mShenHe = (TextView) v.findViewById(R.id.activity_persional_jiahao_item_shenhe);
                mTime = (TextView) v.findViewById(R.id.activity_persional_jiahao_item_time);
                mResult = (TextView) v.findViewById(R.id.activity_persional_jiahao_item_result);
                li = (LinearLayout) v.findViewById(R.id.activity_persional_jiahao_item);
            }
        }
    }
}
