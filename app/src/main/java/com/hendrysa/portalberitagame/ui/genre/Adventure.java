package com.hendrysa.portalberitagame.ui.genre;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.hendrysa.portalberitagame.R;

public class Adventure extends AppCompatActivity {
    String platform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        platform = getIntent().getStringExtra("platform");
        Log.d("hendrysa", platform);
    }
}
