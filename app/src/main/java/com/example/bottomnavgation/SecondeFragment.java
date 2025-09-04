package com.example.bottomnavgation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavgation.databinding.FragmentFirstBinding;
import com.example.bottomnavgation.databinding.FragmentSecondeBinding;

public class SecondeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";

     private String Name;

    public SecondeFragment() {
     }

     public static SecondeFragment newInstance(String param1) {
        SecondeFragment fragment = new SecondeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
         fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Name = getArguments().getString(ARG_PARAM1);
         }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSecondeBinding binding = FragmentSecondeBinding.inflate(inflater,container ,false);
        if (Name!=null)
            binding.tv2.setText(Name);

        return binding.getRoot();    }
}