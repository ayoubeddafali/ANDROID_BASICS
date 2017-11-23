package com.android.neo.tp;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.neo.tp.fragments.DownloadingFragment;
import com.android.neo.tp.helpers.adapters.DownloadingAdapter;
import com.android.neo.tp.helpers.interfaces.InterfaceBetweenActivityAndFragment;
import com.android.neo.tp.helpers.models.Download;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ListFragmentActivity extends AppCompatActivity implements InterfaceBetweenActivityAndFragment {
    @BindView(R.id.list_fragments)
    ListView fragmentList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);
        ArrayList<Download> my_list = new ArrayList<Download>();
        ButterKnife.bind(this);
        Download d1 = new Download("first doWnload", "header 1");
        Download d2 = new Download("second doWnload", "header 2");
        Download d3 = new Download("third doWnload", "header 3");
        my_list.add(d1);
        my_list.add(d2);
        my_list.add(d3);
        fragmentList.setAdapter(new DownloadingAdapter(this, my_list , this));

    }

}
