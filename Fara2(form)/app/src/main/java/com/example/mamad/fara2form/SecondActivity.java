package com.example.mamad.fara2form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv= (TextView) findViewById(R.id.tv);
        Bundle extras= getIntent().getExtras();
        if (extras!=null){
            String name = "";
            String phone= "";
            String email= "";
            if (extras.containsKey("name")){
                name=extras.getString("name");
            }
            if (extras.containsKey("phone")){
                phone=extras.getString("phone");
            }
            if (extras.containsKey("email")){
                email=extras.getString("email");
            }
            tv.setText("Name : " + name + "\n");
            tv.append("Phone : " + phone+ "\n");
            tv.append("email : " + email+ "\n");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem itemOk = menu.add("Ok");
        itemOk.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS); // show as action in top
        itemOk.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {   // listener for menu option
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent intent= new Intent(SecondActivity.this , MainActivity.class);
                intent.putExtra("message","it's Ok"); // sending information along the results
                setResult(RESULT_OK, intent); // sending result and data along intent
                finish();
                return false;
                // another way dont create intent at all
               /* setResult(RESULT_OK); // sending result and data along intent
                finish();
                return false;*/
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
