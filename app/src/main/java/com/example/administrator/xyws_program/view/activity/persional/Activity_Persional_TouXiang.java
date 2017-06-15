package com.example.administrator.xyws_program.view.activity.persional;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.example.administrator.xyws_program.MyApp;
import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;
import com.example.administrator.xyws_program.presenter.persional.Activity_Persional_TouXiang_Presenter_Imple;
import com.example.administrator.xyws_program.presenter.persional.inter.Activity_Persional_TouXiang_Presenter_Inter;
import com.example.administrator.xyws_program.view.activity.persional.inter.Activity_Persional_TouXiang_Inter;

import java.io.File;
import java.io.OutputStream;
import java.util.Calendar;

public class Activity_Persional_TouXiang extends BaseActivity implements Activity_Persional_TouXiang_Inter {
    private Button btn_paizhao, btn_xiangce, btn_quxiao;
    private File file;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    private Activity_Persional_TouXiang_Presenter_Inter inter;
    private Uri uri;
    private String imageurl = "http://mpic.tiankong.com/ca3/1bb/ca31bb5f8b075c17c7a419606ccafe57/640.jpg@360h";
    private OutputStream outputStream;
    private File file1;

    @Override
    protected int getLayout() {
        return R.layout.activity_persional_touxiang;
    }

    @Override
    protected void init() {
        inter = new Activity_Persional_TouXiang_Presenter_Imple(this);
        mShared = getSharedPreferences("login", MODE_PRIVATE);
        mEditor = mShared.edit();
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/head.jpg");
        btn_paizhao = (Button) findViewById(R.id.Touxiang_paizhao);
        btn_xiangce = (Button) findViewById(R.id.Touxiang_xiangce);
        btn_quxiao = (Button) findViewById(R.id.Touxiang_quxiao);
//        Bitmap bitmap = BitmapFactory.decodeFile(imageurl);
//        File file2  =  new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"haha");
//        if(!file2.exists()){
//            file2.mkdirs();
//        }
//        file1 = new File(file2,"123.jpg");
//        try {
//            outputStream = new FileOutputStream(file1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);

    }

    @Override
    protected void initListener() {
        //拍照
        btn_paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//action is capture
                File tempFile = new File("/sdcard/" + Calendar.getInstance().getTimeInMillis() + ".jpg");
                // 以时间秒为文件名
                File temp = new File("/sdcard/");//自已项目 文件夹
                if (!temp.exists()) {
                    temp.mkdir();
                }
                uri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                MyApp.activity.startActivityForResult(intent, 3);

            }
        });


        //进入相册选取
        btn_xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,200);
            }
        });


        //取消
        btn_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

    }

    @Override
    protected void loadData() {

    }

    private void getCaiJian(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("output", Uri.fromFile(file));
        startActivityForResult(intent, 300);
    }

    //获取拍照后回来的值
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//&& resultCode == RESULT_OK
        if (requestCode == 1888 ) {
            getCaiJian(uri);

        }else if (requestCode == 300) {
            inter.camer("", file, "file");
            finish();
        }

        if (requestCode == 200) {
            getCaiJian(data.getData());
//            Uri uri = data.getData();
//            mEditor.putString("toutou", uri.toString());
        } else if (requestCode == 300) {
//            String path = "";
//            Bitmap bitmap = null;
//            Uri uri = data.getData();
//            String[] progection = {MediaStore.Images.Media.DATA};
//            Cursor cursor = MyApp.activity.managedQuery(uri, progection, null,
//                    null, null);
//            if (cursor.moveToFirst()) {
//                int index = cursor.getColumnIndexOrThrow(progection[0]);
//                path = cursor.getString(index);
//                Log.i("TAG111", path + "=========1111111111===========");
//                // 内存压缩 图片的二次采样( 第一次解析路径 先不真正的解析图片只是获取图片宽和高
//                // 根据图片的宽和高和当前手机屏幕的宽和高设置当前图片的压缩比列 ,第三步真正解析图片并显示 )
//            }
//
////        File file = new File(path);
////
////
////
////                 bitmap = BitmapFactory.decodeFile(path);
////        Log.i("TAG111", "图片高="+bitmap.getHeight() +">>>图片宽》》》" +bitmap.getWidth());
////        ;
//
//            Message message = new Message();
//            Bundle bundle = new Bundle();
//            bundle.putString("image_path", path);
//            message.setData(bundle);
//            message.what = 1;
//            handler.sendMessage(message);
            //fasong
            inter.photo("", file,"file");
            finish();

        }


    }

    @Override
    public void loadImage(File file) {

    }

    @Override
    public void upLoadImage(String msg, String name) {

    }

    @Override
    public void dialog() {

    }

    @Override
    public void getPerson() {

    }
}