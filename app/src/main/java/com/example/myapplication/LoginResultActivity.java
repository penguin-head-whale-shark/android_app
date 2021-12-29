
package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;


public class LoginResultActivity extends AppCompatActivity {
    Fragment fragment1;
    Fragment fragment2;
    DrawerLayout menu;
    NavigationView nav;
    TextView TextView_get;
    int index =0,count=7;
    Toast sToast = null;

    LinearLayout sc;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment();
        fragment2 = new Fragment();
        menu = findViewById(R.id.menu);
        nav = findViewById(R.id.navigation);
        sc = findViewById(R.id.linearLayout2);
        linearLayout = findViewById(R.id.linearLayout);

        Intent b = getIntent();
        Button add = new Button(this);
        String text = b.getStringExtra("제목");
        add.setHint(text);
        add.setWidth(sc.getWidth());
        add.setHeight(48);
        add.setId('1');
        if(b.getExtras()!=null) {
            Log.d("로그","서주영");

            sc.addView(add);
        }
        int check = b.getIntExtra("삭제",0);
        if(check == 1){
            linearLayout.removeViewAt(0);
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShowActivity.class);
                i.putExtras(b.getExtras());

                startActivity(i);
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("건의 사항"));
        tabs.addTab(tabs.newTab().setText("공지 사항"));
        ScrollView scroll1 = findViewById(R.id.scrollView1);
        ScrollView scroll2 = findViewById(R.id.scrollView2);
        ImageView burger = findViewById(R.id.burger_button);
        TextView cnt = findViewById(R.id.cnt_index);
        ImageView left = findViewById(R.id.back_button);
        ImageView right = findViewById(R.id.next_button);
        cnt.setText((index + 1) + " / " + (count));
        TextView ps_wrt = findViewById(R.id.show_pass_write);
        TextView logout = findViewById(R.id.logout_button);

        ps_wrt.setOnClickListener(new View.OnClickListener() {//채택된 건의사항
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowWriteActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener((new View.OnClickListener() {//로그아웃
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }));

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.openDrawer(nav,true);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index = index - 1;
                    cnt.setText((index + 1) + " / " + (count));
                } else {
                    if (sToast == null) {
                        sToast = Toast.makeText(getApplicationContext(), "첫 번째 인덱스입니다.", Toast.LENGTH_SHORT);
                    } else {
                        sToast.setText("첫 번째 인덱스입니다.");
                    }
                    sToast.show();
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index + 1 < count) {
                    index += 1;
                    cnt.setText((index + 1) + " / " + (count));
                } else {
                    if (sToast == null) {
                        sToast = Toast.makeText(getApplicationContext(), "마지막 인덱스입니다.", Toast.LENGTH_SHORT);//토스트 메시지 중복 제거
                    } else {
                        sToast.setText("마지막 인덱스입니다.");
                    }
                    sToast.show();
                }
            }
        });
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("LoginResultActivity", "선택 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                    scroll1.setVisibility(View.VISIBLE);
                    scroll2.setVisibility(View.INVISIBLE);
                } else if (position == 1) {
                    selected = fragment2;
                    scroll1.setVisibility(View.INVISIBLE);
                    scroll2.setVisibility(View.VISIBLE);
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        LinearLayout wrt = findViewById(R.id.write_button);
        wrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener((new View.OnClickListener() {//로그아웃
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }));
    }
}