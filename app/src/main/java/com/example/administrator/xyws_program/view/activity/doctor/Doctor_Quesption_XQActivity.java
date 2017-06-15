package com.example.administrator.xyws_program.view.activity.doctor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.presenter.doctor.MyQuestions;
import com.example.administrator.xyws_program.presenter.doctor.Questions_Inter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Doctor_Quesption_XQActivity extends BaseActivity implements Ac_Questions_Inter {


    @BindView(R.id.Details_back)
    ImageView DetailsBack;
    @BindView(R.id.question_linlayout)
    LinearLayout questionLinlayout;
    @BindView(R.id.question_xq_content)
    TextView questionXqContent;
    @BindView(R.id.question_edtext)
    EditText questionEdtext;
    @BindView(R.id.Btn_nan)
    RadioButton BtnNan;
    @BindView(R.id.Btn_nv)
    RadioButton BtnNv;
    @BindView(R.id.quetion_ed_age)
    EditText quetionEdAge;
    @BindView(R.id.question_group)
    RadioGroup questionGroup;
    @BindView(R.id.quetion_btn)
    Button quetionBtn;
    private Questions_Inter inter;
    private SharedPreferences sharedPreferences;
    private int sex;

    @Override
    protected int getLayout() {
        return R.layout.activity_doctor__quesption__xq;
    }

    @Override
    protected void init() {

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        inter = new MyQuestions(this);
    }

    @Override
    protected void initListener() {


    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.Details_back, R.id.quetion_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Details_back:
                finish();
                break;
            //提交
            case R.id.quetion_btn:
                if (BtnNan.isChecked()) {
                    sex = 0;
                } else if (BtnNv.isChecked()) {
                    sex = 1;
                }


                if (questionEdtext.getText().toString().length() < 10) {
                    Toast.makeText(this, "输入文字不得小于10个", Toast.LENGTH_SHORT).show();
                } else if (quetionEdAge.getText().toString().length() > 3 || quetionEdAge.getText().toString().length() < 1) {
                    Toast.makeText(this, "年龄输入有误", Toast.LENGTH_SHORT).show();
                } else {

                    inter.getInfo("app_xuey", sharedPreferences.getString("userid", ""), getMessage().substring(0, 10), sex + "", getMessage(), getAge());
                    Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
        }
    }

    @Override
    public void getQinfo() {

    }

    @Override
    public String getMessage() {
        return questionEdtext.getText().toString().trim();
    }

    @Override
    public String getAge() {
        return quetionEdAge.getText().toString().trim();
    }
}
