package com.comradehadi.flickrfindr.data;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStore {

    Context context;

    public LocalStore(Context context) {
        this.context = context;
    }

    public void saveLastQuery(String query){

        SharedPreferences queryPreference = this.context.getSharedPreferences("data",0);
        SharedPreferences.Editor queryPreferenceEditor = queryPreference.edit();

        queryPreferenceEditor.putString("query",query).commit();
    }


    public String retrieveLastQuery(){
        String lastQuery = null;

        SharedPreferences queryPreference = this.context.getSharedPreferences("data",0);

        lastQuery = queryPreference.getString("query", null);

        return lastQuery;


    }
}
