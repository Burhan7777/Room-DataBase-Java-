package com.example.room.viewmodels;

import android.app.Application;
import android.app.Presentation;

import com.example.room.database.Apprepository;
import com.example.room.database.ContactEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ShowAllContactsViewModel extends AndroidViewModel {
    Apprepository repository;
    //  LiveData<List<ContactEntity>> myList;

    public ShowAllContactsViewModel(@NonNull Application application) {
        super(application);
        repository = new Apprepository(application);
    }

    public LiveData<List<ContactEntity>> getAllContacts() {
        return repository.getContacts();
    }

    public LiveData<List<ContactEntity>> searchStuff(String name) {
        return repository.searchDB(name);
    }
}
