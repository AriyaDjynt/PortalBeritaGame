package com.hendrysa.portalberitagame.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.ui.webview.Webview;

public class Admin extends AppCompatActivity {

    Button btn_insert, btn_update;
    String url = "http://hendrysa.ga/project/uasandroid/";
    String insert_url = url + "insert.php", update_url = url + "update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btn_insert = findViewById(R.id.btn_insertdata);
        btn_update = findViewById(R.id.btn_updatedata);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Webview.class);
                i.putExtra("link",insert_url);
                startActivity(i);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Webview.class);
                i.putExtra("link", update_url);
                startActivity(i);
            }
        });
    }
}
