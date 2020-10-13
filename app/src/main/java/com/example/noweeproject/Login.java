package com.example.noweeproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.Arrays;
import java.util.concurrent.Executor;

//import models.User;

public class Login extends AppCompatActivity {

    private static final String TAG = "loginActivity";
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final int RC_SIGN_IN = 123;
    private String append;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        //build AuthUI programatically (nothing needing to be changed in your XML file
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.GoogleBuilder().build(),
                                new AuthUI.IdpConfig.EmailBuilder().build()))
                        .setLogo(R.drawable.logo)
                        .setIsSmartLockEnabled(!BuildConfig.DEBUG /* credentials */, true /* hints */)
                        .build(),
                RC_SIGN_IN);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    Toast.makeText(this, "Sign-in cancelled", Toast.LENGTH_SHORT).show();
                    return;
                }

               if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this, "Sign-in failed, no network", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e(TAG, "Sign-in error: ", response.getError());
            }
        }
    }





    /*WORK IN PROGRESS JESSE M
    private void setupFirebaseAuth() {
                    Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");

                    auth = FirebaseAuth.getInstance();
                    mFirebaseDatabase = FirebaseDatabase.getInstance();
                    myRef = mFirebaseDatabase.getReference();

                    mAuthListener = new FirebaseAuth.AuthStateListener() {

                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            if (user != null) {
                                Log.d(TAG, "onAuthStateChanged:signed_in" + user.getUid());

                                myRef.addListenerForSingleValueEvent((new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        //1st check
                                        if(checkIfUsernameExists(username, dataSnapshot) {

                                        }
                                        //Add new user to database

                                        //add new user account settings to database
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                }));
                            } else {
                                Log.d(TAG, "onAuthStateChanged:signed_out");
                            }
            }
        };
        }
        //WORK IN PROGRESS JESSE
        public boolean checkIfUsernameExists(String username, DataSnapshot dataSnapshot) {
        Log.d(TAG, "checkIfUsernameExists: checking if "  + username +"already exists");

        User user = new User();

        for (DataSnapshot ds: dataSnapshot.getChildren()){
            Log.d(TAG, "checkIfUsernameExists: datasnapshot: " + ds);

            user.setUsername(ds.getValue(User.class).getUsername());
            Log.d(TAG, "checkIfUsernameExists: username: "+ user.getUsername());

            if(user.getUsername().equals(username)) {
                Log.d(TAG, "checkIfUsernameExists: FOUND A MATCH: " + user.getUsername());
            }
        }
        return true;
    }*/

}
