package com.example.noweeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class existingContact extends AppCompatActivity {

    Button AddButton = null;
    TextView UsernameField = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_contact);

        //Initialise UI Objects
        AddButton = (Button) findViewById(R.id.AddButton);
        UsernameField = (TextView) findViewById(R.id.Username);

/*
        //Listener for Add Button -> send activity
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent myIntent = new Intent(existingContact.this, SendActivity.class);
                myIntent.putExtra();
                existingContact.this.startActivity(myIntent);
            }
        });*/
    }



}