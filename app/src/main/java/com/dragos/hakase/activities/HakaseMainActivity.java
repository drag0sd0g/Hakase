package com.dragos.hakase.activities;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dragos.hakase.R;

public class HakaseMainActivity extends Activity {

    private static final String TAG = HakaseMainActivity.class.getName();
    private static final String NOTIFICATION_CHANNEL = "Hakase";

    NotificationManager notificationManager;
    Notification.Builder builder;
    NotificationChannel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Hakase Started", Toast.LENGTH_SHORT).show();
        CharSequence text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
        if(text != null) {
            Log.d(TAG, "To Translate: " +text);
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            channel = new NotificationChannel("1", NOTIFICATION_CHANNEL, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("translation");
            channel.setAllowBubbles(true);
            Log.d(TAG, "Built notification channel");
            Intent target = new Intent(HakaseMainActivity.this, BubbleLookupActivity.class);
            PendingIntent bubbleIntent =
                    PendingIntent.getActivity(HakaseMainActivity.this, 0, target, PendingIntent.FLAG_MUTABLE /* flags */);
            Log.d(TAG, "Built bubble intent");
            Notification.BubbleMetadata bubbleData =
                    new Notification.BubbleMetadata.Builder(bubbleIntent, Icon.createWithResource(HakaseMainActivity.this, R.mipmap.ic_launcher))
                            .setDesiredHeight(600)
                            .build();
            Log.d(TAG, "Built bubble metadata");
            builder = new Notification.Builder(HakaseMainActivity.this, channel.getId())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setBubbleMetadata(bubbleData);
            Log.d(TAG, "Sending bubble notification");
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(1, builder.build());
        }
    }
}