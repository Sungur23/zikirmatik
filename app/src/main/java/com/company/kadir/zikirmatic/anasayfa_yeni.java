package com.company.kadir.zikirmatic;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class anasayfa_yeni extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener, BillingProcessor.IBillingHandler{

    private AdView madview;
    int SayacIleri = 0;
    int SayacGeri = 0;
    boolean secim = false;
    int resim;
    ImageView image;

    Boolean reklamgoster = true;

    Button btn;

    BillingProcessor bp;

    int image_gizle;  //ekranı temizle ye basıldığı zaman imageview i gizlesin
    String a ;
    String mana;

    Boolean sesDurumu;
    Boolean titresimDurumu;

    SharedPreferences preferences, ayarlar;

    TextView text;
    TextView textView2;

    MediaPlayer ses;
    Vibrator titresim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa_yeni);

        bp = new BillingProcessor(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgLwVViol+4PnzC9i1ECMtySSqth3gUOusN8H6D/wvkR2hPNxpvF8q3cfzzLDBhsGzJCz3hUwDSzfhdeobVUggwuO/f8pEcCGBj0fkH+9WPZJ0p57/Q5u8yDNHE4drr5+yw1eu+6/b5CLLOlfYjBTYYw6hmPOzpVTzRpZFrK8R3jWgrwIZtFUA1w3FTG/eMvrvTzxcOSxzcPjc7AwKRO3mb1gOuf2v5FqTHavGCuT3nV5FeqG7sj69OYrT71twJUOiHhh4QOAiz5Q45wIEMSstbJMstOEr6KRk7zboNM+sVpq40YNVsG52pBhfxSdLnpcTNhFbOusEkYYL2VwaQe/4QIDAQAB", this);


        image = (ImageView)findViewById(R.id.imageView);
        image.setVisibility(View.INVISIBLE);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        reklamgoster = preferences.getBoolean("goster", true);

        MobileAds.initialize(this, "ca-app-pub-3206398076180977~1188508498");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3206398076180977/8684812993");


        madview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madview.loadAd(adRequest);
        madview.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                if(reklamgoster == true)
                {
                    madview.setVisibility(View.VISIBLE);
                }
                else
                {
                    madview.setVisibility(View.INVISIBLE);
                }
            }


            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                if(reklamgoster == true)
                {
                    madview.setVisibility(View.VISIBLE);
                }
                else
                {
                    madview.setVisibility(View.INVISIBLE);
                }
            }
        });


        Intent i = getIntent();
        a = i.getStringExtra("mesaj");
        mana = i.getStringExtra("mana");
        SayacGeri = i.getIntExtra("zikirsayisi", 0);
        secim = i.getBooleanExtra("secim", false);
        resim = i.getIntExtra("resim", 0);
        image_gizle = i.getIntExtra("resim_gizle",0);

        if (resim == 1)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.allah);
        }
        else if (resim == 2)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.rahman);
        }
        else if (resim == 3)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.rahim);
        }
        else if (resim == 4)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.melik);
        }
        else if (resim == 5)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kuddus);
        }
        else if (resim == 6)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.selam);
        }else if (resim == 7)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mumin);
        }
        else if (resim == 8)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muheymin);
        }
        else if (resim == 9)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.aziz);
        }
        else if (resim == 10)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.cebbar);
        }
        else if (resim == 11)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mutekebbir);
        }
        else if (resim == 12)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.halik);
        }
        else if (resim == 13)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.bari);
        }
        else if (resim == 14)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.musavvir);
        }
        else if (resim == 15)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.gaffar);
        }

        else if (resim == 16)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kahhar);
        }
        else if (resim == 17)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.vehhab);
        }
        else if (resim == 18)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.rezzak);
        }
        else if (resim == 19)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.fettah);
        }
        else if (resim == 20)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.alim);
        }
        else if (resim == 21)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kabid);
        }
        else if (resim == 22)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.basit);
        }
        else if (resim == 23)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hafid);
        }
        else if (resim == 24)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.rafi);
        }
        else if (resim == 25)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muiz);
        }
        else if (resim == 26)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muzill);
        }
        else if (resim == 27)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.semi);
        }
        else if (resim == 28)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.basir);
        }
        else if (resim == 29)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hakem);
        }
        else if (resim == 30)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.adl);
        }
        else if (resim == 31)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.latif);
        }
        else if (resim == 32)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.habir);
        }
        else if (resim == 33)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.halim);
        }
        else if (resim == 34)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.azim);
        }else if (resim == 35)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.gafur);
        }
        else if (resim == 36)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.sekur);
        }else if (resim == 37)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.aliyy);
        }else if (resim == 38)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kebir);
        }else if (resim == 39)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hafiz);
        }
        else if (resim == 40)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mukit);
        }
        else if (resim == 41)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hasib);
        }
        else if (resim == 42)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.celil);
        }
        else if (resim == 43)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kerim);
        }
        else if (resim == 44)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.rakib);
        }
        else if (resim == 45)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mucib);
        }
        else if (resim == 46)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.vasi);
        }
        else if (resim == 47)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hakim);
        }
        else if (resim == 48)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.vedud);
        }
        else if (resim == 49)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mecid);
        }
        else if (resim == 50)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.bais);
        }
        else if (resim == 51)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.sehid);
        }
        else if (resim == 52)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hakk);
        }else if (resim == 53)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.vekil);
        }else if (resim == 54)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kaviyy);
        }
        else if (resim == 55)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.metin);
        }
        else if (resim == 56)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.veliyy);
        }
        else if (resim == 57)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hamid);
        }
        else if (resim == 58)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muhsi);
        }
        else if (resim == 59)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mubdi);
        }
        else if (resim == 60)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muid);
        }
        else if (resim == 61)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muhyi);
        }
        else if (resim == 62)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mumit);
        }
        else if (resim == 63)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hayy);
        }
        else if (resim == 64)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kayyum);
        }
        else if (resim == 65)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.vacid);
        }
        else if (resim == 66)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.macid);
        }
        else if (resim == 67)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.vahid);
        }
        else if (resim == 68)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.samed);
        }
        else if (resim == 69)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.kadir);
        }
        else if (resim == 70)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muktedir);
        }
        else if (resim == 71)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mukaddim);
        }
        else if (resim == 72)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muahhir);
        }
        else if (resim == 73)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.evvel);
        }
        else if (resim == 74)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.ahir);
        }
        else if (resim == 75)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.zahir);
        }
        else if (resim == 76)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.batin);
        }
        else if (resim == 77)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.vali);
        }
        else if (resim == 78)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muteali);
        }
        else if (resim == 79)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.berr);
        }
        else if (resim == 80)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.tevvab);
        }
        else if (resim == 81)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muntakim);
        }
        else if (resim == 82)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.afuvv);
        }
        else if (resim == 83)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.rauf);
        }
        else if (resim == 84)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.malikulmulk);
        }
        else if (resim == 85)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.zulcelalivelikram);
        }
        else if (resim == 86)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.muksit);
        }
        else if (resim == 87)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.cami);
        }
        else if (resim == 88)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.ganiy);
        }
        else if (resim == 89)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mugni);
        }
        else if (resim == 90)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.mani);
        }
        else if (resim == 91)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.darr);
        }
        else if (resim == 92)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.nafi);
        }
        else if (resim == 93)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.nur);
        }
        else if (resim == 94)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.hadi);
        }
        else if (resim == 95)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.bedi);
        }
        else if (resim == 96)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.baki);
        }
        else if (resim == 97)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.varis);
        }
        else if (resim == 98)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.rasid);
        }
        else if (resim == 99)
        {
            image.setVisibility(View.VISIBLE);
            image.setImageResource(R.mipmap.sabur);
        }

        //image.setVisibility(View.INVISIBLE);
        //*********************ekranı temizleye basınca imageview gizlenmesi için*******
        if(image_gizle == 1)
        {image.setVisibility(View.INVISIBLE);}
        else
        {image.setVisibility(View.VISIBLE);}
        //*********************************************************************************
        text = (TextView)findViewById(R.id.textView);
        text.setText(a);

        textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText(mana);

        btn = findViewById(R.id.button);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        ayarlar = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        ses = MediaPlayer.create(this, R.raw.beep);
        titresim = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        ayarlariYukle();

        SayacIleri = preferences.getInt("sayac_anahtarı_ileri", 0);
        reklamgoster = preferences.getBoolean("goster", true);
        //SayacGeri = preferences.getInt("sayac_anahtarı_geri", 0);

        if(secim == true)
        {
            btn.setText("" + SayacGeri);
        }
        else
        {
            btn.setText("" + SayacIleri);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(secim == true)
                {
                    if(SayacGeri >= 1)
                    {
                        if(SayacGeri <= 6 && sesDurumu == false)
                        {
                            sesDurumu = true;
                        }

                        SayacGeri--;
                    }

                    btn.setText("" + SayacGeri);

                    if(SayacGeri == 0 && sesDurumu == true)
                    {
                        sesDurumu = false;
                    }
                }
                else
                {
                    SayacIleri++;
                    btn.setText("" + SayacIleri);
                }

                if(sesDurumu == true)
                {
                    ses.start();
                }
                if(titresimDurumu == true)
                {
                    titresim.vibrate(250);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        SharedPreferences.Editor editor =  preferences.edit();
        editor.putInt("sayac_anahtarı_ileri", SayacIleri);
        editor.putInt("sayac_anahtarı_geri", SayacGeri);
        editor.putBoolean("goster", reklamgoster);
        editor.commit();
        super.onStop();
    }

    @Override
    protected void onPause() {


        SharedPreferences.Editor editor =  preferences.edit();
        editor.putInt("sayac_anahtarı_ileri", SayacIleri);
        editor.putInt("sayac_anahtarı_geri", SayacGeri);
        editor.putBoolean("goster", reklamgoster);
        editor.commit();
        super.onPause();
        System.out.println("reklam goster on pause: " + reklamgoster);
    }
    private void ayarlariYukle() {

        sesDurumu = ayarlar.getBoolean("ses", false);
        titresimDurumu = ayarlar.getBoolean("titresim", false);
        ayarlar.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem satinal = menu.findItem(R.id.satinal);
        if(reklamgoster == false)
        {
            satinal.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting)
        {
            Intent i = new Intent(getApplicationContext(), Ayarlar.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sifirla)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(anasayfa_yeni.this);
            alert.setTitle("Sayaç Sıfırlama");
            alert.setMessage("Sayacı Sıfırlamak İstediğinizden Eminmisiniz?");
            alert.setCancelable(true);

            alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();

                }
            });

            alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
               //    **************sayacı sıfırlamak için*********************
                    SayacIleri = 0;
                    secim = false;
                    text.setText("");
                    textView2.setText("");
                    btn.setText("" + SayacIleri);
                    image.setVisibility(View.INVISIBLE);
               //****************************************************************
                }
            });

            AlertDialog al = alert.create();
            al.show();
            return true;
        }
        if (id == R.id.zikirsecimi)
        {
            Intent i = new Intent(getApplicationContext(), ZikirSecimi.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.satinal)
        {
            bp.purchase(anasayfa_yeni.this, "deneme");

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        ayarlariYukle();

    }

    boolean twice;

    @Override
    public void onBackPressed() {
        if(twice == true)
        {
            //**********sayacı kaydetmek için********
            SharedPreferences.Editor editor =  preferences.edit();
            editor.putInt("sayac_anahtarı_ileri", SayacIleri);
            editor.putInt("sayac_anahtarı_geri", SayacGeri);
            editor.putBoolean("goster", reklamgoster);
            editor.commit();
            //***************************************

            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            System.exit(0);
        }
        //  super.onBackPressed();
        Toast.makeText(anasayfa_yeni.this, "Çıkmak için lütfen geri tuşuna bir kere daha basın.", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
            }
        }, 3000);
        twice = true;
    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {

        reklamgoster = false;
        Toast.makeText(getApplicationContext(),"Uygulamayı Satın Alarak Bize Destek Olduğunuz için Teşekkür Ederiz.", Toast.LENGTH_LONG).show();
        System.out.println("reklam goster satın aldıktan sonra: " + reklamgoster);
        SharedPreferences.Editor editor =  preferences.edit();
        editor.putBoolean("goster", reklamgoster);
        editor.commit();

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {
        Toast.makeText(getApplicationContext(),"Üzgünüm, bir hata oluştu. Lütfen daha sonra tekrar deneyin.", Toast.LENGTH_LONG).show();
        reklamgoster = true;
        SharedPreferences.Editor editor =  preferences.edit();
        editor.putBoolean("goster", reklamgoster);
        editor.commit();
    }

    @Override
    public void onBillingInitialized() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }

        //**********sayacı kaydetmek için********
        SharedPreferences.Editor editor =  preferences.edit();
        editor.putInt("sayac_anahtarı_ileri", SayacIleri);
        editor.putInt("sayac_anahtarı_geri", SayacGeri);
        editor.putBoolean("goster", reklamgoster);
        editor.commit();
        //***************************************
        super.onDestroy();
    }
}
