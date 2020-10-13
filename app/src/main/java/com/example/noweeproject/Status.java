package com.example.noweeproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Status extends AppCompatActivity {

    private Button msgBtn = null;
    private EditText msgText = null;

    private String contact = null;
    private String currentStatus;
    private Button newsButton;
    private Button chatButton;


    static final int SEND_MESSAGE = 3; // STATUS VALUE
    static final int SMS_PERMISSION_REQ = 123; // PERMISSIONS VALUE

    //STATUS page(profile picture, message, send your messages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_list);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        newsButton = (Button) findViewById(R.id.newsBtn2);
        chatButton = (Button) findViewById(R.id.chatBtn);

        //Contact Picker Intent
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Status.this, ContactActivity.class));
            }
        });

        //Nowee News Intent
        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Status.this, News.class));
            }
        });
    }

    public Status() {

    }
    public Status(String currentStatus) {
        currentStatus = currentStatus;
        this.currentStatus = currentStatus;
    }

    public String getStatus(){return currentStatus;}

    public void setStatus(String currentStatus){ currentStatus = currentStatus;}

}
