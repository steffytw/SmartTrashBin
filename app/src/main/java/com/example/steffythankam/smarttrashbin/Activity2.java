package com.example.steffythankam.smarttrashbin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    Button odorbtn;
    Button binbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        odorbtn = (Button) findViewById(R.id.button2);

        odorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(getApplicationContext(), odourlevel.class);
                startActivity(intent2);

            }
        });

            binbtn = (Button) findViewById(R.id.button3);

           binbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent3 = new Intent(getApplicationContext(), binstatus.class);
                    startActivity(intent3);

                }
            });
    }






}
