package com.example.my_progect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText email_edittxt;
    EditText password_edittxt;
    Button button_entrance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void chek_email(View v){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference passwords = database.getReference("users").child("password");
        DatabaseReference email = database.getReference("users").child("email");

        final String[] userLogin = {null};
        final String[] userPassword = {null};

        email.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "You have problem with internet.", Toast.LENGTH_LONG).show();
                }
                else {
                    userLogin[0] =  String.valueOf(task.getResult().getValue());
                }
            }
        });
        passwords.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "You have problem with internet.", Toast.LENGTH_LONG).show();
                }
                else {
                    userPassword[0] =  String.valueOf(task.getResult().getValue());
                }
            }
        });

        email_edittxt = findViewById(R.id.email);
        password_edittxt = findViewById(R.id.password);
        button_entrance = findViewById(R.id.button_entrance);
        button_entrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userLogin[0] == null){
                    Toast.makeText(getApplicationContext(), "Try again later.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(userPassword[0] == null){
                    Toast.makeText(getApplicationContext(), "Try again later.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (email_edittxt.getText().toString().equals(userLogin[0]) && password_edittxt.getText().toString().equals(userPassword[0])){
                    Intent intent = new Intent(MainActivity.this, WorkActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}