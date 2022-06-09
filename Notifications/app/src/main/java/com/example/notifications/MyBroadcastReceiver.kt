package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val test : Boolean

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
             test = Settings.System.getInt(context?.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) != 0;
        } else {
             test = Settings.Global.getInt(context?.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
        }

        if (context != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel =
                    NotificationChannel(NotificationUtil.CHANNEL_ID, "MINE", importance).apply {
                        description = "descriptionText"
                    }
                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
            if (test)
                NotificationUtil.showNotification(context,"ON")
            else
                NotificationUtil.showNotification(context,"OFF")

        }

    }

}