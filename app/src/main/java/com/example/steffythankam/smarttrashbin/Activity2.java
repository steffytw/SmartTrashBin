package com.example.steffythankam.smarttrashbin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Activity2 extends AppCompatActivity {


    Button odorbtn;
    Button binbtn;
    Button signout;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        odorbtn = (Button) findViewById(R.id.button2);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("789304606066-ub8pjhq9p7kcf4agjsp04al85iv22fhn.apps.googleusercontent.com")
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();

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
        signout = (Button) findViewById(R.id.button4);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent4 = new Intent(getApplicationContext(), signout.class);
                //startActivity(intent4);
                mAuth.signOut();

//                // Google sign out
//                mGoogleSignInClient.signOut().addOnCompleteListener(this,
//                        new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                               updateui();
//                            }
//                        });
                updateui();

            }
        });


    }

    public void updateui() {


        Toast.makeText(this,"Logout",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SmartTrashBin.class);
        startActivity(intent);


    }




}
