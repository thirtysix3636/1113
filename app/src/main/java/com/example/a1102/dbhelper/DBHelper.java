package com.example.a1102.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jeff_Hwang on 2017. 11. 13..
 */
public class DBHelper extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
    //테이블 생성
        db.execSQL("create table user_inform (" +
                "id char(20) not null primary key," +
                "password char(10) not null," +
                "name char(8) not null," +
                "nickname char(20) not null," +
                "tel char(13) not null," +
                "authentic char(30)," +
                "sex int check(1,2,3)," +
                "star int default 0," +
                "keyword char(20)" +
                ")");

    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String create_at, String item, int price) {
        // 읽고 쓰기가 가능하게 DB 열기
    }

    public void update(String item, int price) {
        //업데이트
    }

    public void delete(String item) {
        //삭제
    }

    public void getResult() {
        // 읽기가 가능하게 DB 열기

    }
}


