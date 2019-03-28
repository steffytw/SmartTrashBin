package com.example.steffythankam.smarttrashbin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class odourlevel extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         database = FirebaseDatabase.getInstance();
         myRef  = database.getReference("odour");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odourlevel);
    }
    public void show_odour_level(View view) {


    }
}
