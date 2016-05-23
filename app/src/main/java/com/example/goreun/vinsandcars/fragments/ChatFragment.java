package com.example.goreun.vinsandcars.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.goreun.vinsandcars.R;
import com.example.goreun.vinsandcars.fragment_manager.FragmentFactory;


public class ChatFragment extends Fragment implements View.OnClickListener {

    private FragmentFactory fragmentFactory;

    public ChatFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.chat, container, false);
        fragmentFactory = FragmentFactory.getInstance();
        ImageView imageView = (ImageView) rootView.findViewById(R.id.back_arrow);
        imageView.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        fragmentFactory.replaceFragment(R.id.ll_main, 0);
        fragmentFactory.replaceFragment(R.id.main_active,5);
    }
}



