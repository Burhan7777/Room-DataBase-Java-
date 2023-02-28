package com.example.room.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;


import com.example.room.database.ContactEntity;
import com.example.room.database.MyDatabase;
import com.example.room.R;
import com.example.room.databinding.ActivityMain2Binding;
import com.example.room.viewmodels.InsertContactViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InsertDataActivity extends AppCompatActivity {

    ActivityMain2Binding binding;
    MyDatabase database;
    ContactEntity contactEntity;
    InsertContactViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        viewModel = new ViewModelProvider(this).get(InsertContactViewModel.class);
        database = MyDatabase.getInstance(getApplicationContext());
        contactEntity = new ContactEntity();

    }

    // ===== Method to enter data starts ===== //


    public void insertData(View view) throws InterruptedException {

        // Getting text from ediTexts and adding them to the database //
        String name = binding.editName.getText().toString();
        String email = binding.editEmail.getText().toString();
        String placeOfBirth = binding.editPlace.getText().toString();
        String gender = binding.editGender.getText().toString();
        contactEntity = new ContactEntity(name, email, placeOfBirth, gender);
        viewModel.addContact(contactEntity);

        //  Emptying editTexts after user clicks the button and inserts data in database //
        binding.editName.setText("");
        binding.editEmail.setText("");
        binding.editGender.setText("");
        binding.editPlace.setText("");
    }

    // ===== Method to enter data ends ====== //


}







