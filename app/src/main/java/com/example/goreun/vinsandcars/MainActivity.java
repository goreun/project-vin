package com.example.goreun.vinsandcars;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.goreun.vinsandcars.adapter.ContactsSlidingMenuAdapter;
import com.example.goreun.vinsandcars.fragments.CarsFragment;
import com.example.goreun.vinsandcars.fragments.ContactsFragment;
import com.example.goreun.vinsandcars.fragments.ProfileFragment;
import com.example.goreun.vinsandcars.fragments.RecentChatsFragment;
import com.example.goreun.vinsandcars.fragments.SearchFragment;
import com.example.goreun.vinsandcars.model.ItemContactsMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MyActivity";

    //to be inserted into proper function
    private List<ItemContactsMenu> listSliding;
    private ContactsSlidingMenuAdapter adapter;
    private ListView contactsListViewSliding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);

        ImageView recent = (ImageView) this.findViewById(R.id.recent_chat);
        ImageView contacts = (ImageView) this.findViewById(R.id.contacts);
        ImageView cars = (ImageView) this.findViewById(R.id.cars);
        ImageView profile = (ImageView) this.findViewById(R.id.profile);
        ImageView search = (ImageView) this.findViewById(R.id.search);

        recent.setOnClickListener(this);
        contacts.setOnClickListener(this);
        cars.setOnClickListener(this);
        profile.setOnClickListener(this);
        search.setOnClickListener(this);




        InitalizeContactList();


    }

    //Handle images click events
        @Override
        public void onClick(View view) {

            if (view == findViewById(R.id.recent_chat)) {
                replaceFragment(0);
                Log.v(TAG, "Recent chats");
            }else if (view == findViewById(R.id.contacts)) {
                replaceFragment(1);
                Log.v(TAG, "Contacts");
            }else if (view == findViewById(R.id.cars)) {
                replaceFragment(2);
                Log.v(TAG, "Cars");
            }else if (view == findViewById(R.id.profile)) {
                replaceFragment(3);
                Log.v(TAG, "Profile");
            }else if (view == findViewById(R.id.search)) {
                replaceFragment(4);
                Log.v(TAG, "Search");
            }
        }

    //Creating the contact list
    private void InitalizeContactList(){

    }

    //Create method replace fragment
    private void replaceFragment(int pos){
        Fragment fragment=null;

        switch (pos){
            case 0:
                fragment = new RecentChatsFragment();
                break;
            case 1:
                fragment = new ContactsFragment();
                break;
            case 2:
                fragment = new CarsFragment();
                break;
            case 3:
                fragment = new ProfileFragment();
                break;
            case 4:
                fragment = new SearchFragment();
                break;
            default:
                fragment = new ProfileFragment();
                break;
        }

        if (fragment != null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.ll_main, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}
