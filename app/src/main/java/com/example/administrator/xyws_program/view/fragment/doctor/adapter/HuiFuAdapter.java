package com.example.administrator.xyws_program.view.fragment.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.model.bean.doctor.Detalis_Bean;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 0012 19:50
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

public class HuiFuAdapter extends BaseAdapter {
    private List<Detalis_Bean.DataBean> mlist;
    private Context context;

    public HuiFuAdapter(List<Detalis_Bean.DataBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }


    @Override
    public int getCount() {
        return mlist.isEmpty() ? 0 : mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.huifu_itme, null);
            holder.tv_title = (TextView) convertView.findViewById(R.id.huifu_item_title);
            holder.tv_content = (TextView) convertView.findViewById(R.id.huifu_item_content);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        Detalis_Bean.DataBean dataBean = mlist.get(position);
        String title = dataBean.getTitle();
        String reply = dataBean.getReply();
        holder.tv_title.setText(title);
        holder.tv_content.setText(reply);

        return convertView;
    }

    class Holder {
        private TextView tv_title, tv_content;

    }
}
