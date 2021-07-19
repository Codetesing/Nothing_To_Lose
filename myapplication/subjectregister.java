package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class subjectregister extends AppCompatActivity {
    private int i = 0;
    private TextView n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectregister);

        n = findViewById(R.id.num);
        // 등록 클릭 -> ?? 수를 올려야하나??
        Button subject_btn = (Button) findViewById(R.id.register);
        subject_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                i++;
                n.setText(i+"");
                startActivity(intent);
            }
        });
    }
}
