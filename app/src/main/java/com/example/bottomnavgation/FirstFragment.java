package com.example.bottomnavgation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavgation.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

     private static final String ARGName = "param1";

     private String Name;

    public FirstFragment() {
     }


     public static FirstFragment newInstance(String param1) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new
                Bundle();
        args.putString(ARGName, param1);
         fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Name = getArguments().getString(ARGName);
         }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentFirstBinding binding=FragmentFirstBinding.inflate(inflater,container ,false);
        if (Name!=null)
            binding.tv.setText(Name);

        return binding.getRoot();
    }
}