package com.hendrysa.portalberitagame.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationView;
import com.hendrysa.portalberitagame.MainActivity;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.Session;

public class LogoutFragment extends Fragment {

    Session session;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return null;
    }

    public void onResume()
    {
        super.onResume();
        session = new Session(getActivity());
        session.logout();
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
        getActivity().finish();
    }

}
