package com.example.administrator.xyws_program.view.activity.persional;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_Info_ZiLiao_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_Info_ZiLiao_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_Info_Name_Inter;

import butterknife.BindView;
import butterknife.OnClick;

public class Activity_Persional_Info_Name extends BaseActivity implements Activity_Persional_Info_Name_Inter {


    @BindView(R.id.activity_persional_info_name_cancel)
    ImageView activityPersionalInfoNameCancel;
    @BindView(R.id.activity_persional_info_name)
    TextView activityPersionalInfoName;
    @BindView(R.id.activity_persional_info)
    RelativeLayout activityPersionalInfo;
    @BindView(R.id.activity_persional_info_name_edit)
    EditText activityPersionalInfoNameEdit;
    private Activity_Persional_Info_ZiLiao_Presenter_Inter inter;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_info_name;
    }

    @Override
    protected void init() {
        mShared = getSharedPreferences("login", MODE_PRIVATE);
        mEditor = mShared.edit();
        inter = new Activity_Persional_Info_ZiLiao_Presenter_Imple(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public String getName() {
        return activityPersionalInfoNameEdit.getText().toString().trim();
    }




    @OnClick({R.id.activity_persional_info_name_cancel, R.id.activity_persional_info_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_persional_info_name_cancel:
                finish();
                break;
            case R.id.activity_persional_info_name:
                Log.d("Activity_Persional_Info", getName());
                inter.ziLiao(mShared.getString("userid", ""), mShared.getString("height", ""),
                        "2", mShared.getString("sex", ""), mShared.getString("birthday", ""), "edit", getName()
                );
               mEditor.putString("userName",getName()+"");
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

}
