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

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.bean.Persional_Collect_Bean;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_Collect_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Collect_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Collect_Inter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/11 0011 19:18
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


public class Activity_Persional_Collect extends BaseActivity implements Activity_Persional_Collect_Inter {
    @BindView(R.id.activity_persional_collect_cancel)
    ImageView activityPersionalCollectCancel;
    @BindView(R.id.activity_persional_collect_recycle)
    RecyclerView activityPersionalCollectRecycle;
    private List<Persional_Collect_Bean.Data> mList = new ArrayList<>();
    private Activity_Persional_Collect_Presenter_Inter inter ;
    private SharedPreferences mShared;
    @Override
    protected int getLayout() {
        return R.layout.activity_persional_collect;
    }

    @Override
    protected void init() {
        mShared = getSharedPreferences("login",MODE_PRIVATE);
     inter = new Activity_Persional_Collect_Presenter_Imple(this);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        LinearLayoutManager lin = new LinearLayoutManager(Activity_Persional_Collect.this);
        inter.collect(mShared.getString("userid",""),"2","2c19b2821ebc5306c3ac37bac5b4288b","BloodAndroid");
        activityPersionalCollectRecycle.setLayoutManager(lin);
    }

    @Override
    public void getCancel() {

    }

    @Override
    public void loadData(List<Persional_Collect_Bean.Data> mList) {
        activityPersionalCollectRecycle.setAdapter(new MyAdapter(mList));
        Log.d("Activity_Persional_Coll", "mList:" + mList);
    }



    @OnClick(R.id.activity_persional_collect_cancel)
    public void onViewClicked() {
        finish();
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
      private List<Persional_Collect_Bean.Data> mList = new ArrayList<>();

        public MyAdapter(List<Persional_Collect_Bean.Data> mList) {
            this.mList = mList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(Activity_Persional_Collect.this).inflate(R.layout.activity_persional_collect_item,null);
            MyViewHolder holder = new MyViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
                Persional_Collect_Bean.Data data = mList.get(position);
            holder.mtext.setText(data.getTitle());
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Activity_Persional_Collect.this,Activity_Persional_Collect_Detail.class);
                    startActivity(in);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mList.isEmpty()?0:mList.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView mtext;
            private LinearLayout layout;
            public MyViewHolder(View itemView) {
                super(itemView);
                mtext = (TextView) itemView.findViewById(R.id.activity_persional_collect_item_text);
                layout = (LinearLayout) itemView.findViewById(R.id.activity_persional_collect_item);
            }
        }
    }
}
