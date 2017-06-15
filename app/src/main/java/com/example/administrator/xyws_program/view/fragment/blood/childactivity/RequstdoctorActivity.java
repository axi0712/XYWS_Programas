package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.presenter.Blood.Blood_datarecord_imple;
import com.example.administrator.xyws_program.util.hgetuid;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_QuestionActivity;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_View_Login;

public class RequstdoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requstdoctor);
        RelativeLayout layout= (RelativeLayout) findViewById(R.id.requstdoctor);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hgetuid.getid().equals("")){
                    Intent intentq = new Intent(RequstdoctorActivity.this, Doctor_QuestionActivity.class);
                    startActivity(intentq);
                }else {
                    Toast.makeText(RequstdoctorActivity.this,"请先登录！",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RequstdoctorActivity.this,Activity_Persional_View_Login.class);
                    startActivity(intent);
                }
            }
        });

    }
}
