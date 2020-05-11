package com.example.tired;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        create();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"xyz",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getBaseContext(), MyReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 100,i, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 5000, pi);
            }
        });
    }

    private void  create()
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String tag="mm";
            Log.d(tag,"xyz");
            NotificationChannel notificationChannel = new NotificationChannel("abc","abc",NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager =  getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }




    }


}
