package com.example.administrator.xyws_program.view.fragment.blood.childactivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.model.db.updatabloodpressure;
import com.example.administrator.xyws_program.presenter.Blood.Blood_datarecord_imple;
import com.example.administrator.xyws_program.util.hgetdb;
import com.example.administrator.xyws_program.util.hgetuid;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_Info;
import com.example.administrator.xyws_program.view.activity.persional.Activity_Persional_View_Login;
import com.example.administrator.xyws_program.view.fragment.blood.childactivity.Inter.Datarecord_Inter;
import com.example.administrator.xyws_program.view.zidingyiview.WheelView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DatarecordActivity extends BaseActivity implements Datarecord_Inter{

    @BindView(R.id.datarecore_toolbar_backimg)
    ImageView datarecoreToolbarBackimg;
    @BindView(R.id.datarecore_toolbar)
    Toolbar datarecoreToolbar;
    @BindView(R.id.datarecore_rlin1)
    RelativeLayout datarecoreRlin1;
    @BindView(R.id.datarecore_rlin2)
    RelativeLayout datarecoreRlin2;
    @BindView(R.id.datarecore_tv)
    TextView datarecoreTv;
    @BindView(R.id.datarecore_equipment)
    EditText datarecoreEquipment;
    @BindView(R.id.datarecore_rlin3)
    RelativeLayout datarecoreRlin3;
    @BindView(R.id.datarecore_tv2)
    TextView datarecoreTv2;
    @BindView(R.id.datarecore_high)
    EditText datarecoreHigh;
    @BindView(R.id.datarecore_rlin4)
    RelativeLayout datarecoreRlin4;
    @BindView(R.id.datarecore_tv3)
    TextView datarecoreTv3;
    @BindView(R.id.datarecore_low)
    EditText datarecoreLow;
    @BindView(R.id.datarecore_rlin5)
    RelativeLayout datarecoreRlin5;
    @BindView(R.id.datarecore_bt)
    Button datarecoreBt;
    @BindView(R.id.datarecore_rlin6)
    RelativeLayout datarecoreRlin6;
    @BindView(R.id.activity_datarecord)
    ScrollView activityDatarecord;
    private static final ArrayList<String> YEARS=new ArrayList();
    private static final ArrayList<String> MONTH=new ArrayList();
    private static final ArrayList<String> DAY=new ArrayList();
    private static final ArrayList<String> HOUR=new ArrayList();
    private static final ArrayList<String> MINES=new ArrayList();
    private TextView datarecoreday;
    private TextView datarecoreminnes;
    private String resultyear=1998+"";
    private String resultmonth=7+"";
    private String resultday=17+"";
    private String resulthour=10+"";
    private String resultmines=30+"";
    private int MAXDAY;
    private Blood_datarecord_imple blood_datarecord_imple;

    @Override
    protected int getLayout() {
        return R.layout.activity_datarecord;
    }

    @Override
    protected void init() {
        datarecoreday = (TextView) findViewById(R.id.datarecoreday);
        datarecoreminnes = (TextView) findViewById(R.id.datarecoreminnes);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        for(int i=0;i<120;i++){
            YEARS.add(1917+i+"");
        }
        for(int i=0;i<12;i++){
            MONTH.add(1+i+"");
        }
        for(int i=0;i<31;i++){
            DAY.add(1+i+"");
        }
        for(int i=0;i<24;i++){
            if(i<9){
                HOUR.add("0"+(1+i));
            }else{
                HOUR.add(1+i+"");
            }

        }
        for(int i=-1;i<59;i++){
            if(i<9){
                MINES.add("0"+(1+i));
            }else{
                MINES.add(1+i+"");
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.datarecore_toolbar_backimg, R.id.datarecore_rlin1, R.id.datarecore_rlin2, R.id.datarecore_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.datarecore_toolbar_backimg:
                finish();
                break;
            case R.id.datarecore_rlin1:
                //时间滚轴年月日、提示框
                showyeardialog();
                break;
            case R.id.datarecore_rlin2:
                //时间滚轴小时、分钟、提示框
                showminnes();
                break;
            case R.id.datarecore_bt:
                String time=datarecoreday.getText().toString().trim();
                String hour=datarecoreminnes.getText().toString().trim();
                String equipment=datarecoreEquipment.getText().toString().trim();
                String hignpressure=datarecoreHigh.getText().toString().trim();
                String lowpressure=datarecoreLow.getText().toString().trim();
                if(!time.equals("")&&!hour.equals("")){
                    if(!equipment.equals("")){
                        if(!hignpressure.equals("")&&!lowpressure.equals("")){
                            int high=Integer.parseInt(hignpressure);
                            int low=Integer.parseInt(lowpressure);
                            if(high>30&&high<200&&low>30&&low<200){
                                if(high>=low){
                                      if(!hgetuid.getid().equals("")){
                                    blood_datarecord_imple = new Blood_datarecord_imple(this);
                                    blood_datarecord_imple.updatadb(this,time,hour,equipment,hignpressure,lowpressure);
                                    finish();
                                }else {
                                    Toast.makeText(DatarecordActivity.this,"请先登录！",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(DatarecordActivity.this,Activity_Persional_View_Login.class);
                                    startActivity(intent);
                                }
                                }else {
                                    Toast.makeText(DatarecordActivity.this,"高压值必须大于低压值！",Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(DatarecordActivity.this,"血压范围30-200",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(DatarecordActivity.this,"血压值不能为空！",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(DatarecordActivity.this,"设备名不能为空！",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(DatarecordActivity.this,"请选择一下时间！",Toast.LENGTH_SHORT).show();
                }


                break;
        }
    }

    private void showminnes() {
        // 构建弹出框View
        View outerView = LayoutInflater.from(DatarecordActivity.this)
                .inflate(R.layout.updatamineswheel_view, null);

        WheelView hour = (WheelView) outerView
                .findViewById(R.id.updatwheel_hour);
        WheelView mines = (WheelView) outerView
                .findViewById(R.id.updatwheel_mines);

        hour.setOffset(2);
        mines.setOffset(2);

        hour.setItems(HOUR);// 实际内容
        mines.setItems(MINES);


        hour.setSeletion(9);// 设置默认被选中的项目
        mines.setSeletion(29);

        //滑动监听
        hour.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                resulthour = item;
            }
        });
        mines.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                resultmines=item;
            }
        });
        // 展示弹出框
        new AlertDialog.Builder(DatarecordActivity.this)
                .setTitle("设置时间").setView(outerView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datarecoreminnes.setText(resulthour+":"+resultmines);
                    }
                })
                .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private void showyeardialog() {
        // 构建弹出框View
        View outerView = LayoutInflater.from(DatarecordActivity.this)
                .inflate(R.layout.updatawheel_view, null);

        WheelView year = (WheelView) outerView
                .findViewById(R.id.updatwheel_year);
        WheelView month = (WheelView) outerView
                .findViewById(R.id.updatwheel_month);
        WheelView day = (WheelView) outerView
                .findViewById(R.id.updatwheel_day);

        year.setOffset(2);
        month.setOffset(2);
        day.setOffset(2);
        year.setItems(YEARS);// 实际内容
        month.setItems(MONTH);
        day.setItems(DAY);

        year.setSeletion(81);// 设置默认被选中的项目
        month.setSeletion(6);
        day.setSeletion(16);

        //滑动监听
        year.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                resultyear = item;
            }
        });
        month.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                resultmonth=item;
            }
        });
        day.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                resultday=item;
            }
        });

        // 展示弹出框
        new AlertDialog.Builder(DatarecordActivity.this)
                .setTitle("设置时间").setView(outerView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datarecoreday.setText(resultyear+"-"+resultmonth+"-"+resultday);

                    }
                })
                .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }


    @Override
    public void getdata() {

        setContentView(R.layout.activity_datarecord);
    }
}
