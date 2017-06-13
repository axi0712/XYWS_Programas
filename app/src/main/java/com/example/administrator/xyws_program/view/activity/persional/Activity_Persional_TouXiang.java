package com.example.administrator.xyws_program.view.activity.persional;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.base.BaseActivity;

import java.io.File;

public class Activity_Persional_TouXiang extends BaseActivity {
    private Button btn_paizhao, btn_xiangce, btn_quxiao;
    private File file;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    @Override
    protected int getLayout() {
        return R.layout.activity_persional_touxiang;
    }

    @Override
    protected void init() {
        mShared = getSharedPreferences("login",MODE_PRIVATE);
        mEditor = mShared.edit();
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/head.jpg");
        btn_paizhao = (Button) findViewById(R.id.Touxiang_paizhao);
        btn_xiangce = (Button) findViewById(R.id.Touxiang_xiangce);
        btn_quxiao = (Button) findViewById(R.id.Touxiang_quxiao);


    }

    @Override
    protected void initListener() {
        //拍照
        btn_paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1888);

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
                finish();
            }
        });

    }

    @Override
    protected void loadData() {

    }
    private  void getCaiJian(Uri uri) {
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

        if (requestCode == 1888 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

        }

        if(requestCode==200){
            getCaiJian(data.getData());
            Uri uri = data.getData();
            mEditor.putString("uri", uri.toString());
        }else if(requestCode==300){
            Bitmap bitmap = BitmapFactory.decodeFile(file.toString());
        }


    }

}