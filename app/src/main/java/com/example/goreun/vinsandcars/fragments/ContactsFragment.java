package com.example.goreun.vinsandcars.fragments;

import android.app.Fragment;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.goreun.vinsandcars.R;
import com.example.goreun.vinsandcars.adapter.ContactsSlidingMenuAdapter;
import com.example.goreun.vinsandcars.model.ItemContactsMenu;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {

    private List<ItemContactsMenu> listSliding;
    private ContactsSlidingMenuAdapter adapter;
    private ListView contactsListViewSliding;
    private static final String TAG = "MyActivity";

    public ContactsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.contacts, container, false);
        //init Component
        contactsListViewSliding = (ListView) rootView.findViewById(R.id.lv_contacts_menu);
        listSliding = new ArrayList<>();

        //Add item for sliding list
        listSliding.add(new ItemContactsMenu(R.drawable.artur, "Ashot Petrosyan"));
        listSliding.add(new ItemContactsMenu(R.drawable.artur, "Artur Tsghunyan"));
        listSliding.add(new ItemContactsMenu(R.drawable.goreun, "Goreun Berberian"));
        listSliding.add(new ItemContactsMenu(R.drawable.artur, "Ashot Petrosyan"));
        listSliding.add(new ItemContactsMenu(R.drawable.artur, "Artur Tsghunyan"));
        listSliding.add(new ItemContactsMenu(R.drawable.goreun, "Goreun Berberian"));
        listSliding.add(new ItemContactsMenu(R.drawable.artur, "Ashot Petrosyan"));
        listSliding.add(new ItemContactsMenu(R.drawable.artur, "Artur Tsghunyan"));
        listSliding.add(new ItemContactsMenu(R.drawable.goreun, "Goreun Berberian"));

        adapter = new ContactsSlidingMenuAdapter(container.getContext(), listSliding);
        contactsListViewSliding.setAdapter(adapter);

        contactsListViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Log.v(TAG,String.valueOf(position));
            }
        });

        return rootView;
    }
}
