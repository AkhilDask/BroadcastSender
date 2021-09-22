package com.example.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtview= findViewById(R.id.textview);

    }
    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.example.EXAMPLE_ACTION");
        intent.putExtra("com.example.Extra_text","Broadcast got");
        sendBroadcast(intent);
    }


    private BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receivedText= intent.getStringExtra("com.example.Extra_text");
            txtview.setText(receivedText);
        }
    };



    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver,filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }


}