package com.hendrysa.portalberitagame.ui.register;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import com.hendrysa.portalberitagame.JSONParser;
import com.hendrysa.portalberitagame.R;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    ImageView btn_register;
    EditText field_username, field_password;
    ProgressBar progress;
    String url = "http://hendrysa.ga:443/project/uasandroid/register.php";
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        field_username = findViewById(R.id.field_username);
        field_password = findViewById(R.id.field_password);
        progress = findViewById(R.id.progressbar);
        progress.setVisibility(View.GONE);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = field_username.getText().toString();
                password = field_password.getText().toString();

                if(username.isEmpty() || password.isEmpty())
                {
                    toast("Username atau Password tidak boleh kosong!");
                }
                else
                    {
                        new Reg().execute();
                    }
            }
        });
    }

    class Reg extends AsyncTask<String ,String ,String>
    {
        private Activity activity;

        JSONParser jsonParser = new JSONParser();
        int success;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> data = new ArrayList<>();
            data.add(new BasicNameValuePair("username", username));
            data.add(new BasicNameValuePair("password", password));

            try
            {
                JSONObject json = jsonParser.makeHttpRequest(url, "POST", data);
                success = json.getInt("success");
            }
            catch(Exception e)
            {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        toast("Registrasi gagal");
                    }
                });

            }
            return null;
        }

        protected void onPostExecute(String e)
        {
            if(success == 1)
            {
                toast("Registrasi berhasil");
                finish();
            }
            else
            {
                toast("Registrasi gagal");
            }
            progress.setVisibility(View.GONE);
        }
    }

    public void toast(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}