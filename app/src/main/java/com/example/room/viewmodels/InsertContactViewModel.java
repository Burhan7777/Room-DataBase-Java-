package com.example.room.viewmodels;

import android.app.Application;

import com.example.room.database.Apprepository;
import com.example.room.database.ContactEntity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class InsertContactViewModel extends AndroidViewModel {
    Apprepository repository;

    public InsertContactViewModel(@NonNull Application application) {
        super(application);
        repository = new Apprepository(application);
    }

    public void addContact(ContactEntity contactEntity) {
        repository.insertContact(contactEntity);
    }
}
