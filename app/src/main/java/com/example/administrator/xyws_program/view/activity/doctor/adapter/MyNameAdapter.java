package com.example.administrator.xyws_program.view.activity.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.view.zidingyiview.MyTextView;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/13 0013 19:00
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

public class MyNameAdapter extends BaseAdapter {
    private List<String> mlist;
    private Context context;
    private int lastPosition;

    public MyNameAdapter(List<String> mlist, Context context) {
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

    public void setSeclection(int position) {
        lastPosition = position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.name_item, null);
            holder.myTextView = (MyTextView) convertView.findViewById(R.id.name_item_text);

            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        String s = mlist.get(position);
        holder.myTextView.setText(s);


        if ( lastPosition == position) {//最后选择的位置
            holder.myTextView.setBackgroundColor(context.getResources().getColor(R.color.doctor_text));

        } else {
            holder.myTextView.setBackgroundColor(context.getResources().getColor(R.color.white));

        }


        return convertView;
    }

    class Holder {
        private MyTextView myTextView;
    }
}
