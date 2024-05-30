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

public class set_questionsActivity extends AppCompatActivity {
    Button button_back;
    Button save;
    EditText zag;
    EditText name;
    EditText op_zad;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_questions);

        mDatabase = FirebaseDatabase.getInstance().getReference("info");
    }

    public void save_que(View v) {
        zag = findViewById(R.id.zagolovok);
        name = findViewById(R.id.imya);
        op_zad = findViewById(R.id.opisanie_zadachi);

        String zag_ok = zag.getText().toString();
        String dlya = name.getText().toString();
        String content = op_zad.getText().toString();
        int i = 0;
        if(zag_ok != "" && dlya != ""&& content != ""){
            mDatabase.child("zagolovok").setValue(zag_ok);
            mDatabase.child("dlya_kogo").setValue(dlya);
            mDatabase.child("content").setValue(content);
            mDatabase.child("id_que").setValue(i);
            i++;
        }
        else{
            Toast.makeText(getApplicationContext(), "Check question", Toast.LENGTH_LONG).show();
            return;
        }
    }
    public void Save(View v) {
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save_que(v);
            }
        });
    }


    public void Back(View v) {
        button_back = findViewById(R.id.back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(set_questionsActivity.this, WorkActivity.class);
                startActivity(intent);
            }
        });
    }

}