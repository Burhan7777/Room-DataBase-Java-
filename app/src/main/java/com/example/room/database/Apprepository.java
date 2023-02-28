package com.example.room.database;

import android.app.Application;
import android.database.sqlite.SQLiteConstraintException;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;

public class Apprepository {
    MyDatabase myDatabase;

    public Apprepository(Application application) {
        myDatabase = MyDatabase.getInstance(application);
    }

    public LiveData<List<ContactEntity>> getContacts() {
        return myDatabase.getDAO().getContacts();
    }

    public LiveData<ContactEntity> getDetails(String name) {
        return myDatabase.getDAO().getContact(name);
    }

    public void insertContact(ContactEntity contactEntity) {
        new insertData().insertContact(contactEntity, myDatabase);
    }

    public void deleteContact(String string) {
        new deleteData().deleteContact(string, myDatabase);
    }

    public void contactDetails(String name) {
        new contactDetails().getContactDetails(name, myDatabase);
    }

    public LiveData<List<ContactEntity>> searchDB(String search) {
        return myDatabase.getDAO().searchDatabase(search);
    }


    public static class insertData {
        MyDatabase myDatabase;

        public void insertContact(ContactEntity contactEntity, MyDatabase database) {
            this.myDatabase = database;
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.execute(new Runnable() {
                @Override
                public void run() {
                    myDatabase.getDAO().addContact(contactEntity);
                }
            });
        }
    }

    public static class deleteData {
        MyDatabase myDatabase;


        public void deleteContact(String string, MyDatabase database) {
            this.myDatabase = database;
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.execute(new Runnable() {
                @Override
                public void run() {
                    myDatabase.getDAO().deleteByName(string);
                }
            });
        }
    }

    public static class contactDetails {
        MyDatabase myDatabase;

        public void getContactDetails(String string, MyDatabase database) {
            this.myDatabase = database;
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.execute(new Runnable() {
                @Override
                public void run() {
                    myDatabase.getDAO().getContact(string);
                }
            });
        }
    }
}

