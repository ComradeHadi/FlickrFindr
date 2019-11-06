package com.comradehadi.flickrfindr.screens;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.comradehadi.flickrfindr.R;
import com.comradehadi.flickrfindr.utils.ServerRequestHandler;


public class ImageGallery extends AppCompatActivity {

    private static final String TAG = ImageGallery.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d(TAG, "Received a new search query: " + query);

            PreferenceManager.getDefaultSharedPreferences(this)
                    .edit()
                    .putString(ServerRequestHandler.PREF_SEARCH_QUERY, query)
                    .commit();
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.gallery_fragment);
            if (fragment != null) {
                ((ImageGalleryFragment) fragment).refresh();
            }
        }
    }
}
