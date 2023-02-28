package com.example.room.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = ContactEntity.TABLE_NAME)
public class ContactEntity {

    public static final String TABLE_NAME = "contacts";

    @PrimaryKey(autoGenerate = true)
    private long id = 0;

    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;

    @ColumnInfo(name = "contact_placeofbirth")
    private String placeOfBirth;

    @ColumnInfo(name = "contact_gender")
    private String gender;


    public ContactEntity(String name, String email, String placeOfBirth, String gender) {
        this.name = name;
        this.email = email;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
    }

    public ContactEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}




