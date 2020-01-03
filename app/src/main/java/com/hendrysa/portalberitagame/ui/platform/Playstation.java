package com.hendrysa.portalberitagame.ui.platform;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hendrysa.portalberitagame.R;

public class Playstation extends AppCompatActivity {

    TextView txt_platform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);

        txt_platform = findViewById(R.id.txt_platform);
        txt_platform.setText("Playstation");
    }


}