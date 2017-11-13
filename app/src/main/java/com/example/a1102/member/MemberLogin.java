package com.example.a1102.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1102.R;

/**
 * Created by Jeff_Hwang on 2017. 11. 13..
 */

/* 로그인 Activiy 설정 */
public class MemberLogin extends AppCompatActivity implements View.OnClickListener{
    EditText id_edit, pwd_edit; // 아이디, 패스워드 폼
    Button login_btn, back_btn; // 로그인, 뒤로가기 버튼


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_login);

        /* editText 세팅*/
        id_edit = (EditText)findViewById(R.id.member_id_login); //아이디 입력
        pwd_edit = (EditText)findViewById(R.id.member_pwd_login); //비밀번호 입력

        /* 버튼 세팅*/
        login_btn = (Button)findViewById(R.id.member_login_btn);
        back_btn = (Button)findViewById(R.id.member_login_btn);

        /* 원클릭리스너 세팅 */
        login_btn.setOnClickListener(this);
        back_btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            /* 로그인 버튼 */
            case R.id.member_login_btn:

                break;
            /* 뒤로가기 버튼 */
            case R.id.member_login_back:

                break;
        }
    }
}
