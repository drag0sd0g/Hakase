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

    public static final String EXTRA_MESSAGE = "com.dragos.hakase.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(getApplicationContext(), ChatHeadService.class));
        CharSequence text = getIntent()
                .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
        if(text != null) {
            Toast.makeText(this, "text: " + text.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}