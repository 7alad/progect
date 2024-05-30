package com.example.my_progect;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_UserActivity extends AppCompatActivity {
    Button create_u;
    Button back;
    EditText post;
    EditText name;
    EditText email_us;
    EditText password;
    int last_id;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        mDatabase = FirebaseDatabase.getInstance().getReference("users");
    }

    public void Create_useR(View v) {
        post = findViewById(R.id.dolzhnost);
        name = findViewById(R.id.imya);
        email_us = findViewById(R.id.email_us);
        password = findViewById(R.id.password_us);
        last_id = 1;

        String email_user = email_us.getText().toString();
        String name_us = name.getText().toString();
        String post_us = post.getText().toString();
        String pass_us = password.getText().toString();

        if(email_user != "" && name_us != ""&& post_us != "" && pass_us != ""){
            mDatabase.child("email").setValue(email_user);
            mDatabase.child("name").setValue(name_us);
            mDatabase.child("post").setValue(post_us);
            mDatabase.child("password").setValue(pass_us);
            mDatabase.child("id_us").setValue(last_id);
            last_id++;
        }
        else{
            Toast.makeText(getApplicationContext(), "Check info", Toast.LENGTH_LONG).show();
            return;
        }

        }
    public void Create_User(View v){

        create_u = findViewById(R.id.create_us);
        create_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Create_useR(v);
            }



        });
    }
    public void Back_us(View v){
        back = findViewById(R.id.back_us);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create_UserActivity.this,WorkActivity.class);
                startActivity(intent);
            }
        });
    }

}