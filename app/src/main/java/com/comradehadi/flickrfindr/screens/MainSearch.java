package com.comradehadi.flickrfindr.screens;

import android.content.Intent;
import android.os.Bundle;

import com.comradehadi.flickrfindr.data.LocalStore;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.comradehadi.flickrfindr.R;

public class MainSearch extends AppCompatActivity implements View.OnClickListener{
    EditText searchEditText;
    LocalStore localStore;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search);
//        Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        searchEditText = (EditText) findViewById(R.id.searchText);
        searchButton = (Button) findViewById(R.id.searchButton);
        localStore = new LocalStore(MainSearch.this);

        searchButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchButton:


                launchSearchWithQuery(searchEditText.getText().toString());

                break;

            default:

        }
    }

    private void launchSearchWithQuery(String query) {

        localStore.saveLastQuery(query);

        startActivity(new Intent(MainSearch.this, ImageGallery.class));




    }
}
