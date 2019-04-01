package com.example.steffythankam.smarttrashbin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         database = FirebaseDatabase.getInstance();
         myRef  = database.getReference("odour");
         FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odourlevel);
    }
    public void show_odour_level(View view) {
        myRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }


            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
