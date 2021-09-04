package com.forbitbd.diploma.fcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.forbitbd.diploma.R;
import com.forbitbd.diploma.ui.NoticeActivity;
import com.forbitbd.diploma.ui.main.MainActivity;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Arrays;

public class FirebaseMessageReceiver extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    public static final String FIREBASE_TOKEN = "token";

    String title;
    String text;

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        title = remoteMessage.getNotification().getTitle();
        text = remoteMessage.getNotification().getBody();

        if (remoteMessage.getData().size() > 0) {
            sendUserNotification(remoteMessage.getData().get(title), remoteMessage.getData().get(text));
        }
        super.onMessageReceived(remoteMessage);
    }

    private void sendUserNotification(String s, String s1) {
        int notifyID = 1;
        Intent intent;
        NotificationChannel mChannel;

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        intent = new Intent(this, NoticeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        String CHANNEL_ID = this.getPackageName();// The id of the channel.
        CharSequence name = "Sample one";// The user-visible name of the channel.
        int importance = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            importance = NotificationManager.IMPORTANCE_HIGH;
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        notificationBuilder.setContentTitle(title);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
//        notificationBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        notificationBuilder.setSound(defaultSoundUri);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(text));
        notificationBuilder.setContentText(text);
        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        notificationBuilder.setSmallIcon(getNotificationIcon(notificationBuilder));

        NotificationManager notificationManager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationManager.createNotificationChannel(mChannel);
        }
        if (notificationManager != null) {
            notificationManager.notify(notifyID /* ID of notification */, notificationBuilder.build());
        }
    }

    private int getNotificationIcon(NotificationCompat.Builder notificationBuilder) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = 0x036085;
            notificationBuilder.setColor(color);
            return R.drawable.ic_baseline_notifications_24;

        } else {
            return R.mipmap.ic_launcher;
        }
    }



}
