package com.example.mamad.fara2form;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MAMAD on 5/18/2018.
 */


public class ContanctAdapter extends ArrayAdapter {

    private List<MyContact> contacts;
    public ContanctAdapter(@NonNull Context context, @NonNull List<MyContact> contacts) {
        super(context, R.layout.mycontact_list, contacts);
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MyContact contact = contacts.get(position);
        ViewHolder holder;
        if (convertView ==null){
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.mycontact_list,parent,false);
            holder = new ViewHolder();
            holder.img_profile = (ImageView) convertView.findViewById(R.id.contact_pimg);
            holder.tv_phone = (TextView) convertView.findViewById(R.id.contact_phn);
            holder.tv_name = (TextView) convertView.findViewById(R.id.contact_name);
            holder.icsms = (ImageView) convertView.findViewById(R.id.ic_sms);
            holder.iccall = (ImageView) convertView.findViewById(R.id.ic_call);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fill(contact);
        return convertView;
    }
    private class ViewHolder implements View.OnClickListener {
        public  ImageView img_profile;
        public  TextView tv_name;
        public  TextView tv_phone;
        public  ImageView icsms,iccall;

        public void  fill (MyContact contact){

            img_profile.setImageResource(contact.getId());
            tv_name.setText(contact.getName());
            tv_phone.setText(contact.getPhoneNumber());
            iccall.setTag(contact.getPhoneNumber());
            icsms.setTag(contact.getPhoneNumber());
            icsms.setOnClickListener(this);
            iccall.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            String phone = (String) v.getTag();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (v.equals(iccall)){
                intent.setData(Uri.parse("tel:"+ phone));
                getContext().startActivity(intent);
            }else if (v.equals(icsms)){
                intent.setData(Uri.parse("sms:"+ phone));
                getContext().startActivity(intent);

            }
        }
    }
}