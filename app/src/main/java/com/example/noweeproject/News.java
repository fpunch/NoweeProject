package com.example.noweeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class News extends AppCompatActivity {

    private Button statusButton, chatButton, homeButton;
    public String friends;
    public String news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        statusButton = (Button) findViewById(R.id.statusBtn);
        homeButton = (Button) findViewById(R.id.homeBtn);

        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // statusGo();
                startActivity(new Intent(News.this, Status.class));
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what to put???

            }
        });

        }





}
