package com.example.a1102;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.a1102.dbhelper.DBHelper;
import com.example.a1102.member.MemberLogin;

/**
 * Created by Jeff_Hwang on 2017. 11. 13..
 */

public class IntroActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        DBHelper dbHelper = new DBHelper(getApplicationContext(),"unknown.db",null,1); //


        ImageView imageView = (ImageView)findViewById(R.id.intro_gif);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.heros).into(imageViewTarget);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(), MemberLogin.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();

                next();
            }
        }).start();
    }

    public void next(){

    }

}
