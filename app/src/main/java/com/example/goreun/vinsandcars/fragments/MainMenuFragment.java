package com.example.goreun.vinsandcars.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.goreun.vinsandcars.R;
import com.example.goreun.vinsandcars.fragment_manager.FragmentFactory;

public class MainMenuFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "Main Fragment";

    private View rootView;

    private FragmentFactory fragmentFactory;

    public MainMenuFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
         rootView = inflater.inflate(R.layout.main_menu, container, false);

        fragmentFactory  = FragmentFactory.getInstance();
        fragmentFactory.replaceFragment(R.id.ll_main,0);

        ImageView recent =   (ImageView)   rootView.findViewById(R.id.recent_chat);
        ImageView contacts = (ImageView) rootView.findViewById(R.id.contacts);
        ImageView cars =     (ImageView)     rootView.findViewById(R.id.cars);
        ImageView profile =  (ImageView)  rootView.findViewById(R.id.profile);
        ImageView search =   (ImageView)   rootView.findViewById(R.id.search);

        recent.setOnClickListener( this);
        contacts.setOnClickListener( this);
        cars.setOnClickListener(this);
        profile.setOnClickListener(this);
        search.setOnClickListener(this);
        return rootView;
    }

    //Handle images click events
    @Override
    public void onClick(View view) {

        if (view == rootView.findViewById(R.id.recent_chat)) {
            fragmentFactory.replaceFragment(R.id.ll_main , 0);
            Log.v(TAG, "Recent chats");
        }else if (view == rootView.findViewById(R.id.contacts)) {
            fragmentFactory.replaceFragment(R.id.ll_main ,1);
            Log.v(TAG, "Contacts");
        }else if (view == rootView.findViewById(R.id.cars)) {
            fragmentFactory.replaceFragment(R.id.ll_main ,2);
            Log.v(TAG, "Cars");
        }else if (view == rootView.findViewById(R.id.profile)) {
            fragmentFactory.replaceFragment(R.id.ll_main ,3);
            Log.v(TAG, "Profile");
        }else if (view == rootView.findViewById(R.id.search)) {
            fragmentFactory.replaceFragment(R.id.ll_main ,4);
            Log.v(TAG, "Search");
        }
    }


}
