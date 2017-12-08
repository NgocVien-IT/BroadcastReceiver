package com.example.tnv.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by TNV on 12/8/2017.
 */

public class Network_Changed extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(MainActivity.ACTION_THANGCODER)) {
            String title = intent.getStringExtra(MainActivity.ACTION_THANGCODER);
            Toast.makeText(context,title, Toast.LENGTH_LONG).show();
        }
    }

}
