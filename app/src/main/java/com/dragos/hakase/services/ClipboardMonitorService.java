package com.dragos.hakase.services;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ClipboardMonitorService extends Service {
    private static final String TAG = ClipboardMonitorService.class.getName();
    private ClipboardManager mClipboardManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        mClipboardManager =
                (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        mClipboardManager.addPrimaryClipChangedListener(
                mOnPrimaryClipChangedListener);
        Toast.makeText(this, "Hakase started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        if (mClipboardManager != null) {
            mClipboardManager.removePrimaryClipChangedListener(
                    mOnPrimaryClipChangedListener);
        }
        Toast.makeText(this, "Hakase stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private ClipboardManager.OnPrimaryClipChangedListener mOnPrimaryClipChangedListener =
            new ClipboardManager.OnPrimaryClipChangedListener() {
        @Override
        public void onPrimaryClipChanged() {
            Log.d(TAG, "onPrimaryClipChanged");
            ClipData clip = mClipboardManager.getPrimaryClip();
            CharSequence copiedText = clip.getItemAt(0).getText();
            Log.d(TAG, "Copied Text: "+copiedText.toString());
            Toast.makeText(ClipboardMonitorService.this, copiedText, Toast.LENGTH_SHORT).show();
        }
    };
}