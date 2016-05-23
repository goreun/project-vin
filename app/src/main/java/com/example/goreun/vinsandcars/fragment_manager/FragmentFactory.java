package com.example.goreun.vinsandcars.fragment_manager;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

import com.example.goreun.vinsandcars.R;
import com.example.goreun.vinsandcars.fragments.CarsFragment;
import com.example.goreun.vinsandcars.fragments.ChatFragment;
import com.example.goreun.vinsandcars.fragments.ContactsFragment;
import com.example.goreun.vinsandcars.fragments.MainMenuFragment;
import com.example.goreun.vinsandcars.fragments.ProfileFragment;
import com.example.goreun.vinsandcars.fragments.RecentChatsFragment;
import com.example.goreun.vinsandcars.fragments.SearchFragment;

public class FragmentFactory{

    private static FragmentFactory ourInstance = new FragmentFactory();

    public static FragmentFactory getInstance() {
        return ourInstance;
    }

    private   RecentChatsFragment recentChatsFragment;
    private   ContactsFragment  contactsFragment;
    private   CarsFragment carsFragment;
    private   ProfileFragment profileFragment;
    private   SearchFragment searchFragment;
    private   ChatFragment chatFragment;
    private   MainMenuFragment mainMenuFragment;

    private  android.app.FragmentManager  fragmentManager;

/*    public FragmentFactory(FragmentManager fragmentManager){


    }*/

    public void setFragmentManager(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;

    }


    private FragmentFactory(){
        recentChatsFragment = new RecentChatsFragment();
        contactsFragment = new ContactsFragment();
        carsFragment= new CarsFragment();
        profileFragment =  new ProfileFragment();
        searchFragment = new SearchFragment();
        chatFragment = new ChatFragment();
        mainMenuFragment = new MainMenuFragment();

        Log.v("Fragment thread Id", String.valueOf(Thread.activeCount()));
    }


    //Create method replace fragment
    public void replaceFragment( int view, int fragmentId){
        Fragment fragment=null;

        switch (fragmentId){
            case 0:
                fragment =  recentChatsFragment;
                break;
            case 1:
                fragment = contactsFragment;
                break;
            case 2:
                fragment = carsFragment;
                break;
            case 3:
                fragment = profileFragment;
                break;
            case 4:
                fragment = searchFragment;
                break;
            default:
                fragment = mainMenuFragment;
                break;
        }


        commit(view, fragment);
    }

    public void openChatFragment(int userId){
        commit(R.id.main_active ,chatFragment);
    }

    private void commit(int fragmentId, Fragment fragment ){
        if (fragment != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(fragmentId, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
