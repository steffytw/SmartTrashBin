package com.example.steffythankam.smarttrashbin;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
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


    FirebaseDatabase firebaseDatabase;

    TextView textViewDistance;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binstatus);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);

        FirebaseApp.initializeApp(this);
        firebaseDatabase  = FirebaseDatabase.getInstance();

        textViewDistance = findViewById(R.id.tv_distance);


        dialog.show();
        show_bin_status();
    }
    public void show_bin_status() {
        firebaseDatabase.getReference("message").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                String message = dataSnapshot.getValue().toString();

                //String val = ;
                Log.d(TAG, "Message is ===================================: " + message);
                //textViewMessage.setText("Message : "+message);
                //pgbar1.setProgress(Integer.parseInt(value));
            }
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        firebaseDatabase.getReference("Distance").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                String distance = dataSnapshot.getValue().toString();

                //String val = ;
                Log.d(TAG, "Distance is ===================================: " + distance);
                textViewDistance.setText("Distance : "+distance);
                dialog.dismiss();
                //pgbar1.setProgress(Integer.parseInt(value));
            }
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}