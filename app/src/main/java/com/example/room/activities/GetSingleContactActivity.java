package com.example.room.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.room.database.ContactEntity;
import com.example.room.database.MyDatabase;
import com.example.room.R;
import com.example.room.databinding.ActivityMain4Binding;
import com.example.room.viewmodels.GetContactDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

public class GetSingleContactActivity extends AppCompatActivity {

    ActivityMain4Binding binding;
    MyDatabase database;
    List<ContactEntity> list = new ArrayList<>();
    GetContactDetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main4);
        database = MyDatabase.getInstance(getApplicationContext());
        viewModel = new ViewModelProvider(this).get(GetContactDetailsViewModel.class);
        Observer<ContactEntity> observer = new Observer<ContactEntity>() {
            @Override
            public void onChanged(ContactEntity contactEntity) {
                list.add(contactEntity);
            }
        };
        viewModel.getDetails(binding.editEnterName.getText().toString()).observe(this, observer);
    }

    public void getData(View view) {
        binding.showName.setText(list.get(0).getName());
        binding.showEmail.setText(list.get(0).getEmail());
        binding.showPlace.setText(list.get(0).getPlaceOfBirth());
        binding.showGender.setText(list.get(0).getGender());

        list.remove(0);

        // Or you can use for loop to get the same result, as shown below //


     /*   list.add(database.getContactDAO().getContact(binding.editEnterName.getText().toString()));
        for (int i = 0; i < list.size(); i++) {
            list.add(database.getContactDAO().getContact(binding.editEnterName.getText().toString()));
            binding.showName.setText(list.get(0).getName());
            binding.showEmail.setText(list.get(0).getEmail());
            binding.showPlace.setText(list.get(0).getPlaceOfBirth());
            binding.showGender.setText(list.get(0).getGender());  */
    }

}
