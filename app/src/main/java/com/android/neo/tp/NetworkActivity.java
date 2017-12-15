package com.android.neo.tp;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NetworkActivity extends AppCompatActivity {

    private ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);
        //WifiListener wifiListener = new WifiListener();
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    }


    @OnClick(R2.id.check_cnx) void getConnectionTypeAndStatus(){
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo net = manager.getActiveNetworkInfo();
        if (net != null ){
            int state = net.getState().compareTo(NetworkInfo.State.CONNECTED);
            Log.d("DEBUG", "state " + state );
            Toast.makeText(this, "STATE : " + String.valueOf(state), Toast.LENGTH_SHORT).show();
            if (state == 0  ){
                Log.d("DEBUG", "Connecté");
                Toast.makeText(this, "Connecté", Toast.LENGTH_SHORT).show();
            }
            int type = net.getType();
            Log.d("DEBUG", "type : "  + type);
            Toast.makeText(this, "TYPE : " + type , Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R2.id.activate_deactivate_wifi) void activateDeactivateWifi(){
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(true);
            Toast.makeText(this, "WIFI ENABLED", Toast.LENGTH_SHORT).show();

        }else {

            wifiManager.setWifiEnabled(false);
            Toast.makeText(this, "WIFI DISABLED", Toast.LENGTH_SHORT).show();
            String type = connectivityManager.getActiveNetworkInfo().getTypeName() != null ? connectivityManager.getActiveNetworkInfo().getTypeName() : "";
            if (type != null )
                Toast.makeText(this, "ACTIVATING " + type, Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "DISABLING WIFI", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.activate_deactivate_bluetooth) void activateDeactivateBluetooth(){
        BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
        if(! bluetooth.isEnabled()){
            Intent launchBlt = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(launchBlt);
        }
    }

    @OnClick(R2.id.get_location_means) void getAllMeans(){
        LocationManager managerLoc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> fournissers = managerLoc.getAllProviders();
        for (String f: fournissers){
            Toast.makeText(getApplicationContext(), " " + f , Toast.LENGTH_SHORT).show();
            if (f.equals(LocationManager.GPS_PROVIDER)){}
        }
    }

    public void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            LocationManager managerLoc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = managerLoc.getLastKnownLocation("network");
            if (location != null )
            {
                Toast.makeText(getApplicationContext(), " Latitude " + location.getLatitude(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), " Longitude " + location.getLongitude(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), "NOT WORKING", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R2.id.get_location) void getMyLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }else {
            getLocation();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1 :
                if (grantResults.length > 0  &&   grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    getLocation();
                }
        }
    }




}
