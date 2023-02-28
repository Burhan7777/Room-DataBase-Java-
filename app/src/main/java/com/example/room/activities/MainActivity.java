package com.example.room.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.room.R;
import com.example.room.activities.InsertDataActivity;
import com.example.room.activities.ShowAllContactsActivity;
import com.example.room.activities.GetSingleContactActivity;
import com.example.room.activities.DeleteActivity;
import com.example.room.activities.UpdateActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // ====== MainActivity leads to multiple activities only ======//
    // ====== MainActivity2 inserts new data in the database ===== //
    // ====== MainActivity3 shows whole database by using Recycler View ===== //
    // ====== MainActivity4 gets a single column from the database ===== //

    Button insert, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.insert);
        view = findViewById(R.id.view);
    }

    public void insertData(View view) {
        Intent intent = new Intent(this, InsertDataActivity.class);
        startActivity(intent);
    }

    public void showData(View view) {
        Intent intent = new Intent(this, ShowAllContactsActivity.class);
        startActivity(intent);
    }

    public void getSingleData(View view) {
        Intent intent = new Intent(this, GetSingleContactActivity.class);
        startActivity(intent);
    }

    public void deleteFromDB(View view) {
        Intent intent = new Intent(this, DeleteActivity.class);
        startActivity(intent);
    }

    public void updateDB(View view) {
        Intent intent = new Intent(this, UpdateActivity.class);
        startActivity(intent);
    }
}