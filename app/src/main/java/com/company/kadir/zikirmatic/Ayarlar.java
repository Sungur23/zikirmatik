package com.company.kadir.zikirmatic;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;




/**
 * Created by kadir on 12.02.2018.
 */

public class Ayarlar extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.ayarlar);
        getListView().setBackgroundColor(Color.rgb(238, 238, 238));
    }
}
