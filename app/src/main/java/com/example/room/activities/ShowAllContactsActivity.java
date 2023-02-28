package com.example.room.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.room.MyAdapter;
import com.example.room.database.ContactEntity;
import com.example.room.database.MyDatabase;
import com.example.room.R;
import com.example.room.viewmodels.ShowAllContactsViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowAllContactsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    RecyclerView recyclerView;
    ShowAllContactsViewModel viewModel;
    MyAdapter myAdapter;
    List<ContactEntity> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.recyclerView);
        viewModel = new ViewModelProvider(this).get(ShowAllContactsViewModel.class);
        Observer<List<ContactEntity>> observer = new Observer<List<ContactEntity>>() {
            @Override
            public void onChanged(List<ContactEntity> contactEntities) {
                myAdapter.updateMethod(contactEntities);
            }
        };
        myAdapter = new MyAdapter(myList);
        viewModel.getAllContacts().observe(this, observer);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (query != null) {
            searchDatabase(query);
        }

        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (query != null) {
            searchDatabase(query);
        }

        return true;


    }

    public void searchDatabase(String query) {
        String searchQuery = "%" + query + "%";
        viewModel.searchStuff(searchQuery).observe(this, new Observer<List<ContactEntity>>() {
            @Override
            public void onChanged(List<ContactEntity> contactEntities) {
                myAdapter.setData(contactEntities);
            }
        });
    }

}