package com.dragos.hakase.services;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.dragos.hakase.R;

public class ChatHeadService extends Service {

    private WindowManager windowManager;
    private ImageView chatHead;

//    @Override
//    protected void onHandleIntent(Intent workIntent) {
//        CharSequence text = workIntent
//                .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
//        Toast.makeText(this, "oi!", Toast.LENGTH_SHORT).show();
//        if(text != null) {
//            Toast.makeText(this, "text: " + text.toString(), Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        chatHead = new ImageView(this);
        chatHead.setImageResource(R.drawable.ic_launcher_foreground);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.RIGHT;
        params.x = 0;
        params.y = 100;

        windowManager.addView(chatHead, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (chatHead != null) windowManager.removeView(chatHead);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
