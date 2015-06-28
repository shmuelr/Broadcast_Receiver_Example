package com.orbitdesign.broadcastreciverexample;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;


public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";
    public static final int NOTIFICATION_ID = 87;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
            if(BuildConfig.DEBUG)Log.d(TAG, "onHandleIntent");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSubText("Sub text");
        builder.setContentInfo("Content Info");
        builder.setStyle(
                new NotificationCompat
                        .BigTextStyle()
                        .bigText("Some larger message that is shown to the user\nLine 2\nLine 3 \n Line 4\n Line 5"));
        builder.setAutoCancel(false);
        builder.setOngoing(false);
        builder.setColor(Color.MAGENTA);
        builder.setSmallIcon(R.drawable.my_icon_airplanemode);
        builder.setWhen(0);

        Intent notifIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 99, notifIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        Notification notificationCompat = builder.build();

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);


    }
}

