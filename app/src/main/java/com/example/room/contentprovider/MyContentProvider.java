/*

package com.example.room.contentprovider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.example.room.database.Apprepository;
import com.example.room.database.ContactEntity;
import com.example.room.database.MyDatabase;

public class MyContentProvider extends ContentProvider {
    MyDatabase myDatabase;
    Apprepository apprepository;
    Application application = new Application();

    public static final String AUTHORITY = "com.example.room.mycontentprovider";
    public static final Uri CONTENt_URI = Uri.parse("content://" + AUTHORITY + "/" + ContactEntity.TABLE_NAME);

    static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, ContactEntity.TABLE_NAME, 1);
        uriMatcher.addURI(AUTHORITY, ContactEntity.TABLE_NAME + "/#", 2);
    }

    public MyContentProvider() {
        apprepository = new Apprepository(application);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        apprepository.insertContact();

    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        myDatabase = MyDatabase.getInstance(getContext());
        if (myDatabase != null) {
            return true;
        } else
            return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
*/
