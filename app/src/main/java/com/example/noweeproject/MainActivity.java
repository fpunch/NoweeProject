package com.example.noweeproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private String TAG = "loginActivity";
    private FirebaseAuth auth;
    private Button logoutButton, deleteButton, statusButton, chatButton, newsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        checkIfLoggedIn();

        logoutButton = (Button) findViewById(R.id.logoutBtn);
        deleteButton = (Button) findViewById(R.id.deleteBtn);
        statusButton = (Button) findViewById(R.id.statusBtn);
        chatButton = (Button) findViewById(R.id.chatBtn);
        newsButton = (Button) findViewById(R.id.newsBtn);

        //Status Intent
        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // statusGoes();
                startActivity(new Intent(MainActivity.this, Status.class));
            }
        });
        //Nowee News Intent
        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, News.class));
            }
        });

        //Contact Picker Intent
        chatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //   Contact Picker
                    startActivity(new Intent(MainActivity.this, ContactActivity.class));
                }
        });
    }

    private void checkIfLoggedIn() {
        if (auth.getCurrentUser() != null) {
            Log.d(TAG, "User logged in : " + auth.getCurrentUser().getDisplayName());
        } else {
            Log.d(TAG, "No user logged in");
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }
    }

    private void deleteAccount() {
        AuthUI.getInstance()
                .delete(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        logout();
                    }
                });
    }

    private void logout() {
        AuthUI.getInstance()
                .signOut(MainActivity.this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        // user is now signed out
                        startActivity(new Intent(MainActivity.this, Login.class));
                        finish();
                    }
                });
    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.logoutBtn:
                logout();
                return true;

            case R.id.deleteBtn:
                deleteAccount();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}