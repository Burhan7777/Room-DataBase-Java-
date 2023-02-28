package com.example.room.database;


import android.database.Cursor;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ContactDAO {

    @Insert()
    long addContact(ContactEntity contactEntity);

    @Query("select * from contacts")
    LiveData<List<ContactEntity>> getContacts();

    @Query("select * from contacts where contact_name == :name")
    LiveData<ContactEntity> getContact(String name);

    @Query("select * from contacts")
    Cursor getContactsByCursor();

    @Query("select * from contacts WHERE id == :id")
    Cursor getContactsByIdByCursor(long id);

    @Query("delete from contacts where contact_name ==:name")
    void deleteByName(String name);

    @Query("UPDATE contacts SET contact_email =:email where contact_name ==:name")
    void updateByName(String email, String name);

    @Query("UPDATE contacts SET contact_gender =:gender where contact_name==:name")
    void updateByName1(String gender, String name);

    @Query("UPDATE contacts SET contact_placeofbirth=:place where contact_name==:name")
    void updateByName2(String place, String name);

    @Query("select * from contacts WHERE contact_name LIKE :searchQuery " +
            "OR contact_email LIKE:searchQuery" +
            " OR contact_gender LIKE :searchQuery " +
            "OR contact_placeofbirth LIKE :searchQuery")
    LiveData<List<ContactEntity>> searchDatabase(String searchQuery);
}
