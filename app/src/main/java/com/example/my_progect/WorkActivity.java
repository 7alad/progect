package com.example.my_progect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkActivity extends AppCompatActivity {
    Button button_exit;
    Button stq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
    }
    public void exit_onclick(){
        button_exit = findViewById(R.id.exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(WorkActivity.this,MainActivity.class);
                    startActivity(intent);
            }
        });
    }
    public void set_questions(){
        stq = findViewById(R.id.stq);
        stq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkActivity.this,set_questionsActivity.class);
                startActivity(intent);
            }
        });
    }
}