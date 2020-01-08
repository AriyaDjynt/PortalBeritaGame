package com.hendrysa.portalberitagame.ui.platform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.ui.genre.Action;
import com.hendrysa.portalberitagame.ui.genre.Adventure;
import com.hendrysa.portalberitagame.ui.genre.Fighting;
import com.hendrysa.portalberitagame.ui.genre.Shooting;
import com.hendrysa.portalberitagame.ui.genre.Simulation;
import com.hendrysa.portalberitagame.ui.genre.Strategy;

public class Xbox extends AppCompatActivity {

    String platform = "Xbox";
    TextView txt_platform;
    ImageView btn_action, btn_simulation, btn_strategy, btn_adventure, btn_shooting, btn_fighting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);

        txt_platform = findViewById(R.id.txt_platform);
        txt_platform.setText(platform);

        btn_action = findViewById(R.id.btn_action);
        btn_adventure = findViewById(R.id.btn_adventure);
        btn_simulation = findViewById(R.id.btn_simulation);
        btn_strategy = findViewById(R.id.btn_strategy);
        btn_shooting = findViewById(R.id.btn_shooting);
        btn_fighting = findViewById(R.id.btn_fighting);

        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Action.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_adventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Adventure.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Strategy.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Shooting.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_simulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Simulation.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
        btn_fighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Fighting.class);
                i.putExtra("platform", platform);
                startActivity(i);
            }
        });
    }
}
