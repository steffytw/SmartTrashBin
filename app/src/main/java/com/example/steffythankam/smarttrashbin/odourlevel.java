package com.example.steffythankam.smarttrashbin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class odourlevel extends AppCompatActivity {
    private static final String TAG ="odourlevel";

    FirebaseDatabase database;
    DatabaseReference myRef;
    ProgressBar pgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        database = FirebaseDatabase.getInstance();
        myRef  = database.getReference("smarttrashbin-b190a").child("odour");
        String val = myRef.toString();
        System.out.println(val);
        Log.d(TAG, "Value is: " + val);
         pgbar=findViewById(R.id.progressBar2);
         FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odourlevel);
        show_odour_level();
    }
    public void show_odour_level() {
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
