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


public class odourlevel extends AppCompatActivity {
    private static final String TAG ="odourlevel";


    FirebaseDatabase firebaseDatabase;

    TextView textViewOdour;


    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odourlevel);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);

        FirebaseApp.initializeApp(this);
        firebaseDatabase  = FirebaseDatabase.getInstance();
        textViewOdour = findViewById(R.id.tv_odour);


        dialog.show();
        show_odour_level();
    }
    public void show_odour_level() {
        firebaseDatabase.getReference("odour").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                String odour = dataSnapshot.getValue().toString();

                //String val = ;
                Log.d(TAG, "Odour is ===================================: " + odour);
                textViewOdour.setText("Odour : "+odour);
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