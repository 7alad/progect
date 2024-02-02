package com.example.my_progect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email_edittxt;
    EditText password_edittxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void chek_email(){
        email_edittxt = findViewById(R.id.email);
        password_edittxt = findViewById(R.id.password);
        Button button_entrance = findViewById(R.id.button2);
        button_entrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email_edittxt.getText().toString().equals("salat@mail.ru") && password_edittxt.getText().toString().equals("12345")){
                    Intent intent = new Intent(MainActivity.this,WorkActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
    public void register(){
        Button button_register = findViewById(R.id.button2);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}