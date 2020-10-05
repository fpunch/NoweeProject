package com.example.noweeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class newContact extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

    }

    //Add Contact Method
    public void btnAdd_Contact_onClick(View view) {
        Intent intent = new Intent (ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        // Gather Details of Contact
        EditText mFirstName = (EditText) findViewById(R.id.editFirstName);
        EditText mLastName = (EditText) findViewById(R.id.editSurname);
        EditText mEmail = (EditText) findViewById(R.id.editEmail);
        EditText mPhoneNumber = (EditText) findViewById(R.id.editPhone);

        //Insert an email address
        intent
                .putExtra(ContactsContract.Intents.Insert.EMAIL, mEmail.getText())
                .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.PHONE, mPhoneNumber.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.NAME, mFirstName.getText() + " " + mLastName.getText())
                ;

        startActivity(intent);

    }
}