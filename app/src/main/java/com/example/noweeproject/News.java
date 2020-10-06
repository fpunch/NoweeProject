package com.example.noweeproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class News extends AppCompatActivity {
    RecyclerView recyclerView;
 //   private FirebaseFirestore db = FirebaseFirestore.getInstance();


    private Button statusButton, chatButton, homeButton;
    public String friends;
    public String news;

    private NewAdapter adapter;
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
                //what to put????

            }
        });

        }

    private void setUpRecyclerView(){
        }





}
