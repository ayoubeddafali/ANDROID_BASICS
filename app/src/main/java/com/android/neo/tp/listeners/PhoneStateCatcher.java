package com.android.neo.tp.listeners;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneStateCatcher  extends PhoneStateListener {
    private static final String TAG = PhoneStateCatcher.class.getSimpleName();
    public void onCallStateChanged(int etat, String numero){
        super.onCallStateChanged(etat, numero);
        switch (etat) {
            case TelephonyManager.CALL_STATE_IDLE:
                Log.d("-- AYOUB --" + TAG, "STATE IS IDLE");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.d("-- AYOUB --" + TAG, "STATE IS OFFHOOK");
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Log.d(" -- AYOUB -- " + TAG, "STATE IS RINGING");
                break;

        }
    }
}
