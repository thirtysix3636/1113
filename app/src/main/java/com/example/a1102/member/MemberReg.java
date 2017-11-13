package com.example.a1102.member;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a1102.R;
import com.example.a1102.dbhelper.DBHelper;

/* 회원가입 폼 액티비티 정의 부분 */
public class MemberReg extends AppCompatActivity implements View.OnClickListener{

    DBHelper dbHelper;


    RadioGroup gender_group; //성별 라디오그룹
    RadioButton rbtn_man, rbtn_woman, rbtn_etc; //라디오 버튼 남자, 여자, 기타
    EditText name_edit, nick_name_edit, id_edit, pwd_edit, pwd_edit_check; // 이름, 닉네임, 아이디, 비밀번호, 비밀번호체크
    Button id_check_btn, reg_btn, back_btn; // 중복확인, 회원가입, 뒤로가기 버튼

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_reg);

        /* 버튼 등록 */
        id_check_btn = (Button)findViewById(R.id.member_id_check);
        reg_btn = (Button)findViewById(R.id.member_reg_btn);
        back_btn = (Button)findViewById(R.id.member_reg_back);

        /* Edit Text 설정 */
        name_edit = (EditText)findViewById(R.id.member_reg_name); // 이름 폼
        nick_name_edit = (EditText)findViewById(R.id.member_nickname_reg); // 닉네임 폼
        id_edit = (EditText)findViewById(R.id.member_id_reg); // 아이디 폼
        pwd_edit = (EditText)findViewById(R.id.member_pwd_reg); // 비밀번호 폼
        pwd_edit_check = (EditText)findViewById(R.id.member_pwd_confirm_reg); //비밀번호 체크 폼


        /* 성별 그룹 */
        gender_group = (RadioGroup)findViewById(R.id.gender_group);

        /* 성별 버튼 */
        rbtn_man = (RadioButton)findViewById(R.id.radio_btn_man);
        rbtn_woman = (RadioButton)findViewById(R.id.radio_btn_woman);
        rbtn_etc = (RadioButton)findViewById(R.id.radio_btn_etc);


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
