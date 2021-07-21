package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.chip.Chip;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Classroom_res_class2 extends AppCompatActivity {

    private TextView classroom_name;//강의실 이름
    private TextView text0;
    private TextView text1;
    private TextView text2;
    private TextView text3;

    private  String str1 = "1";
    private  String str2 = "1";
    private  String str3 = "1";
    private  String str4 = "1";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classroom_res_class0);




        text0 = findViewById(R.id.classroom_res_class0_txt1);
        text1 = findViewById(R.id.classroom_res_class0_txt2);
        text2 = findViewById(R.id.classroom_res_class0_txt3);
        text3 = findViewById(R.id.classroom_res_class0_txt4);

        SharedPreferences sharedPreferences1 = getSharedPreferences(str1,0);
        String value = sharedPreferences1.getString("2_0", "0/4");
        text0.setText(value);
        SharedPreferences sharedPreferences2 = getSharedPreferences(str2,0);
        String value2 = sharedPreferences2.getString("2_1","0/4");
        text1.setText(value2);
        SharedPreferences sharedPreferences3 = getSharedPreferences(str3,0);
        String value3 = sharedPreferences3.getString("2_2","0/4");
        text2.setText(value3);
        SharedPreferences sharedPreferences4 = getSharedPreferences(str4,0);
        String value4 = sharedPreferences4.getString("2_3","0/4");
        text3.setText(value4);
        //저장

        classroom_name = findViewById(R.id.classroom_name);
        Intent intent = getIntent();
        String name = intent.getStringExtra("classroom_name");
        classroom_name.setText(name);
        //강의실 이름 가져와 붙여넣기


        Chip classroom_res_class0_chip1 = (Chip) findViewById(R.id.time1);
        classroom_res_class0_chip1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Classroom_res_class0_table1.class);

                startActivityForResult(intent, 0);
            }
        });

        Chip classroom_res_class0_chip2 = (Chip) findViewById(R.id.time2);
        classroom_res_class0_chip2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Classroom_res_class0_table2.class);
                startActivityForResult(intent, 1);
            }
        });

        Chip classroom_res_class0_chip3 = (Chip) findViewById(R.id.time3);
        classroom_res_class0_chip3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Classroom_res_class0_table3.class);

                startActivityForResult(intent, 2);
            }
        });

        Chip classroom_res_class0_chip4 = (Chip) findViewById(R.id.time4);
        classroom_res_class0_chip4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Classroom_res_class0_table4.class);
                startActivityForResult(intent, 3);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){//classtable에서 보내는 intent받기
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 0) {
            String str = data.getStringExtra("cnt1");
            str = str + "/4";
            text0.setText(str);
        }

        if(resultCode == RESULT_OK && requestCode == 1) {
            String str = data.getStringExtra("cnt2");
            str = str + "/4";
            text1.setText(str);
        }

        if(resultCode == RESULT_OK && requestCode == 2) {
            String str = data.getStringExtra("cnt3");
            str = str + "/4";
            text2.setText(str);
        }

        if(resultCode == RESULT_OK && requestCode == 3) {
            String str = data.getStringExtra("cnt4");
            str = str + "/4";
            text3.setText(str);
        }

    }


    //종료시 저장장
    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences1 = getSharedPreferences(str1,0);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        String value1 = text0.getText().toString();
        editor1.putString("2_0",value1);
        editor1.commit();

        SharedPreferences sharedPreferences2 = getSharedPreferences(str2,0);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        String value2 = text1.getText().toString();
        editor2.putString("2_1",value2);
        editor2.commit();

        SharedPreferences sharedPreferences3 = getSharedPreferences(str2,0);
        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
        String value3 = text2.getText().toString();
        editor3.putString("2_2",value3);
        editor3.commit();

        SharedPreferences sharedPreferences4 = getSharedPreferences(str3,0);
        SharedPreferences.Editor editor4 = sharedPreferences4.edit();
        String value4 = text3.getText().toString();
        editor4.putString("2_3",value4);
        editor4.commit();

    }
}