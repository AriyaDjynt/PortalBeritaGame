package com.hendrysa.portalberitagame.ui.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.hendrysa.portalberitagame.JSONParser;
import com.hendrysa.portalberitagame.MainActivity;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.Session;
import com.hendrysa.portalberitagame.ui.register.Register;

public class LoginFragment extends Fragment {

    TextView btn_register;
    EditText field_username, field_password;
    ImageView btn_login;
    ProgressBar progress;
    String url = "http://hendrysa.ga/project/uasandroid/login.php";
    private String username, password;
    private Session session;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_register = view.findViewById(R.id.btn_register);
        btn_login = view.findViewById(R.id.btn_login);
        field_username = view.findViewById(R.id.field_username);
        field_password = view.findViewById(R.id.field_password);
        progress = view.findViewById(R.id.progressbar);
        progress.setVisibility(View.GONE);
        session = new Session(getActivity());

        btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent Register = new Intent(getContext(), Register.class);
                startActivity(Register);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                username = field_username.getText().toString();
                password = field_password.getText().toString();
                if(username.equals("") || password.equals(""))
                {
                    toast("Username atau Password tidak boleh kosong");
                }
                else
                    {
                        new ValidateLogin().execute();
                    }
            }
        });
    }
    class ValidateLogin extends AsyncTask<String ,String ,String >
    {
        JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> data = new ArrayList<>();
            data.add(new BasicNameValuePair("username", username));
            data.add(new BasicNameValuePair("password", password));
            JSONObject json = jsonParser.makeHttpRequest(url, "POST", data);

            try
            {
                int success = json.getInt("success");
                final String uname = json.getString("username");
                final String u_id = json.getString("user_id");
                if(success == 1)
                {
                    getActivity().runOnUiThread(new Runnable()
                    {
                       @Override
                       public void run()
                       {
                           toast("Login Berhasil");
                           session.setLogin(uname, u_id);
                           Intent i = new Intent(getActivity(), MainActivity.class);
                           getActivity().finish();
                           startActivity(i);
                       }
                    });
                }
                else
                    {
                        getActivity().runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                toast("Username atau Password Salah");
                            }
                        });
                    }
            }
            catch(Exception e)
            {
                Log.d("hendrysa", e.getMessage());
                getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        toast("Gagal Login");
                    }
                });
            }
            return null;
        }

        protected void onPostExecute(String e)
        {
            progress.setVisibility(View.GONE);
        }
    }

    public void toast(String msg)
    {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}