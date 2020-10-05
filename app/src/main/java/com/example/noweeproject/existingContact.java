package com.example.noweeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class existingContact extends AppCompatActivity {

    TextView UsernameField = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_contact);


    }
    public void btnExist_Contact_onClick(View view) {
        Intent intent = new Intent (ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        EditText mUsername = (EditText) findViewById(R.id.usernameField);



        }
    }