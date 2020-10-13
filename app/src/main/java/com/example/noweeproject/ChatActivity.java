package com.example.noweeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {
    static final int PICK_CONTACT = 1;
    private static final String TAG = ChatActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private String contact_number = null;
    TextView numView = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        checkForSmsPermission();
        Intent intent = getIntent();
        contact_number = intent.getStringExtra("contact_num");
        numView= findViewById(R.id.editText_main);
        Button selectButton =  findViewById(R.id.selectContactBtn);

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK
                        , ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT && resultCode == RESULT_OK) {

            Uri contactUri = data.getData();
            Cursor cursor = getContentResolver().query(contactUri, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                contact_number = cursor.getString(numberIndex);
                Log.d("TEST", contact_number);
                numView.setText(contact_number);
                cursor.close();
            }
        }
    }

    private void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, getString(R.string.permission_not_granted));

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {

            enableSmsButton();
        }
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase(Manifest.permission.SEND_SMS)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted. Enable sms button.
                    enableSmsButton();
                } else {
                    // Permission denied.
                    Log.d(TAG, getString(R.string.failure_permission));
                    Toast.makeText(this, getString(R.string.failure_permission),
                            Toast.LENGTH_LONG).show();
                    // Disable the sms button.
                    disableSmsButton();
                }
            }
        }
    }


    public void smsSendMessage(View view) {


        EditText smsEditText = (EditText) findViewById(R.id.sms_message);

        String smsMessage = smsEditText.getText().toString();

        String scAddress = null;

        PendingIntent sentIntent = null, deliveryIntent = null;

        checkForSmsPermission();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(contact_number, scAddress, smsMessage,
                sentIntent, deliveryIntent);
        Toast.makeText(this, "message sent!", Toast.LENGTH_SHORT).show();
    }


    private void disableSmsButton() {
        Toast.makeText(this, R.string.sms_disabled, Toast.LENGTH_LONG).show();

        Button smsButton = (Button) findViewById(R.id.message_icon);
        smsButton.setVisibility(View.INVISIBLE);
        Button retryButton = (Button) findViewById(R.id.button_retry);
        retryButton.setVisibility(View.VISIBLE);
    }

    private void enableSmsButton() {
        Button smsButton = (Button) findViewById(R.id.message_icon);
        smsButton.setVisibility(View.VISIBLE);
    }
    public void retryApp(View view) {
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        startActivity(intent);
    }
}