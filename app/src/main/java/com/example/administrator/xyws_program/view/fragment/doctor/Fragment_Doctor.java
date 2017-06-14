package com.example.administrator.xyws_program.view.fragment.doctor;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.bumptech.glide.Glide;
import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseFragment;
import com.example.administrator.xyws_program.model.bean.doctor.HotDoctor_Bean;
import com.example.administrator.xyws_program.presenter.doctor.GetHotDoctors;
import com.example.administrator.xyws_program.presenter.doctor.HotDoctor;
import com.example.administrator.xyws_program.util.MyRunable;
import com.example.administrator.xyws_program.view.activity.Doctor_GuanJianCiActivity;
import com.example.administrator.xyws_program.view.activity.MainActivity;
import com.example.administrator.xyws_program.view.activity.doctor.Doactor_SelectActivity;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_DetailsActivity;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_NameActivity;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_ProvinceActivity;
import com.example.administrator.xyws_program.view.activity.doctor.Doctor_QuestionActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import retrofit2.Call;

import static android.R.attr.level;
import static com.baidu.location.g.j.I;
import static com.example.administrator.xyws_program.R.drawable.phone;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 16:01
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


public class Fragment_Doctor extends BaseFragment implements Fragment_Doctor_Inter {


    @BindView(R.id.doctor_title)
    TextView doctorTitle;
    @BindView(R.id.doctor_img)
    ImageView doctorImg;
    @BindView(R.id.doctor_province)
    TextView doctorProvince;
    @BindView(R.id.fengexian1)
    TextView fengexian1;
    @BindView(R.id.doctor_mydoctor)
    TextView doctorMydoctor;
    @BindView(R.id.fengexian2)
    TextView fengexian2;
    @BindView(R.id.doctor_grade)
    TextView doctorGrade;
    @BindView(R.id.fengexian3)
    TextView fengexian3;
    @BindView(R.id.doctor_guanjianci)
    TextView doctorGuanjianci;
    @BindView(R.id.fengexian4)
    TextView fengexian4;
    @BindView(R.id.doctor_checkbox)
    CheckBox doctorCheckbox;
    @BindView(R.id.doctor_select)
    Button doctorSelect;
    @BindView(R.id.fengexian5)
    TextView fengexian5;
    @BindView(R.id.doctor_question)
    Button doctorQuestion;
    @BindView(R.id.doctor_phone)
    Button doctorPhone;
    @BindView(R.id.doctor_linear)
    LinearLayout doctorLinear;
    @BindView(R.id.fengexian6)
    TextView fengexian6;
    @BindView(R.id.doctor_trade)
    TextView doctorTrade;
    @BindView(R.id.doctor_relative2)
    RelativeLayout doctorRelative2;
    @BindView(R.id.doctor_img1)
    ImageView doctorImg1;
    @BindView(R.id.doctor_tv1)
    TextView doctorTv1;
    @BindView(R.id.doctor_img2)
    ImageView doctorImg2;
    @BindView(R.id.doctor_tv2)
    TextView doctorTv2;
    @BindView(R.id.doctor_img3)
    ImageView doctorImg3;
    @BindView(R.id.doctor_tv3)
    TextView doctorTv3;
    @BindView(R.id.doctor_img4)
    ImageView doctorImg4;
    @BindView(R.id.doctor_tv4)
    TextView doctorTv4;
    Unbinder unbinder;
    //判断是否是第一次进入
    private Boolean isFirst = false;
    private SharedPreferences sharedPreferences;
    private HotDoctor hotDoctor;
    private HotDoctor_Bean.DataBean dataBean;
    private HotDoctor_Bean.DataBean dataBean1;
    private HotDoctor_Bean.DataBean dataBean2;
    private HotDoctor_Bean.DataBean dataBean3;
    private SharedPreferences.Editor editor;
    private int count = 1;

    //传过去的集合
    private ArrayList<String> mlist = new ArrayList<>();
    private String province;
    //定位功能的初始化
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private String province1;


    @Override
    protected int layoutId() {
        return R.layout.fragment_doctor;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        mLocationClient = new LocationClient(getContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);

        sharedPreferences = getContext().getSharedPreferences("", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        hotDoctor = new GetHotDoctors(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void updateTitleBar() {

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.VISIBLE);
            ((MainActivity) MyApp.activity).getMainTouText().setText("医生在线");
            ((MainActivity) MyApp.activity).getDoctorBtn().setChecked(true);


        } else {
            ((MainActivity) MyApp.activity).getMainTouLinea().setVisibility(View.GONE);
            ((MainActivity) MyApp.activity).getDoctorBtn().setChecked(false);

        }
    }


    @Override
    public void onResume() {
        super.onResume();
        hotDoctor.getHotDoctor(count + "", "4");

        if (isFirst) {
            sharedPreferences = getContext().getSharedPreferences("province", Context.MODE_PRIVATE);
            String province = sharedPreferences.getString("province", "");
            if (province == "") {
                doctorProvince.setText("省份");

            }
            doctorProvince.setText(province);
        } else {
            isFirst = !isFirst;

        }
    }

    @Override
    public void getBtn() {

    }

    @Override
    public String userId() {
        return null;
    }

    @Override
    public void getInfo(List<HotDoctor_Bean.DataBean> list) {
        //第一个
        dataBean = list.get(0);
        String name = dataBean.getName();
        final String app_image = dataBean.getApp_image();
        doctorTv1.setText(name);
        Glide.with(getContext()).load(app_image).into(doctorImg1);
        //第二个
        dataBean1 = list.get(1);
        String name1 = dataBean1.getName();
        final String app_image1 = dataBean1.getApp_image();
        doctorTv2.setText(name1);
        Glide.with(getContext()).load(app_image1).into(doctorImg2);
        //第三个
        dataBean2 = list.get(2);
        String name2 = dataBean2.getName();
        final String app_image2 = dataBean2.getApp_image();
        doctorTv3.setText(name2);
        Glide.with(getContext()).load(app_image2).into(doctorImg3);
        //第四个
        dataBean3 = list.get(3);
        String name3 = dataBean3.getName();
        final String app_image3 = dataBean3.getApp_image();
        doctorTv4.setText(name3);
        Glide.with(getContext()).load(app_image3).into(doctorImg4);

    }


    @OnClick({R.id.doctor_img, R.id.doctor_province, R.id.doctor_mydoctor, R.id.doctor_grade, R.id.doctor_guanjianci, R.id.doctor_select, R.id.doctor_question, R.id.doctor_phone, R.id.doctor_trade, R.id.doctor_img1, R.id.doctor_img2, R.id.doctor_img3, R.id.doctor_img4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //定位
            case R.id.doctor_img:
                Toast.makeText(getContext(), "开始定位", Toast.LENGTH_SHORT).show();

                initLocation();
                mLocationClient.start();

                Log.i("province1", province1 + "");

                break;
            //省份
            case R.id.doctor_province:
                Intent intent = new Intent(Fragment_Doctor.this.getContext(), Doctor_ProvinceActivity.class);
                startActivity(intent);
                break;
            //医生
            case R.id.doctor_mydoctor:
                mlist.clear();
                mlist.add("不限");
                mlist.add("主任医师");
                mlist.add("副主任医师");
                mlist.add("主任医生");
                mlist.add("医师");

                Intent intent1 = new Intent(getContext(), Doctor_NameActivity.class);
                intent1.putStringArrayListExtra("list", mlist);
                startActivityForResult(intent1, 100);

                break;
            //医院等级
            case R.id.doctor_grade:
                mlist.clear();
                mlist.add("不限");
                mlist.add("三级甲等");
                mlist.add("三级乙等");
                mlist.add("三级丙等");
                mlist.add("三级");
                mlist.add("二级甲等");
                mlist.add("二级乙等");
                mlist.add("二级丙等");

                Intent intentg = new Intent(getContext(), Doctor_NameActivity.class);
                intentg.putStringArrayListExtra("list", mlist);
                startActivityForResult(intentg, 100);


                break;
            //关键词
            case R.id.doctor_guanjianci:
                Intent intentguan = new Intent(getContext(), Doctor_GuanJianCiActivity.class);
                startActivityForResult(intentguan, 100);

                break;
            //查询
            case R.id.doctor_select:
                Intent intents = new Intent(getContext(), Doactor_SelectActivity.class);
                //省份
                intents.putExtra("province", doctorProvince.getText().toString() + "");
                //医生
                intents.putExtra("title", doctorMydoctor.getText().toString());
                //关键词
                intents.putExtra("keyword", doctorGuanjianci.getText().toString());
                //参数 illid
                intents.putExtra("illid", "高血压");
                //参数IsPlus
                intents.putExtra("IsPlus", "0");
                //参数level
                intents.putExtra("level", "");
                startActivity(intents);


                break;
            //免费问医生
            case R.id.doctor_question:
                sharedPreferences = getContext().getSharedPreferences("login", getContext().MODE_PRIVATE);

                if (sharedPreferences.getString("userid", "") != "") {
                    Intent intentq = new Intent(getContext(), Doctor_QuestionActivity.class);
                    startActivity(intentq);
                } else {
                    Toast.makeText(getContext(), "请先登录", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.doctor_phone:
                showDialog();

                break;
            //换一换
            case R.id.doctor_trade:
                count++;
                hotDoctor.getHotDoctor(count + "", "4");

                break;

            case R.id.doctor_img1:

                String expert_id = dataBean.getExpert_id();

                editor.putString("expertid", expert_id);
                editor.commit();


                Intent intent2 = new Intent(getContext(), Doctor_DetailsActivity.class);
                //头像
                String app_image = dataBean.getApp_image();
                //名字
                String name = dataBean.getName();
                //什么医生
                String title = dataBean.getTitle();
                //学历
                String teach = dataBean.getTeach();
                //医院
                String hospital = dataBean.getHospital();
                //医科
                String depart = dataBean.getDepart();
                //内容
                String goodat = dataBean.getGoodat();
                String menzhen = dataBean.getMenzhen();
                intent2.putExtra("menzhen", menzhen);

                intent2.putExtra("app_image", app_image);
                intent2.putExtra("name", name);
                intent2.putExtra("title", title);
                intent2.putExtra("teach", teach);
                intent2.putExtra("hospital", hospital);
                intent2.putExtra("depart", depart);
                intent2.putExtra("goodat", goodat);

                startActivity(intent2);

                break;
            case R.id.doctor_img2:
                String expert_id1 = dataBean1.getExpert_id();
                editor.putString("expertid", expert_id1);
                Log.i("kankanid", dataBean1.getExpert_id());
                editor.commit();

                Intent intent3 = new Intent(getContext(), Doctor_DetailsActivity.class);
                //头像
                String app_image3 = dataBean1.getApp_image();
                //名字
                String name3 = dataBean1.getName();
                //什么医生
                String title3 = dataBean1.getTitle();
                //学历
                String teach3 = dataBean1.getTeach();
                //医院
                String hospital3 = dataBean1.getHospital();
                //医科
                String depart3 = dataBean1.getDepart();
                //内容
                String goodat3 = dataBean1.getGoodat();

                String menzhen3 = dataBean1.getMenzhen();
                intent3.putExtra("menzhen", menzhen3);
                intent3.putExtra("app_image", app_image3);
                intent3.putExtra("name", name3);
                intent3.putExtra("title", title3);
                intent3.putExtra("teach", teach3);
                intent3.putExtra("hospital", hospital3);
                intent3.putExtra("depart", depart3);
                intent3.putExtra("goodat", goodat3);

                startActivity(intent3);

                break;
            case R.id.doctor_img3:
                String expert_id2 = dataBean2.getExpert_id();
                editor.putString("expertid", expert_id2);
                editor.commit();
                Intent intent4 = new Intent(getContext(), Doctor_DetailsActivity.class);
                //头像
                String app_image4 = dataBean2.getApp_image();
                //名字
                String name4 = dataBean2.getName();
                //什么医生
                String title4 = dataBean2.getTitle();
                //学历
                String teach4 = dataBean2.getTeach();
                //医院
                String hospital4 = dataBean2.getHospital();
                //医科
                String depart4 = dataBean2.getDepart();
                //内容
                String goodat4 = dataBean2.getGoodat();

                String menzhen4 = dataBean2.getMenzhen();
                intent4.putExtra("menzhen", menzhen4);

                intent4.putExtra("app_image", app_image4);
                intent4.putExtra("name", name4);
                intent4.putExtra("title", title4);
                intent4.putExtra("teach", teach4);
                intent4.putExtra("hospital", hospital4);
                intent4.putExtra("depart", depart4);
                intent4.putExtra("goodat", goodat4);

                startActivity(intent4);

                break;
            case R.id.doctor_img4:
                String expert_id3 = dataBean3.getExpert_id();
                editor.putString("expertid", expert_id3);
                editor.commit();

                Intent intent5 = new Intent(getContext(), Doctor_DetailsActivity.class);


                //头像
                String app_image5 = dataBean3.getApp_image();
                //名字
                String name5 = dataBean3.getName();
                //什么医生
                String title5 = dataBean3.getTitle();
                //学历
                String teach5 = dataBean3.getTeach();
                //医院
                String hospital5 = dataBean3.getHospital();
                //医科
                String depart5 = dataBean3.getDepart();
                //内容
                String goodat5 = dataBean3.getGoodat();

                String menzhen5 = dataBean3.getMenzhen();
                intent5.putExtra("app_image", app_image5);
                intent5.putExtra("name", name5);
                intent5.putExtra("title", title5);
                intent5.putExtra("teach", teach5);
                intent5.putExtra("hospital", hospital5);
                intent5.putExtra("depart", depart5);
                intent5.putExtra("goodat", goodat5);
                intent5.putExtra("menzhen", menzhen5);


                startActivity(intent5);

                break;
        }
    }


    //拨打寻医问药的电话，6.0以上需要动态获取权限
    private final int REQUEST_CODE = 0x1001;

    private void showDialog() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("温馨提示");
        alertDialog.setMessage("是否拨打寻医问药的健康电话:400-9700-120");
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (Build.VERSION.SDK_INT >= 23) {

                    //判断有没有拨打电话权限
                    if (PermissionChecker.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        //请求拨打电话权限
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);

                    } else {
                        callPhone("400977120");
                    }

                } else {
                    callPhone("400977120");
                }
            }
        });
        alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog1 = alertDialog.create();
        alertDialog1.show();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE && PermissionChecker.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getContext(), "权限获取成功", Toast.LENGTH_SHORT).show();
            callPhone("400977120");
        }
    }


    private void callPhone(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNumber);
        intent.setData(data);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                switch (resultCode) {
                    case 200:
                        String name = data.getStringExtra("name");
                        doctorMydoctor.setText(name);

                        break;
                    case 300:
                        String name1 = data.getStringExtra("name");
                        doctorGrade.setText(name1);

                        break;

                    case 400:
                        String gjc = data.getStringExtra("gjc");
                        doctorGuanjianci.setText(gjc);
                        break;

                }
                break;
        }
    }

    private void initLocation() {


        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span = 0;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }


    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation location) {

            //获取定位结果
            StringBuffer sb = new StringBuffer(256);

            sb.append("time : ");
            sb.append(location.getTime());    //获取定位时间

            sb.append("\nerror code : ");
            sb.append(location.getLocType());    //获取类型类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息

            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息

            sb.append("\nradius : ");
            sb.append(location.getRadius());    //获取定位精准度

            if (location.getLocType() == BDLocation.TypeGpsLocation) {

                // GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());    // 单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());    //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());    //获取海拔高度信息，单位米

                sb.append("\ndirection : ");
                sb.append(location.getDirection());    //获取方向信息，单位度

                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息


                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");

            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息

            List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }

            Log.i("BaiduLocationApiDem", sb.toString());
            province1 = location.getProvince();
            MyRunable.mainthread(new Runnable() {
                @Override
                public void run() {
                    doctorProvince.setText(location.getProvince() + "");
                }
            });


            Log.i("定位省份", province1);
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

}
