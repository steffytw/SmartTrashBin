package com.example.steffythankam.smarttrashbin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class binstatus extends AppCompatActivity {
    private static final String TAG ="binstatus";


    FirebaseDatabase database;
    DatabaseReference myRef;
    ProgressBar pgbar1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = FirebaseDatabase.getInstance();
        myRef  = database.getReference("smarttrashbin-b190a").child("Distance");
        String val = myRef.toString();
        System.out.println(val);
        Log.d(TAG, "Value is: " + val);
        pgbar1=findViewById(R.id.progressBar2);
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binstatus);
        show_bin_status();
    }
    public void show_bin_status() {
        myRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                String value = dataSnapshot.getValue(String.class);

                //String val = ;
                //Log.d(TAG, "Value is: " + value);
                //pgbar1.setProgress(Integer.parseInt(value));
            }


            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
}
