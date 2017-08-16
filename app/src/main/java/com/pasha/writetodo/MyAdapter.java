package com.pasha.writetodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends BaseAdapter {

    Context context;
    List<Item> items;

    public MyAdapter(Context context){

        this.context = context;
        readItem();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.indexOf(position);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View viewInflated = LayoutInflater.from(context).inflate(R.layout.simple_item, null);
        //set our inflated view behavior

        final TextView txtTaskName = (TextView) viewInflated.findViewById(R.id.txtName);
        final TextView txtTaskPhone = (TextView)viewInflated.findViewById(R.id.txtSomething);


        txtTaskName.setText(items.get(i)._name);
        txtTaskPhone.setText(items.get(i)._something);

        return viewInflated;
    }

    public void readItem(){

        MyData db = new MyData(context);

        items = new ArrayList<>();

        List<Item> item = db.getAllItems();
        for(Item oneItem : item){

            items.add(new Item(oneItem.getID(), oneItem.getName(), oneItem.getSomething()));

        }


    }

}


