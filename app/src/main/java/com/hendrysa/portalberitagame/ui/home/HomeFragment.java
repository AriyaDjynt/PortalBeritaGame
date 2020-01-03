package com.hendrysa.portalberitagame.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.hendrysa.portalberitagame.R;
import com.hendrysa.portalberitagame.ui.platform.Nintendo;
import com.hendrysa.portalberitagame.ui.platform.Pc;
import com.hendrysa.portalberitagame.ui.platform.Playstation;
import com.hendrysa.portalberitagame.ui.platform.Xbox;

public class HomeFragment extends Fragment {

    ImageView btn_playstation, btn_pc, btn_nintendo, btn_xbox;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        btn_nintendo = view.findViewById(R.id.btn_nintendo);
        btn_pc = view.findViewById(R.id.btn_pc);
        btn_xbox = view.findViewById(R.id.btn_xbox);
        btn_playstation = view.findViewById(R.id.btn_playstation);

        btn_playstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Playstation.class);
                startActivity(i);
            }
        });
        btn_nintendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Nintendo.class);
                startActivity(i);
            }
        });
        btn_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Pc.class);
                startActivity(i);
            }
        });
        btn_xbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Xbox.class);
                startActivity(i);
            }
        });
    }
}