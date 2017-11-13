package com.example.a1102;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a1102.helper.PhotoHelper;
/**
 * Created by hwang on 2017. 11. 11..
 */

public class PhotoTestActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imageView;
    Button button;
    String photoPath = null; // 촬영 결과물이 저장될 경로
    Bitmap bmp = null; // 메모리로 로드한 이미지가 저장될 객체

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_test);
        permissionCheck();
        permissionCheck1();
        permissionCheck2();
        imageView = (ImageView) findViewById(R.id.imageView_test);

        button = (Button) findViewById(R.id.btn_test);
        button.setOnClickListener(this);


    }

    public void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA}, 100);
            }
        }
    }

    public void permissionCheck1() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
            }
        }
    }
    public void permissionCheck2() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 102);
            }
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_test:

                //저장될 사진 파일경로
                // --> /mnt/sdcard/DCIM/p2016-04-28 23-52-00.jpg
                photoPath = PhotoHelper.getInstance().getNewPhotoPath();

                //카메라 App 호출을 위한 암묵적 Intent
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //저장될 경로를 파라미터로 설정 --> URI
                try {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse("file://"+ photoPath));
                    intent.putExtra(AUDIO_SERVICE, false);
                    //카메라 호출 --> 저장 결과를 받기 위한 설정
                    startActivityForResult(intent, 100);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100){
            if(resultCode == Activity.RESULT_OK){
                //촬영 결과물을 갤러리에 등록한다.
                Intent photoIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        Uri.parse("file://"+photoPath));
                sendBroadcast(photoIntent);
                // 기존에 표시되던 이미지 제거
                imageView.setImageBitmap(null);
                //그림이 저장된 객체가 존재한다면, 메모리 해제
                if(bmp!=null){
                    bmp.recycle();
                    bmp = null;
                }
                //썸네일 이미지 얻기
                bmp = PhotoHelper.getInstance().getThumb(this, photoPath);
                //출력
                imageView.setImageBitmap(bmp);
            }
        }
    }
    // bmp 객체는 메모리에 여전히 남아있음 강제로 해제


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(bmp!=null){
            bmp.recycle();
            bmp = null;
        }
    }
}
