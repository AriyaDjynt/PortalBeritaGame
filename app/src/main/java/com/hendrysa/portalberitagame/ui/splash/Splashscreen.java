package com.hendrysa.portalberitagame.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hendrysa.portalberitagame.MainActivity;
import com.hendrysa.portalberitagame.R;

public class Splashscreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread t = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(1000);
                }
                catch(Exception e){}
                finally
                {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        };
        t.start();
    }
}
