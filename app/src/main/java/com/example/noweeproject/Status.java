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
    private String message = null;
    static final int SEND_MESSAGE = 3; // STATUS VALUE
    static final int SMS_PERMISSION_REQ = 123; // PERMISSIONS VALUE

    //STATUS page(profile picture, message, send your message
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



     /*
//Lab3???
        msgBtn = (Button) findViewById(R.id.sendMsgButton);
        msgText = (EditText) findViewById(R.id.smstext);
        //Get data from intent
        Intent intent = getIntent();
        contact = intent.getStringExtra("contact_num");

        //Button listener
        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        private void sendMessage(){
            message = msgText.getText().toString();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {
                Log.d("MAD", " SMS Permission is not granted, requesting");
                ActivityCompat.requestPermissions(this, new
                        String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_REQ);
            } else {
                Log.d("MAD", "SMS Permission is given");
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(contact, null,message, null, null);
                Toast.makeText(Status.this, "Message Sent", Toast.LENGTH_LONG).show();
            }
        }*/
    }



}
