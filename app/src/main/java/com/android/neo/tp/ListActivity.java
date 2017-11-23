package com.android.neo.tp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.zip.Inflater;

import butterknife.BindView;

public class ListActivity extends AppCompatActivity {
    String[] items = {"My name is Ayoub Ed-dafali", "This is Android", "Adapter is important", "" +
            "It's all about performane", "Let's test memory", "What about CPU Usage", "Something is weird", "JMeter for testing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView list = (ListView) findViewById(R.id.lists);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (list.getContext(), R.layout.activity_item_list, R.id.list_item , items );
        list.setAdapter(adapter);

    }
}
