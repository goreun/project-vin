package com.example.goreun.vinsandcars.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.goreun.vinsandcars.R;
import com.example.goreun.vinsandcars.adapter.ChatListAdapter;
import com.example.goreun.vinsandcars.fragment_manager.FragmentFactory;
import com.example.goreun.vinsandcars.model.ChatMessage;

import java.util.ArrayList;
import java.util.List;


public class ChatFragment extends Fragment implements View.OnKeyListener, View.OnClickListener  {

    private FragmentFactory fragmentFactory;

    private ChatListAdapter chatListAdapter;
    private ListView listView;
    private EditText chatText;
    private Button btnSend;
    private  View rootView;
     Intent in;

    public ChatFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.chat, container, false);
        fragmentFactory = FragmentFactory.getInstance();

        ImageView imageView = (ImageView) rootView.findViewById(R.id.back_arrow);
        imageView.setOnClickListener(this);




        // A history list from Database or phone cache
        List<ChatMessage> chatMessage = new ArrayList<ChatMessage>();

        btnSend  = (Button) rootView.findViewById(R.id.btn_send);
        listView = (ListView) rootView.findViewById(R.id.lv_chat);
        chatListAdapter = new ChatListAdapter(container.getContext(),chatMessage );
        chatText = (EditText)rootView.findViewById(R.id.chat_text);




        //Register an observer that is called when changes happen to the data used by this adapter
        chatListAdapter.registerDataSetObserver(new DataSetObserver() {

            @Override
            public void onChanged() {
                super.onChanged();

                listView.setSelection(chatListAdapter.getCount() - 1);
                listView.scrollTo(0, listView.getHeight());
            }
        });

        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatListAdapter);

        btnSend.setOnClickListener(this);
        chatText.setOnKeyListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        if(v == rootView.findViewById(R.id.back_arrow)) {
            fragmentFactory.replaceFragment(R.id.main_active,5);
        }else if(v == rootView.findViewById(R.id.btn_send)){
            sendChatMessage();
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
           if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
            return sendChatMessage();
        }
        return false;
    }


private boolean left = true;

    private boolean sendChatMessage() {
        chatListAdapter.add(new ChatMessage(left, chatText.getText().toString()));
        chatText.setText("");
        left = !left;

        return true;
    }


}



