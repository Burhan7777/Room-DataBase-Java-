package com.example.room.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.room.database.MyDatabase;
import com.example.room.R;
import com.example.room.viewmodels.DeleteContactViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeleteActivity extends AppCompatActivity {
    MyDatabase database;
    EditText editText;
    DeleteContactViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        viewModel = new ViewModelProvider(this).get(DeleteContactViewModel.class);
        database = MyDatabase.getInstance(getApplicationContext());
        editText = findViewById(R.id.deleteName);
    }

    public void deleteDB(View view) {
        viewModel.deleteContact(editText.getText().toString());

    }
}