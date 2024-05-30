package com.example.my_progect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WorkActivity extends AppCompatActivity {
    Button button_exit;
    Button stq;
    Button chq;
    Button create_u;
    TextView zagol;
    TextView dlya_k;
    TextView content_inf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
    }
    public void exit_onclick(){
        button_exit = findViewById(R.id.back);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(WorkActivity.this,MainActivity.class);
                    startActivity(intent);
            }
        });
    }
    public void set_questions(View v){
        stq = findViewById(R.id.stq);
        stq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkActivity.this,set_questionsActivity.class);
                startActivity(intent);
            }
        });
    }
    public void chek_questions(View v){
        chq = findViewById(R.id.chq);
        chq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkActivity.this,Chek_questionsActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Create_user(View v) {
        create_u = findViewById(R.id.create_user);

        create_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkActivity.this, Create_UserActivity.class);
                startActivity(intent);
            }
        });
    }
}