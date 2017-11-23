package com.android.neo.tp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.neo.tp.fragments.FirstFragment;
import com.android.neo.tp.fragments.SecondFragment;

public class FragmetViewActivity extends AppCompatActivity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmet_view);
        FirstFragment f = new FirstFragment();
        SecondFragment s = new SecondFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.first_fragment, f).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.second_fragment, s).commit();


    }
}
