package com.dragos.hakase.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class BubbleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Bubble onCreate", Toast.LENGTH_SHORT).show();
    }
}
