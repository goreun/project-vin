package com.example.goreun.vinsandcars.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.goreun.vinsandcars.R;
import com.example.goreun.vinsandcars.model.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class ChatListAdapter extends BaseAdapter {

    private TextView chatText;
    private Context context;
    private List<ChatMessage> messageList = new ArrayList<ChatMessage>();
    private LinearLayout layout;



    public ChatListAdapter(Context context, List<ChatMessage> lstItem ) {
        messageList = lstItem;
        this.context = context;

    }

    public void add( ChatMessage chatMessage){
        messageList.add(chatMessage);
    }

    @Override
    public int getCount() {
        return this.messageList.size();
    }

    @Override
    public Object getItem(int index){
        return this.messageList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = View.inflate(context, R.layout.chat_message, null);


        layout = (LinearLayout)v.findViewById(R.id.Message);

        ChatMessage chatMessage = messageList.get(position);
        chatText = (TextView)v.findViewById(R.id.message_content);


        chatText.setText(chatMessage.getMessage());
        chatText.setBackgroundResource(chatMessage.isLeft() ? R.drawable.chat_bubble_left:R.drawable.chat_bubble_right);
        layout.setGravity(chatMessage.isLeft() ? Gravity.LEFT:Gravity.RIGHT);

        return v;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte){
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

}
