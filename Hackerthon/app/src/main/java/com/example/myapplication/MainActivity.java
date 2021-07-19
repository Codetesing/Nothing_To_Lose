package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 강의실 예약 버튼 클릭 -> classroom_res activity 전환
        Button classroom_res_btn = (Button) findViewById(R.id.classroom_res_btn);
        classroom_res_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), classroom_res.class);

                startActivity(intent);
            }
        });

        // 튜터 수업 버튼 클릭 -> tutor_class activity 전환
        Button tutor_class_btn = (Button) findViewById(R.id.tutor_class_btn);
        tutor_class_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tutor_class.class);

                startActivity(intent);
            }
        });

    }
}