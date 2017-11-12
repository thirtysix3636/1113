package com.example.a1102;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DrawerLayout drawerLayout1;

    Button list_btn, home_btn;

    SQLiteDatabase userDb; // 데이터 베이스 생성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 셋팅
        list_btn = (Button)findViewById(R.id.list_menu_btn);
        home_btn = (Button)findViewById(R.id.home_btn);
        list_btn.setOnClickListener(this);
        home_btn.setOnClickListener(this);

        openDatabase("userdb"); // 데이터베이스 생성
        createTable("usereb");

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.action_search:
                        intent = new Intent(getApplicationContext(),SearchActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                        break;

                    case R.id.action_chat:
                        intent = new Intent(getApplicationContext(),ChatActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                        break;

                    case R.id.action_keyword:
                        intent = new Intent(getApplicationContext(),AlertActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                        break;

                    case R.id.action_write:
                        intent = new Intent(getApplicationContext(),WriteActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.action_myinfo:
                        intent = new Intent(getApplicationContext(),MyInfo.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                }
                return false;
            }
        });


    }

    @Override
    public void onClick(View view) {
     switch (view.getId())
     {
         case R.id.list_menu_btn:
             DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.left_Drawer);
             NavigationView drawerView = (NavigationView) findViewById(R.id.drawer_view);
             drawerLayout.openDrawer(drawerView);
             break;
         case R.id.home_btn:
             Intent intent = new Intent(getApplicationContext(),MainActivity.class);
             startActivity(intent);
             overridePendingTransition(0,0);
             finish();
             break;
     }
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                        menuitem.setChecked(true);

                        return true;
                    }

                }
        );
    }

    // 데이터베이스 오픈
    public void openDatabase(String dataBase){
        userDb = openOrCreateDatabase(dataBase, MODE_PRIVATE, null);

        // 데이터베이스 연결 확인용
        if(userDb != null){

        }else{
            //db 오픈 실패
            Toast.makeText(getApplicationContext(),"개인 정보를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void createTable(String tableName){
        tableName = "userdb1";
        try {
            if (userDb != null) {
                String sql = "create table "+ tableName +
                        "(_id integer primary key autoincrement,"+
                        "nameId text not null default 'admin',"+
                        "subject text not null," +
                        "price int," +
                        "image1 text not null default '1234'," +
                        "image2 text," +
                        "image3 text," +
                        "category text," +
                        "description text" +
                        "address text not null," +
                        "variation text," +
                        "statue text," +
                        "deal text)";
                userDb.execSQL(sql);

            } else {
                Toast.makeText(getApplicationContext(),"개인 정보를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

