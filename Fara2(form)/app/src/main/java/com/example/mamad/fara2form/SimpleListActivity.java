package com.example.mamad.fara2form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleListActivity extends AppCompatActivity  {

        // listview has 3 part
    ListView listView;      // part 1 :  the object that we want to show
    List <String> items;    // part 2 :  the listview that we want show
    ArrayAdapter<String> adapter;       // part 3 :  how we want to show each object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
        items = new ArrayList<>();

        prepareData();
        listView = (ListView) findViewById(R.id.listView);
        refreshDisplay();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
        }
        return super.onOptionsItemSelected(item);
    }

    private void prepareData(){

        items.add("Tehran");

        items.add("Esfehan");

        items.add("Qom");

        items.add("Ilam");

        items.add("Mashhad");

        items.add("Mazandaran");

        items.add("Kerman");

        items.add("Sanandaj");

        items.add("Lorestan");

        items.add("Khozestan");

        items.add("Tabriz");

        items.add("Damghan");

        items.add("Boshehr");

        items.add("Hamedan");

    }

    private void refreshDisplay() {
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);   // we should set adapter for each listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListActivity.this, items.get(position) ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                items.add("new item");
                adapter.notifyDataSetChanged(); // ******** informing the adapter of changing the data set
                return false;
            }
        });
        menu.add("Remove Item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (items.isEmpty())
                    return false;
                items.remove(items.size() -1);
                adapter.notifyDataSetChanged(); // ******** informing the adapter of changing the data set
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
