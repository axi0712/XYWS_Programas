package com.example.administrator.xyws_program.view.fragment.persional;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.model.bean.TouXiang_Bean;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_Info_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_persional_Info_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.MainActivity;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_QuestionActivity;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_Collect;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_Info;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_JiaHao;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_Setting;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_TouXiang;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_View_Login;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 16:06
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


public class Fragment_Persional extends BaseFragment implements View.OnClickListener, Fragment_Persional_Inter {

    @BindView(R.id.fragment_persional_text)
    TextView fragmentPersionalText;
    @BindView(R.id.fragment_persional_btn_login)
    Button fragmentPersionalBtnLogin;
    @BindView(R.id.persional_btn_jiahao)
    Button persionalBtnJiahao;
    @BindView(R.id.persional_btn_collect)
    Button persionalBtnCollect;
    @BindView(R.id.persional_btn_info)
    Button persionalBtnInfo;
    @BindView(R.id.persional_btn_message)
    Button persionalBtnMessage;
    @BindView(R.id.persional_btn_Setting)
    Button persionalBtnSetting;
    Unbinder unbinder;
    private Activity_persional_Info_Presenter_Inter inter;
    private SharedPreferences mShared;
    private RelativeLayout mRela, mXian;
    private ImageView mImage;
    private TextView mName;

    @Override
    protected int layoutId() {
        return R.layout.fragment_persional;
    }

    @Override
    protected void initView(View view) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        mRela = (RelativeLayout) view.findViewById(R.id.fragment_persional_tou);
        mXian = (RelativeLayout) view.findViewById(R.id.fragment_persional_tou_rela);
        mImage = (ImageView) view.findViewById(R.id.fragment_persional_tou_image);
        mName = (TextView) view.findViewById(R.id.fragment_persional_tou_name);
    }

    @Override
    protected void initData() {
        inter = new Activity_Persional_Info_Presenter_Imple(this);
        mShared = MyApp.activity.getSharedPreferences("login", Context.MODE_PRIVATE);
        getBtn();


    }

    @Override
    public void onResume() {
        super.onResume();
        if (mShared.getString("userid", "").equals("")) {

        } else {
            mXian.setVisibility(View.INVISIBLE);
            mRela.setVisibility(View.VISIBLE);
            inter.info(userId());
            Glide.with(getContext()).load(mShared.getString("image", "")).asBitmap().centerCrop().into(new BitmapImageViewTarget(mImage) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                    ciDrawable.setCircular(true);
                    mImage.setImageDrawable(ciDrawable);
                }
            });
            mName.setText(mShared.getString("name", ""));

        }
    }

    @Override
    public void onshow() {
        super.onshow();
        getBtn();
    }

    @Override
    protected void initListener() {
        //点击头像
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity_Persional_TouXiang.class);
                startActivity(intent);

            }
        });
    }

    private void jiazai(String url) {
        Glide.with(getContext()).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(mImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                ciDrawable.setCircular(true);
                mImage.setImageDrawable(ciDrawable);
            }
        });
    }

    @Override
    protected void loadData() {
        getBtn();
    }

    @Override
    protected void updateTitleBar() {

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.GONE);

            ((MainActivity) MyApp.activity).getPersionalBtn().setChecked(true);


        } else {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.VISIBLE);
            ((MainActivity) MyApp.activity).getPersionalBtn().setChecked(false);


        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_persional_btn_login:
                Log.d("Fragment_Persional", mShared.getString("userid", ""));
                Intent ins = new Intent(MyApp.activity, Activity_Persional_View_Login.class);
                startActivityForResult(ins, 300);
                break;
            case R.id.persional_btn_jiahao:
                if (mShared.getString("userid", "").isEmpty()) {
                    Toast.makeText(MyApp.activity, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(MyApp.activity, Activity_Persional_View_Login.class);
                    startActivity(in);
                } else {
                    Intent in = new Intent(MyApp.activity, Activity_Persional_JiaHao.class);
                    startActivity(in);
                }
                break;
            case R.id.persional_btn_collect:
                if (mShared.getString("userid", "").isEmpty()) {
                    Toast.makeText(MyApp.activity, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(MyApp.activity, Activity_Persional_View_Login.class);
                    startActivity(in);
                } else {
                    Intent in = new Intent(MyApp.activity, Activity_Persional_Collect.class);
                    startActivity(in);
                }
                break;
            case R.id.persional_btn_info:
                if (mShared.getString("userid", "").isEmpty()) {
                    Toast.makeText(MyApp.activity, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(MyApp.activity, Activity_Persional_View_Login.class);
                    startActivity(in);
                } else {
                    Intent in = new Intent(MyApp.activity, Activity_Persional_Info.class);
                    startActivity(in);
                }
                break;
            case R.id.persional_btn_message:
                if (mShared.getString("userid", "").isEmpty()) {
                    Toast.makeText(MyApp.activity, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(MyApp.activity, Activity_Persional_View_Login.class);
                    startActivity(in);
                } else {
                    Intent intentq = new Intent(getContext(), Doctor_QuestionActivity.class);
                    startActivity(intentq);
                }
                break;
            case R.id.persional_btn_Setting:
                if (mShared.getString("userid", "").isEmpty()) {
                    Toast.makeText(MyApp.activity, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(MyApp.activity, Activity_Persional_View_Login.class);
                    startActivity(in);
                } else {
                    Intent in = new Intent(MyApp.activity, Activity_Persional_Setting.class);
                    startActivity(in);
                }
                break;
        }
    }

    @Override
    public void getBtn() {
        Log.d("Fragment_Persional", mShared.getString("userid", ""));
        if (mShared.getString("userid", "").isEmpty()) {
            mXian.setVisibility(View.VISIBLE);
            mRela.setVisibility(View.INVISIBLE);
            fragmentPersionalBtnLogin.setOnClickListener(this);
        } else {
            mXian.setVisibility(View.INVISIBLE);
            mRela.setVisibility(View.VISIBLE);
            Glide.with(getContext()).load(mShared.getString("image", "")).asBitmap().centerCrop().into(new BitmapImageViewTarget(mImage) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                    ciDrawable.setCircular(true);
                    mImage.setImageDrawable(ciDrawable);
                }
            });
            mName.setText(mShared.getString("name", ""));

        }
        persionalBtnJiahao.setOnClickListener(this);
        persionalBtnCollect.setOnClickListener(this);
        persionalBtnInfo.setOnClickListener(this);
        persionalBtnMessage.setOnClickListener(this);
        persionalBtnSetting.setOnClickListener(this);
    }

    @Override
    public String userId() {
        return mShared.getString("userid", "");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 300:
                switch (resultCode) {
                    case 301:
                        inter.info(userId());
                        break;
                }
                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onTouXiang(TouXiang_Bean tuXiang_bean) {
        jiazai(tuXiang_bean.getData());
        Log.d("Fragment_Persional", tuXiang_bean.getData());
    }
}


