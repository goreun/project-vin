package com.example.goreun.vinsandcars.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goreun.vinsandcars.R;
import com.example.goreun.vinsandcars.model.ItemContactsMenu;

import java.util.List;


public class ContactsSlidingMenuAdapter extends BaseAdapter
{
    private Context context;
    private List<ItemContactsMenu> lstItem;

    public ContactsSlidingMenuAdapter(Context context, List<ItemContactsMenu> lstItem) {
        this.context = context;
        this.lstItem = lstItem;
    }

    @Override
    public int getCount() {
        return lstItem.size();
    }

    @Override
    public Object getItem(int position) {
        return lstItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.item_contact_menu, null);

        ImageView img = (ImageView)v.findViewById(R.id.item_img);
        TextView tv = (TextView)v.findViewById(R.id.item_title);

        ItemContactsMenu item = lstItem.get(position);
        img.setImageResource(item.getImgid());
        tv.setText(item.getTitle());

        return v;
    }
}
