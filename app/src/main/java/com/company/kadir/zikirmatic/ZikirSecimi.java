package com.company.kadir.zikirmatic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class ZikirSecimi extends AppCompatActivity {

    String ZikirManasi[];
    String Zikirler [];
    int[] ZikirSayisi;

    String zikir ;
    String zikirManasi;
    int zikirsayisi;
    boolean secim = false;
    int resim;
    int image_gizle; //ekranı temizle ye basıldığı zaman imageview i gizlesin

    public InterstitialAd mInterstitialAd;  //Tam sayfa reklam göstermek için.
    Boolean reklamgoster = true;
    SharedPreferences preferences;

    ArrayAdapter<String> veriAdaptoru; //listview için array adaptor tanımlama

    EditText esma_arama; //esma arama için edit text tanımlama

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zikir_secimi);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        reklamgoster = preferences.getBoolean("goster", true);

        MobileAds.initialize(this, "ca-app-pub-3206398076180977~1188508498");

        //**************intersteller ad***********************
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3206398076180977/2090226859");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //******************************************************

        ListView list = (ListView)findViewById(R.id.listView);
        Zikirler = getResources().getStringArray(R.array.Zikirler);
        ZikirManasi = getResources().getStringArray(R.array.ZikirManasi);
        ZikirSayisi = getResources().getIntArray(R.array.ZikirSayisi);

        veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, Zikirler);
        list.setAdapter(veriAdaptoru);

        //**********Esma arama kodlarını buraya yazıyoruz***********************************
        esma_arama = (EditText)findViewById(R.id.arama_text);
        esma_arama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                (ZikirSecimi.this).veriAdaptoru.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //************************************************************************************

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pozisyon, long l) {

                if(pozisyon == 0)
                {
                    zikir = "";
                    zikirsayisi = ZikirSayisi[0];
                    image_gizle = 1;
                }

               else if(pozisyon == 1)
                {
                    zikir = Zikirler[1];
                    zikirManasi = ZikirManasi[1];
                    zikirsayisi = ZikirSayisi[1];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 2)
                {
                    zikir = Zikirler[2];
                    zikirManasi = ZikirManasi[2];
                    zikirsayisi = ZikirSayisi[2];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 3)
                {
                    zikir = Zikirler[3];
                    zikirManasi = ZikirManasi[3];
                    zikirsayisi = ZikirSayisi[3];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 4)
                {
                    zikir = Zikirler[4];
                    zikirManasi = ZikirManasi[4];
                    zikirsayisi = ZikirSayisi[4];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 5)
                {
                    zikir = Zikirler[5];
                    zikirManasi = ZikirManasi[5];
                    zikirsayisi = ZikirSayisi[5];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 6)
                {
                    zikir = Zikirler[6];
                    zikirManasi = ZikirManasi[6];
                    zikirsayisi = ZikirSayisi[6];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 7)
                {
                    zikir = Zikirler[7];
                    zikirManasi = ZikirManasi[7];
                    zikirsayisi = ZikirSayisi[7];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 8)
                {
                    zikir = Zikirler[8];
                    zikirManasi = ZikirManasi[8];
                    zikirsayisi = ZikirSayisi[8];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 9)
                {
                    zikir = Zikirler[9];
                    zikirManasi = ZikirManasi[9];
                    zikirsayisi = ZikirSayisi[9];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 10)
                {
                    zikir = Zikirler[10];
                    zikirManasi = ZikirManasi[10];
                    zikirsayisi = ZikirSayisi[10];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 11)
                {
                    zikir = Zikirler[11];
                    zikirManasi = ZikirManasi[11];
                    zikirsayisi = ZikirSayisi[11];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 12)
                {
                    zikir = Zikirler[12];
                    zikirManasi = ZikirManasi[12];
                    zikirsayisi = ZikirSayisi[12];
                    secim = true;
                    resim = pozisyon;

                }else if(pozisyon == 13)
                {
                    zikir = Zikirler[13];
                    zikirManasi = ZikirManasi[13];
                    zikirsayisi = ZikirSayisi[13];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 14)
                {
                    zikir = Zikirler[14];
                    zikirManasi = ZikirManasi[14];
                    zikirsayisi = ZikirSayisi[14];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 15)
                {
                    zikir = Zikirler[15];
                    zikirManasi = ZikirManasi[15];
                    zikirsayisi = ZikirSayisi[15];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 16)
                {
                    zikir = Zikirler[16];
                    zikirManasi = ZikirManasi[16];
                    zikirsayisi = ZikirSayisi[16];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 17)
                {
                    zikir = Zikirler[17];
                    zikirManasi = ZikirManasi[17];
                    zikirsayisi = ZikirSayisi[17];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 18)
                {
                    zikir = Zikirler[18];
                    zikirManasi = ZikirManasi[18];
                    zikirsayisi = ZikirSayisi[18];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 19)
                {
                    zikir = Zikirler[19];
                    zikirManasi = ZikirManasi[19];
                    zikirsayisi = ZikirSayisi[19];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 20)
                {
                    zikir = Zikirler[20];
                    zikirManasi = ZikirManasi[20];
                    zikirsayisi = ZikirSayisi[20];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 21)
                {
                    zikir = Zikirler[21];
                    zikirManasi = ZikirManasi[21];
                    zikirsayisi = ZikirSayisi[21];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 22)
                {
                    zikir = Zikirler[22];
                    zikirManasi = ZikirManasi[22];
                    zikirsayisi = ZikirSayisi[22];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 23)
                {
                    zikir = Zikirler[23];
                    zikirManasi = ZikirManasi[23];
                    zikirsayisi = ZikirSayisi[23];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 24)
                {
                    zikir = Zikirler[24];
                    zikirManasi = ZikirManasi[24];
                    zikirsayisi = ZikirSayisi[24];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 25)
                {
                    zikir = Zikirler[25];
                    zikirManasi = ZikirManasi[25];
                    zikirsayisi = ZikirSayisi[25];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 26)
                {
                    zikir = Zikirler[26];
                    zikirManasi = ZikirManasi[26];
                    zikirsayisi = ZikirSayisi[26];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 27)
                {
                    zikir = Zikirler[27];
                    zikirManasi = ZikirManasi[27];
                    zikirsayisi = ZikirSayisi[27];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 28)
                {
                    zikir = Zikirler[28];
                    zikirManasi = ZikirManasi[28];
                    zikirsayisi = ZikirSayisi[28];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 29)
                {
                    zikir = Zikirler[29];
                    zikirManasi = ZikirManasi[29];
                    zikirsayisi = ZikirSayisi[29];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 30)
                {
                    zikir = Zikirler[30];
                    zikirManasi = ZikirManasi[30];
                    zikirsayisi = ZikirSayisi[30];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 31)
                {
                    zikir = Zikirler[31];
                    zikirManasi = ZikirManasi[31];
                    zikirsayisi = ZikirSayisi[31];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 32)
                {
                    zikir = Zikirler[32];
                    zikirManasi = ZikirManasi[32];
                    zikirsayisi = ZikirSayisi[32];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 33)
                {
                    zikir = Zikirler[33];
                    zikirManasi = ZikirManasi[33];
                    zikirsayisi = ZikirSayisi[33];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 34)
                {
                    zikir = Zikirler[34];
                    zikirManasi = ZikirManasi[34];
                    zikirsayisi = ZikirSayisi[34];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 35)
                {
                    zikir = Zikirler[35];
                    zikirManasi = ZikirManasi[35];
                    zikirsayisi = ZikirSayisi[35];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 36)
                {
                    zikir = Zikirler[36];
                    zikirManasi = ZikirManasi[36];
                    zikirsayisi = ZikirSayisi[36];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 37)
                {
                    zikir = Zikirler[37];
                    zikirManasi = ZikirManasi[37];
                    zikirsayisi = ZikirSayisi[37];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 38)
                {
                    zikir = Zikirler[38];
                    zikirManasi = ZikirManasi[38];
                    zikirsayisi = ZikirSayisi[38];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 39)
                {
                    zikir = Zikirler[39];
                    zikirManasi = ZikirManasi[39];
                    zikirsayisi = ZikirSayisi[39];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 40)
                {
                    zikir = Zikirler[40];
                    zikirManasi = ZikirManasi[40];
                    zikirsayisi = ZikirSayisi[40];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 41)
                {
                    zikir = Zikirler[41];
                    zikirManasi = ZikirManasi[41];
                    zikirsayisi = ZikirSayisi[41];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 42)
                {
                    zikir = Zikirler[42];
                    zikirManasi = ZikirManasi[42];
                    zikirsayisi = ZikirSayisi[42];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 43)
                {
                    zikir = Zikirler[43];
                    zikirManasi = ZikirManasi[43];
                    zikirsayisi = ZikirSayisi[43];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 44)
                {
                    zikir = Zikirler[44];
                    zikirManasi = ZikirManasi[44];
                    zikirsayisi = ZikirSayisi[44];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 45)
                {
                    zikir = Zikirler[45];
                    zikirManasi = ZikirManasi[45];
                    zikirsayisi = ZikirSayisi[45];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 46)
                {
                    zikir = Zikirler[46];
                    zikirManasi = ZikirManasi[46];
                    zikirsayisi = ZikirSayisi[46];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 47)
                {
                    zikir = Zikirler[47];
                    zikirManasi = ZikirManasi[47];
                    zikirsayisi = ZikirSayisi[47];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 48)
                {
                    zikir = Zikirler[48];
                    zikirManasi = ZikirManasi[48];
                    zikirsayisi = ZikirSayisi[48];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 49)
                {
                    zikir = Zikirler[49];
                    zikirManasi = ZikirManasi[49];
                    zikirsayisi = ZikirSayisi[49];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 50)
                {
                    zikir = Zikirler[50];
                    zikirManasi = ZikirManasi[50];
                    zikirsayisi = ZikirSayisi[50];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 51)
                {
                    zikir = Zikirler[51];
                    zikirManasi = ZikirManasi[51];
                    zikirsayisi = ZikirSayisi[51];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 52)
                {
                    zikir = Zikirler[52];
                    zikirManasi = ZikirManasi[52];
                    zikirsayisi = ZikirSayisi[52];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 53)
                {
                    zikir = Zikirler[53];
                    zikirManasi = ZikirManasi[53];
                    zikirsayisi = ZikirSayisi[53];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 54)
                {
                    zikir = Zikirler[54];
                    zikirManasi = ZikirManasi[54];
                    zikirsayisi = ZikirSayisi[54];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 55)
                {
                    zikir = Zikirler[55];
                    zikirManasi = ZikirManasi[55];
                    zikirsayisi = ZikirSayisi[55];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 56)
                {
                    zikir = Zikirler[56];
                    zikirManasi = ZikirManasi[56];
                    zikirsayisi = ZikirSayisi[56];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 57)
                {
                    zikir = Zikirler[57];
                    zikirManasi = ZikirManasi[57];
                    zikirsayisi = ZikirSayisi[57];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 58)
                {
                    zikir = Zikirler[58];
                    zikirManasi = ZikirManasi[58];
                    zikirsayisi = ZikirSayisi[58];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 59)
                {
                    zikir = Zikirler[59];
                    zikirManasi = ZikirManasi[59];
                    zikirsayisi = ZikirSayisi[59];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 60)
                {
                    zikir = Zikirler[60];
                    zikirManasi = ZikirManasi[60];
                    zikirsayisi = ZikirSayisi[60];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon ==61 )
                {
                    zikir = Zikirler[61];
                    zikirManasi = ZikirManasi[61];
                    zikirsayisi = ZikirSayisi[61];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 62)
                {
                    zikir = Zikirler[62];
                    zikirManasi = ZikirManasi[62];
                    zikirsayisi = ZikirSayisi[62];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 63)
                {
                    zikir = Zikirler[63];
                    zikirManasi = ZikirManasi[63];
                    zikirsayisi = ZikirSayisi[63];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 64)
                {
                    zikir = Zikirler[64];
                    zikirManasi = ZikirManasi[64];
                    zikirsayisi = ZikirSayisi[64];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 65)
                {
                    zikir = Zikirler[65];
                    zikirManasi = ZikirManasi[65];
                    zikirsayisi = ZikirSayisi[65];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 66)
                {
                    zikir = Zikirler[66];
                    zikirManasi = ZikirManasi[66];
                    zikirsayisi = ZikirSayisi[66];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 67)
                {
                    zikir = Zikirler[67];
                    zikirManasi = ZikirManasi[67];
                    zikirsayisi = ZikirSayisi[67];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 68)
                {
                    zikir = Zikirler[68];
                    zikirManasi = ZikirManasi[68];
                    zikirsayisi = ZikirSayisi[68];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 69)
                {
                    zikir = Zikirler[69];
                    zikirManasi = ZikirManasi[69];
                    zikirsayisi = ZikirSayisi[69];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 70)
                {
                    zikir = Zikirler[70];
                    zikirManasi = ZikirManasi[70];
                    zikirsayisi = ZikirSayisi[70];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 71)
                {
                    zikir = Zikirler[71];
                    zikirManasi = ZikirManasi[71];
                    zikirsayisi = ZikirSayisi[71];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 72)
                {
                    zikir = Zikirler[72];
                    zikirManasi = ZikirManasi[72];
                    zikirsayisi = ZikirSayisi[72];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 73)
                {
                    zikir = Zikirler[73];
                    zikirManasi = ZikirManasi[73];
                    zikirsayisi = ZikirSayisi[73];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 74)
                {
                    zikir = Zikirler[74];
                    zikirManasi = ZikirManasi[74];
                    zikirsayisi = ZikirSayisi[74];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 75)
                {
                    zikir = Zikirler[75];
                    zikirManasi = ZikirManasi[75];
                    zikirsayisi = ZikirSayisi[75];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 76)
                {
                    zikir = Zikirler[76];
                    zikirManasi = ZikirManasi[76];
                    zikirsayisi = ZikirSayisi[76];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 77)
                {
                    zikir = Zikirler[77];
                    zikirManasi = ZikirManasi[77];
                    zikirsayisi = ZikirSayisi[77];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 78)
                {
                    zikir = Zikirler[78];
                    zikirManasi = ZikirManasi[78];
                    zikirsayisi = ZikirSayisi[78];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 79)
                {
                    zikir = Zikirler[79];
                    zikirManasi = ZikirManasi[79];
                    zikirsayisi = ZikirSayisi[79];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 80)
                {
                    zikir = Zikirler[80];
                    zikirManasi = ZikirManasi[80];
                    zikirsayisi = ZikirSayisi[80];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 81)
                {
                    zikir = Zikirler[81];
                    zikirManasi = ZikirManasi[81];
                    zikirsayisi = ZikirSayisi[81];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 82)
                {
                    zikir = Zikirler[82];
                    zikirManasi = ZikirManasi[82];
                    zikirsayisi = ZikirSayisi[82];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 83)
                {
                    zikir = Zikirler[83];
                    zikirManasi = ZikirManasi[83];
                    zikirsayisi = ZikirSayisi[83];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 84)
                {
                    zikir = Zikirler[84];
                    zikirManasi = ZikirManasi[84];
                    zikirsayisi = ZikirSayisi[84];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 85)
                {
                    zikir = Zikirler[85];
                    zikirManasi = ZikirManasi[85];
                    zikirsayisi = ZikirSayisi[85];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 86)
                {
                    zikir = Zikirler[86];
                    zikirManasi = ZikirManasi[86];
                    zikirsayisi = ZikirSayisi[86];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 87)
                {
                    zikir = Zikirler[87];
                    zikirManasi = ZikirManasi[87];
                    zikirsayisi = ZikirSayisi[87];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 88)
                {
                    zikir = Zikirler[88];
                    zikirManasi = ZikirManasi[88];
                    zikirsayisi = ZikirSayisi[88];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 89)
                {
                    zikir = Zikirler[89];
                    zikirManasi = ZikirManasi[89];
                    zikirsayisi = ZikirSayisi[89];
                    secim = true;
                    resim = pozisyon;
                }

                else if(pozisyon == 90)
                {
                    zikir = Zikirler[90];
                    zikirManasi = ZikirManasi[90];
                    zikirsayisi = ZikirSayisi[90];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 91)
                {
                    zikir = Zikirler[91];
                    zikirManasi = ZikirManasi[91];
                    zikirsayisi = ZikirSayisi[91];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 92)
                {
                    zikir = Zikirler[92];
                    zikirManasi = ZikirManasi[92];
                    zikirsayisi = ZikirSayisi[92];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 93)
                {
                    zikir = Zikirler[93];
                    zikirManasi = ZikirManasi[93];
                    zikirsayisi = ZikirSayisi[93];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 94)
                {
                    zikir = Zikirler[94];
                    zikirManasi = ZikirManasi[94];
                    zikirsayisi = ZikirSayisi[94];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 95)
                {
                    zikir = Zikirler[95];
                    zikirManasi = ZikirManasi[95];
                    zikirsayisi = ZikirSayisi[95];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 96)
                {
                    zikir = Zikirler[96];
                    zikirManasi = ZikirManasi[96];
                    zikirsayisi = ZikirSayisi[96];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 97)
                {
                    zikir = Zikirler[97];
                    zikirManasi = ZikirManasi[97];
                    zikirsayisi = ZikirSayisi[97];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 98)
                {
                    zikir = Zikirler[98];
                    zikirManasi = ZikirManasi[98];
                    zikirsayisi = ZikirSayisi[98];
                    secim = true;
                    resim = pozisyon;
                }
                else if(pozisyon == 99)
                {
                    zikir = Zikirler[99];
                    zikirManasi = ZikirManasi[99];
                    zikirsayisi = ZikirSayisi[99];
                    secim = true;
                    resim = pozisyon;
                }

                //*******intersteller ad başlar***********
                if (mInterstitialAd.isLoaded() && reklamgoster) {
                    mInterstitialAd.show();
                }

                else {
                    //list view işlemlerini burada yapıyoruz.
                    Intent i = new Intent(ZikirSecimi.this, anasayfa_yeni.class);
                    i.putExtra("mesaj", zikir);
                    i.putExtra("mana", zikirManasi);
                    i.putExtra("zikirsayisi", zikirsayisi);
                    i.putExtra("secim", secim);
                    i.putExtra("resim", resim);
                    i.putExtra("resim_gizle",image_gizle);
                    finish();
                    startActivity(i);
                }

                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Code to be executed when the interstitial ad is closed.
                        //list view işlemlerini burada yapıyoruz.
                        Intent i = new Intent(ZikirSecimi.this, anasayfa_yeni.class);
                        i.putExtra("mesaj", zikir);
                        i.putExtra("mana", zikirManasi);
                        i.putExtra("zikirsayisi", zikirsayisi);
                        i.putExtra("secim", secim);
                        i.putExtra("resim", resim);
                        i.putExtra("resim_gizle",image_gizle);
                        finish();
                        startActivity(i);

                    }
                });
                //***************************

            }
        });
    }
}
