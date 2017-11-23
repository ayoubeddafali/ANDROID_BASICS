package com.android.neo.tp.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSBroadcastReceiver extends BroadcastReceiver{
    private static final String TAG = SMSBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
        Toast.makeText(context, "something received", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals(SMS_RECEIVED_ACTION)){
            String val = intent.getExtras().getString("extra");
            Object[] pdus = (Object[]) intent.getExtras().get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0 ; i < pdus.length;  i++){
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                Log.d(TAG, messages[i].getDisplayMessageBody());
            }

        }
    }
}
