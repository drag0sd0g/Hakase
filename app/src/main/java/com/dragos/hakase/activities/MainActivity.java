package com.dragos.hakase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import com.dragos.hakase.R;
import com.dragos.hakase.services.ChatHeadService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(getApplicationContext(), ChatHeadService.class));
        Toast.makeText(this, "Hakase started", Toast.LENGTH_SHORT).show();
        finish();
    }

}