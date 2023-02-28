package com.example.room.viewmodels;

import android.app.Application;

import com.example.room.database.Apprepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class DeleteContactViewModel extends AndroidViewModel {
    Apprepository apprepository;

    public DeleteContactViewModel(@NonNull Application application) {
        super(application);
        apprepository = new Apprepository(application);
    }

    public void deleteContact(String name) {
        apprepository.deleteContact(name);
    }
}
