package com.example.my_progect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Chek_questionsActivity extends AppCompatActivity {
    TextView zag;
    TextView dlya_k;
    TextView cont;
    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chek_questions);
        Check_que();
    }

    public void Check_que(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        zag = (TextView)findViewById(R.id.Zag);
        dlya_k = (TextView)findViewById(R.id.dlya);
        cont = (TextView)findViewById(R.id.content);
        DatabaseReference zag_Db = database.getReference("info").child("zagolovok");
        DatabaseReference dlya_Db = database.getReference("info").child("dlya_kogo");
        DatabaseReference cont_Db = database.getReference("info").child("content");

        final String[] zagg = {null};
        final String[] dl = {null};
        final String[] con = {null};

        zag_Db.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "You have problem with internet.", Toast.LENGTH_LONG).show();
                }
                else {
                    zagg[0] =  String.valueOf(task.getResult().getValue());
                }
            }
        });
        dlya_Db.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "You have problem with internet.", Toast.LENGTH_LONG).show();
                }
                else {
                    dl[0] =  String.valueOf(task.getResult().getValue());
                }
            }
        });
        cont_Db.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "You have problem with internet.", Toast.LENGTH_LONG).show();
                }
                else {
                    con[0] =  String.valueOf(task.getResult().getValue());
                }
            }
        });
        String za = zagg[0];
        zag.setText(za);



    }

}

