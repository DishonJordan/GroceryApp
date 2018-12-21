package com.example.dishon.grocerymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.CheckBox;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    ArrayList<GroceryItem> groceryItems;

    Context myContext;

    public CustomListAdapter(Context context, ArrayList<GroceryItem> list) {
        myContext = context;
        groceryItems = list;
    }

    @Override
    public int getCount() {
        return groceryItems.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infl = LayoutInflater.from(myContext);
        View custom_view = infl.inflate(R.layout.list_item,parent,false);

        TextView name = (TextView)custom_view.findViewById(R.id.item_name);
        TextView quantity = (TextView)custom_view.findViewById(R.id.item_quantity);
        CheckBox box = (CheckBox)custom_view.findViewById(R.id.item_selected);

        name.setText(groceryItems.get(position).getName());
        quantity.setText(String.valueOf(groceryItems.get(position).getQuantity()));

        return custom_view;

    }



}
