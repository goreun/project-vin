package com.example.goreun.vinsandcars.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goreun.vinsandcars.R;

public class SearchFragment extends Fragment {

    public SearchFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.search, container, false);

        return rootView;
    }
}
