//package com.yrabdelrhmn.tutorex.notification;
//
//import android.annotation.SuppressLint;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.os.Build;
//import android.os.IBinder;
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.annotation.RequiresApi;
//import androidx.core.app.NotificationCompat;
//
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.messaging.RemoteMessage;
//import com.yrabdelrhmn.tutorex.R;
//import com.yrabdelrhmn.tutorex.student.MainActivity;
//
//import org.jetbrains.annotations.NotNull;
//
//public class MyFirebaseMessagingService extends FirebaseMessagingService {
//
//
//    private static final String CHANNEL_ID = "notification";
//
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    @Override
//    public void onMessageReceived(@NonNull  RemoteMessage message) {
//        setupChannels();
//    }
//
//    private void studentSendMyNotification(String title, String message) {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//
//        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.mipmap.newlogo_foreground)
//                .setContentTitle(title)
//                .setContentText(message)
//                .setAutoCancel(true)
//                .setSound(soundUri)
//                .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0, notificationBuilder.build());
//    }
//    @RequiresApi(api = Build.VERSION_CODES.O)//if version is Andorid Oreo
//    private void setupChannels(){
//        CharSequence ParticularChannelName = getString(R.string.notification_title);
//        String ParticularChannelDescription = getString(R.string.notification_Desc);
//
//        NotificationChannel ParticularChannel;
//        ParticularChannel = new NotificationChannel(CHANNEL_ID, ParticularChannelName, NotificationManager.IMPORTANCE_LOW);
//        ParticularChannel.setDescription(ParticularChannelDescription);
//        ParticularChannel.enableLights(true);
//        ParticularChannel.setLightColor(Color.RED);
//        ParticularChannel.enableVibration(true);
//         NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//         NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,CHANNEL_ID);
//         notificationManager.notify(0, notificationBuilder.build());
//        notificationManager.createNotificationChannel(ParticularChannel);
//    }
//
//}
