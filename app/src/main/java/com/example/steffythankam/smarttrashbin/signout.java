package com.example.steffythankam.smarttrashbin;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
 /*
public class signout extends AppCompatActivity {

    private Button signout;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private static final String TAG ="signout";

   @Nullable
    @Override
    public View  onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity2, container, false);
        signout = (Button) view.findViewById(R.id.button4);
        setupFirebaseListener();
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: attempting to signout the user");
                FirebaseAuth.getInstance().signOut();
            }

        });
        return view;
    }
    private void setupFirebaseListener(){
        Log.d(TAG,"setupFirebaseListener: setting up the auth state Listener....");
        mAuthStateListener=new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthstateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.d(TAG,"onAuthStateChanged: signedin: "+user.getUid());
                }
                else{
                    Log.d(TAG,"onAuthStateChanged: signedout");
                    Toast.makeText(getActivity(),"signed out",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(),LoginAcyivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };
    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthStateListener);
        }
    }


}
*/