package com.android.neo.tp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.android.neo.tp.broadcasts.SMSBroadcastReceiver;
import com.android.neo.tp.listeners.PhoneStateCatcher;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SystemActivity extends AppCompatActivity {

    private static final String TAG = SystemActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);
        ButterKnife.bind(this);
        SMSBroadcastReceiver mySmsReceiver = new SMSBroadcastReceiver();
        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(mySmsReceiver, filter);

        // Listen to incoming calls
        PhoneStateCatcher phoneListener = new PhoneStateCatcher();
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener, PhoneStateCatcher.LISTEN_CALL_STATE);
    }


    @OnClick(R2.id.make_call)
    void make_all() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:0656565656"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    @OnClick(R2.id.make_call_dial) void make_call_with_dialer(){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:911"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    @OnClick(R2.id.make_sms) void sendSms(){
        SmsManager manager =  SmsManager.getDefault();
        manager.sendTextMessage("0600000000", null, "HELLO ENSAK", null, null);
    }
}
