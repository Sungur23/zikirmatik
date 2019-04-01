package com.company.kadir.zikirmatic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;

public class uygulama_secim extends AppCompatActivity {

    Button zikirmatik;
    Button diger_uygulamalar;

    public InterstitialAd mInterstitialAd;  //Tam sayfa reklam göstermek için.
    Boolean reklamgoster = true;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uygulama_secim);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        reklamgoster = preferences.getBoolean("goster", true);

        MobileAds.initialize(this, "ca-app-pub-3206398076180977~1188508498");

        //**************inersteller ad***********************
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3206398076180977/2090226859");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //******************************************************

        zikirmatik = (Button)findViewById(R.id.zikirmatik);
        diger_uygulamalar = (Button)findViewById(R.id.diger_uygulamalar);
        zikirmatik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calender = Calendar.getInstance();

                calender.set(Calendar.HOUR_OF_DAY, 15);
                calender.set(Calendar.MINUTE, 20);

                Intent intent = new Intent(getApplicationContext(), Notification_reciever.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

                //*******intersteller ad başlar***********
                if (mInterstitialAd.isLoaded() && reklamgoster) {
                    mInterstitialAd.show();
                }

                else {
                    Intent i = new Intent(uygulama_secim.this, anasayfa_yeni.class);
                    startActivity(i);
                    finish();
                    System.out.println("ad yüklenemedi.");
                }

                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Code to be executed when the interstitial ad is closed.
                        Intent i = new Intent(uygulama_secim.this, anasayfa_yeni.class);
                        startActivity(i);
                        finish();
                    }
                });
                //***************************

            }
        });
        diger_uygulamalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(uygulama_secim.this, diger_uygulamalar.class);
                startActivity(i);
                finish();
            }
        });
    }
}
