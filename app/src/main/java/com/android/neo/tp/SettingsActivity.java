package com.android.neo.tp;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        SharedPreferences prefs = getPreferenceManager().getDefaultSharedPreferences(this);
        String value = prefs.getString("networkType", "default");
        Log.d("DEBUG", value);
    }

}
