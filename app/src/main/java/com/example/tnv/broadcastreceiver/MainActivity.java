package com.example.tnv.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Network_Changed network_changed;
    Button buttonClick;
    public static final String ACTION_THANGCODER = "thangcoder";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ACTION_THANGCODER,"Blog lap trinh Android");
                intent.setAction(ACTION_THANGCODER);
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //initBroadcastreceiver();
        initCustomBroadcast();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(network_changed);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void initBroadcastreceiver(){
        network_changed = new Network_Changed();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(network_changed,intentFilter);
    }

    private void initCustomBroadcast(){
        network_changed = new Network_Changed();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_THANGCODER);
        registerReceiver(network_changed,intentFilter);
    }
}
