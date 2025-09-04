package com.example.bottomnavgation;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bottomnavgation.databinding.FragmentProgramingBinding;

public class ProgramingFragment extends Fragment {

    private static final String ARG_NAME = "param1";
    private String name;

    public ProgramingFragment() { }

    public static ProgramingFragment newInstance(String param1) {
        ProgramingFragment fragment = new ProgramingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentProgramingBinding binding = FragmentProgramingBinding.inflate(inflater, container, false);
        if (name != null) {
            binding.tv.setText(name);
        }
        return binding.getRoot();
    }
}
