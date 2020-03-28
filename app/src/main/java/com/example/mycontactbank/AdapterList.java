package com.example.mycontactbank;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<ClassContact> {

    Context context;
    int layaoutResourceID;

    ArrayList<ClassContact> data;


    static class ContactoHolder {
        TextView name;
        TextView account_number;
        TextView account_type;
        TextView balance;
    }

    public  AdapterList(Context context, int layaoutResourceID, ArrayList<ClassContact> data) {
        super(context,layaoutResourceID,data);

        this.context = context;
        this.layaoutResourceID = layaoutResourceID;
        this.data = data;
    }

    public View getView(int position,View convertView, ViewGroup parent) {

        View row = convertView;

        ContactoHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layaoutResourceID, parent,false);
            holder = new ContactoHolder();
            holder.name = (TextView) row.findViewById(R.id.name);
            holder.account_number = (TextView) row.findViewById(R.id.account_number);
            holder.account_type = (TextView) row.findViewById(R.id.account_type);
            holder.balance = (TextView) row.findViewById(R.id.balance);

            row.setTag(holder);


        }else {
            holder = (ContactoHolder)row.getTag();
        }

        ClassContact contact = data.get(position);
        holder.name.setText(contact.getName());
        holder.account_number.setText(contact.getAccaount_number());
        holder.account_type.setText(contact.getAccount_type());
        holder.balance.setText(contact.getBalance());


        return row;
    }

}

