package com.example.room.viewmodels;

import android.app.Application;

import com.example.room.database.Apprepository;
import com.example.room.database.ContactEntity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class GetContactDetailsViewModel extends AndroidViewModel {
    Apprepository apprepository;

    public GetContactDetailsViewModel(@NonNull Application application) {
        super(application);
        apprepository = new Apprepository(application);
    }

    public LiveData<ContactEntity> getDetails(String name) {
        return apprepository.getDetails(name);
    }
}
