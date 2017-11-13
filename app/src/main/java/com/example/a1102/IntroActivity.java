package com.example.a1102;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.a1102.member.MemberLogin;

/**
 * Created by Jeff_Hwang on 2017. 11. 13..
 */

public class IntroActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        Thread thread = new Thread();

        thread.start();
        try {
            thread.sleep(3000);

            System.out.println("@@@@@@@@@@@@@@@@@@");

        }catch (Exception e){
            e.printStackTrace();
        }
        Intent intent = new Intent(getApplicationContext(), MemberLogin.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }

}
