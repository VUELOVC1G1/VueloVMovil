package com.example.vuelovmovil.notifications;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

import java.util.Objects;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        Looper.prepare();
        new Handler().postDelayed(() -> {
            Log.d(TAG, "From: " + message.getFrom());

            // Check if message contains a data payload.
            if (message.getData().size() > 0) {
                Log.d(TAG, "Message data payload: " + message.getData());
            }

            // Check if message contains a notification payload.
            if (message.getNotification() != null) {
                Log.d(TAG, "Message Notification Body: " + Objects.requireNonNull(message.getNotification()).getTitle());
                Toast.makeText(getBaseContext(), Objects.requireNonNull(message.getNotification()).getTitle(), Toast.LENGTH_LONG).show();
            }
        }, 2000);
        Looper.loop();
    }
}
