package com.android.neo.tp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.neo.tp.services.MyHelloService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static int RECEIVER_INTENT_ACTIVITY_CODE = 100;
    @BindView(R2.id.main_text)
    TextView main_text ;
    Context context ;
    private MyBroadCastReceiver myreceiver ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, MyHelloService.class));
        myreceiver = new MyBroadCastReceiver();
        IntentFilter filtre = new IntentFilter("myAction");
        registerReceiver(myreceiver, filtre);
        context = getApplicationContext();
        ButterKnife.bind(this);
    }
    @OnClick(R2.id.main_click_btn) void click_btn_action(){
        main_text.setText("Text has changed !!");
    }
    @OnClick(R2.id.main_reset_btn) void reset_btn_action(){
        main_text.setText("Hello World !!");
    }

    @OnClick(R2.id.main_list_btn) void list_btn_action(){
        Intent myIntent = new Intent(this, ListActivity.class);
        startActivity(myIntent);
    }
    @OnClick(R2.id.main_advancedlist_btn) void show_advanced_list(){
        Intent myIntent = new Intent(this, AdvancedListActivity.class);
        startActivity(myIntent);
    }
    @OnClick(R2.id.main_card_btn) void show_card_view_view(){
        Intent myIntent = new Intent(this, CardViewActivity.class);
        startActivity(myIntent);
    }
    @OnClick(R2.id.main_fragment_btn) void show_fragment_view() {
        Intent myIntent = new Intent(getApplicationContext(), FragmetViewActivity.class);
        startActivity(myIntent);
    }
    @OnClick(R2.id.main_dialer_btn) void open_dialer(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }
    @OnClick(R2.id.main_intent_with_param_btn) void open_intent_with_param(){
        Intent intent = new Intent(this, ReceiverIntentActivity.class);
        startActivityForResult(intent, RECEIVER_INTENT_ACTIVITY_CODE);

    }
    @OnClick(R2.id.main_list_fragment_btn) void open_list_with_fragments(){
        Intent intent = new Intent(this, ListFragmentActivity.class);
        startActivity(intent);
    }
    @OnClick(R2.id.main_preference_btn) void open_preference(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    @OnClick(R2.id.main_system) void open_system(){
        Intent intent = new Intent(this, SystemActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == RECEIVER_INTENT_ACTIVITY_CODE) {
            if (resultCode == RESULT_OK) {

                // get String data from Intent
                String secretCode = data.getStringExtra("secret");
                main_text.setText(secretCode);
            }
        }
    }

     class MyBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("DEBUG", "shit");
            Log.d("DEBUG", intent.getAction());
        }



    }

}
