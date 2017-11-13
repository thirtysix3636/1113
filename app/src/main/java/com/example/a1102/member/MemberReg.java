package com.example.a1102.member;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a1102.R;

/**
 * Created by Jeff_Hwang on 2017. 11. 13..
 */

public class MemberReg extends AppCompatActivity implements View.OnClickListener{
    RadioGroup gender_group; //성별 라디오그룹
    RadioButton rbtn_man, rbtn_woman, rbtn_etc; //라디오 버튼 남자, 여자, 기타
    EditText name_edit,id_edit, pwd_edit, pwd_edit_check; // 이름, 아이디, 비밀번호, 비밀번호체크
    Button id_check_btn, reg_btn, back_btn; // 중복확인, 회원가입, 뒤로가기 버튼

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_reg);

        /* 버튼 등록 */
        id_check_btn = (Button)findViewById(R.id.member_id_check);
        reg_btn = (Button)findViewById(R.id.member_reg_btn);
        back_btn = (Button)findViewById(R.id.member_reg_back);


        /* 버튼 원클릭 리스너 세팅 */
        id_check_btn.setOnClickListener(this);
        reg_btn.setOnClickListener(this);
        back_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /* 중복확인 버튼 */
            case R.id.member_id_check:

                break;
            /* 회원가입 버튼 */
            case R.id.member_reg_btn:

                break;
            /* 뒤로가기 버튼 */
            case R.id.member_reg_back:

                break;
        }
    }
}
