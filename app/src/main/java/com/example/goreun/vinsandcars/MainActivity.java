package com.example.goreun.vinsandcars;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.goreun.vinsandcars.fragment_manager.FragmentFactory;

public class MainActivity extends AppCompatActivity  {


    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentFactory fragmentFactory = FragmentFactory.getInstance();
        fragmentFactory.setFragmentManager(getFragmentManager());

        fragmentFactory.replaceFragment(R.id.main_active,5);


    }



}
