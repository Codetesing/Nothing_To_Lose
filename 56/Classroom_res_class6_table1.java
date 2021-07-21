package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Classroom_res_class6_table1 extends AppCompatActivity {

    private int count;

    private boolean btn_status0 = false;
    private boolean btn_status1 = false;
    private boolean btn_status2 = false;
    private boolean btn_status3 = false;
    // 버튼 상태
    private String on0 = "false";
    private String on1 = "false";
    private String on2 = "false";
    private String on3 = "false";
    // SharedPreference 키
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    //버튼


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classroom_res_class0_table0);


        btn0 = (Button) findViewById(R.id.room0_0_btn0);
        btn1 = (Button) findViewById(R.id.room0_0_btn1);
        btn2 = (Button) findViewById(R.id.room0_0_btn2);
        btn3 = (Button) findViewById(R.id.room0_0_btn3);
        //버튼 layout 연결
        SharedPreferences sharedPreferences0_1_0 = getSharedPreferences(on0, 0);
        boolean value0 = sharedPreferences0_1_0.getBoolean("ison?0_1_0", false);
        btn_status0 = value0;
        isOn(btn0, btn_status0);
//        //버튼 0값 불러오기
        SharedPreferences sharedPreferences0_1_1 = getSharedPreferences(on1, 0);
        boolean value1 = sharedPreferences0_1_1.getBoolean("ison?0_1_1", false);
        btn_status1 = value1;
        isOn(btn1, btn_status1);
        //버튼 1값 불러오기
        SharedPreferences sharedPreferences0_1_2 = getSharedPreferences(on2, 0);
        boolean value2 = sharedPreferences0_1_2.getBoolean("ison0_1_2?", false);
        btn_status2 = value2;
        isOn(btn2, btn_status2);
        //버튼 2값 불러오기
        SharedPreferences sharedPreferences0_1_3 = getSharedPreferences(on3, 0);
        boolean value3 = sharedPreferences0_1_3.getBoolean("ison?0_1_3", false);
        btn_status3 = value3;
        isOn(btn3, btn_status3);
        //버튼 3값 불러오기


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btn_key = 0;
                if(!already_Registed(btn_key))
                    showDialog(btn0, btn_key);
                hmanyRegisted();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btn_key = 1;
                if(!already_Registed(btn_key))
                    showDialog(btn1, btn_key);
                hmanyRegisted();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btn_key = 2;
                if(!already_Registed(btn_key))
                    showDialog(btn2, btn_key);
                hmanyRegisted();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btn_key = 3;
                if(!already_Registed(btn_key))
                    showDialog(btn3, btn_key);
                hmanyRegisted();
            }
        });

    }

    void showDialog(Button btn, int btn_key) {
        AlertDialog.Builder msg = new AlertDialog.Builder(Classroom_res_class6_table1.this)
                .setMessage("자리 사용 등록 하시겠습니까?")
                .setPositiveButton(Html.fromHtml("<font color='#0'>아니요</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Classroom_res_class6_table1.this, "자리 사용 등록이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(Html.fromHtml("<font color='#0'>예</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 등록 완료 팝업.
                        Toast.makeText(Classroom_res_class6_table1.this, "자리 사용 등록이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        btn.setBackgroundColor(Color.RED);
                        switch (btn_key) {
                            case 0:
                                btn_status0 = true;
                                break;
                            //false true
                            case 1:
                                btn_status1 = true;
                                break;
                            case 2:
                                btn_status2 = true;
                                break;
                            case 3:
                                btn_status3 = true;
                                break;
                        }// 버튼 key값에 따라 상태 저장
                    }
                });
        AlertDialog msgDlg = msg.create();
        msgDlg.show();
    }

    void hmanyRegisted()
    {
        count = 1;
        if(btn_status0 == true)
            count++;
        if(btn_status1 == true)
            count++;
        if(btn_status2 == true)
            count++;
        if(btn_status3 == true)
            count++;
        String sendText = String.valueOf(count);
        Intent intent = new Intent();
        intent.putExtra("cnt1",sendText); // 바꿔야함
        setResult(RESULT_OK,intent);

    }
    Boolean already_Registed(int btn_key) {
        switch (btn_key) {
            case 0:
                if (btn_status0 == true) {
                    Toast.makeText(Classroom_res_class6_table1.this, "이미 신청된 자리입니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }
                break;
            //false true
            case 1:
                if (btn_status1 == true) {
                    Toast.makeText(Classroom_res_class6_table1.this, "이미 신청된 자리입니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }
                break;
            case 2:
                if (btn_status2 == true) {
                    Toast.makeText(Classroom_res_class6_table1.this, "이미 신청된 자리입니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }
                break;
            case 3:
                if (btn_status3 == true) {
                    Toast.makeText(Classroom_res_class6_table1.this, "이미 신청된 자리입니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }
                break;

        }
        return false;
    }
    //이미 신청된 강의인지?


    void isOn(Button btn, Boolean btn_status)
    {
        if(btn_status)
        {
            btn.setBackgroundColor(Color.RED);
        }
        else
        {
            btn.setBackgroundColor(Color.WHITE);
        }
    }//key 값이 true이면 빨간색 false이면 회색

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences0_1_0 = getSharedPreferences(on0, 0);
        SharedPreferences.Editor editor0 = sharedPreferences0_1_0.edit();
        Boolean ison0 = btn_status0;
        editor0.putBoolean("ison?0_1_0",ison0);
        editor0.commit();

        SharedPreferences sharedPreferences0_1_1 = getSharedPreferences(on1, 0);
        SharedPreferences.Editor editor1 = sharedPreferences0_1_1.edit();
        Boolean ison1 = btn_status1;
        editor1.putBoolean("ison?0_1_1",ison1);
        editor1.commit();

        SharedPreferences sharedPreferences0_1_2 = getSharedPreferences(on2, 0);
        SharedPreferences.Editor editor2 = sharedPreferences0_1_2.edit();
        Boolean ison2 = btn_status2;
        editor2.putBoolean("ison0_1_2?",ison2);
        editor2.commit();

        SharedPreferences sharedPreferences0_1_3 = getSharedPreferences(on3, 0);
        SharedPreferences.Editor editor3 = sharedPreferences0_1_3.edit();
        Boolean ison3 = btn_status3;
        editor3.putBoolean("ison?0_1_3",ison3);
        editor3.commit();

        //버튼 boolean 정보 저장
    }
}
