package com.example.mamad.fara2form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {

    List<MyContact> contacts;
    ListView listView;
    ContanctAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
        listView = (ListView) findViewById(R.id.listView2);
        contacts = new ArrayList<>();
        prepareData();
        refreshDisplay();
    }

    private void prepareData() {
        addFakeContact(2);
        contacts.add(new MyContact("amir kabiri", "09128165540",R.drawable.profile1));
        contacts.add(new MyContact("ali dostMohammadi","09385535540",R.drawable.profile2));
        contacts.add(new MyContact("hasan tir", "09195043324",R.drawable.profile3));
        addFakeContact(5);
        contacts.add(new MyContact("parham gandom", "09123698520",R.drawable.profile4));
        contacts.add(new MyContact("saeed talebi", "09021302255",R.drawable.profile5));
        contacts.add(new MyContact("mamad farrokh", "09021303331",R.drawable.profile6));
       addFakeContact(5);
        contacts.add(new MyContact("ali sarabi", "09371425896",R.drawable.profile7));
       addFakeContact(2);
        contacts.add(new MyContact("leyla akbari", "0936558877",R.drawable.profile8));
        contacts.add(new MyContact("nada keyvani", "09124568974",R.drawable.profile9));
        contacts.add(new MyContact("nadia farhadi", "09123698521",R.drawable.profile10));


    }
    private void addFakeContact(int n){
        for (int i=0 ; i<n ; i++){
            contacts.add(new MyContact("fake contact #" + i, "09123654789"+ i , 0));
        }
    }

    private void refreshDisplay() {
        adapter = new ContanctAdapter(this, contacts);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
        }
        return super.onOptionsItemSelected(item);
    }
}
