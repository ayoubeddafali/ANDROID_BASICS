package com.android.neo.tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.neo.tp.helpers.adapters.AndroidAdapter;
import com.android.neo.tp.helpers.models.Test;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class AdvancedListActivity extends AppCompatActivity {

    @BindView(R.id.advanced_list)
    ListView advancedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_list);
        ArrayList<Test> my_list = new ArrayList<Test>();
        ButterKnife.bind(this);
        Test t1 = new Test("Android", R.drawable.android );
        Test t2 = new Test("Ios", R.drawable.ios);
        Test t3 = new Test("Windows Phone", R.drawable.win  );
        my_list.add(t1);
        my_list.add(t2);
        my_list.add(t3);
        advancedList.setAdapter(new AndroidAdapter(this, my_list ));
       /*  advancedList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(myIntent);
                    }
                }
        );
*/
    }

    @OnItemClick(R2.id.advanced_list)
    public void item_clicked(){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
