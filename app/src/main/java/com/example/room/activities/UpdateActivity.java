package com.example.room.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.room.R;
import com.example.room.database.ContactEntity;
import com.example.room.database.MyDatabase;
import com.example.room.databinding.ActivityUpdateBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UpdateActivity extends AppCompatActivity {

    ActivityUpdateBinding binding;
    MyDatabase database;
    List<ContactEntity> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update);
        database = MyDatabase.getInstance(this);
    }

    // ====== Getting data method starts ====== //


    public void getDataFromDB(View view) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("updateDB3", "get data");
            //    list.add(database.getDAO().getContact(binding.updateName.getText().toString()));
                binding.updateEmail.setText(list.get(0).getEmail());
                binding.updatePlace.setText(list.get(0).getPlaceOfBirth());
                binding.updateGender.setText(list.get(0).getGender());
                list.remove(0);
            }
        });


    }

    // ====== Getting data method ends ===== //



    // ====== Update Methods started ===== //


    public void updateDB(View view) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("updateDB", "email update");
                String name = binding.updateName.getText().toString();
                String email = binding.updateEmail.getText().toString();
                database.getDAO().updateByName(email, name);
            }
        });

    }

    public void updateDBGender(View view) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("updateDB1", "gender update");

                String name = binding.updateName.getText().toString();
                String gender = binding.updateGender.getText().toString();
                database.getDAO().updateByName1(gender, name);
            }
        });

    }

    public void updateDBPlace(View view) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("updateDB2", "place update");
                String name = binding.updateName.getText().toString();
                String place = binding.updatePlace.getText().toString();
                database.getDAO().updateByName2(place, name);
            }
        });

    }

    // ===== Update Methods ended ====== //


}