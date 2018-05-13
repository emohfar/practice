package com.example.mamad.fara1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2;
    Button button;
    Button button2;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "سلام دیوس", Toast.LENGTH_SHORT).show();
        tv= (TextView) findViewById(R.id.tv);
        tv.setText(new Date().toString());
        tv.setTextColor(Color.rgb(255,25,255));
        tv2= (TextView) findViewById(R.id.tv2);
        et = (EditText) findViewById(R.id.et);
        button= (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RandomTextColor2();
                button2.setText("Clicked");
            }
        });
        button2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                button2.setText("Long Clicked");
                return true; // If it is not true every thing that is done for standard will be applied on long click(short term it is long click and standard click at once)
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class); //change page activity
                startActivity(intent);
                return true;
            }
        });

    }


    public void buttonOnClick(View v){
        if(v.getId() == R.id.button){
            RandomTextColor();
            String text= et.getText().toString().trim();
            tv2.setText(text);
              }

    }

   private void RandomTextColor() {     //-->Refactor/Extract/Method
        Random random= new Random();
        tv.setTextColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
    }

    private void RandomTextColor2() {
        Random random= new Random();
        tv2.setTextColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "سلام کونی", Toast.LENGTH_SHORT).show();
    }     // diffrent time of application

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "سلام کیری", Toast.LENGTH_SHORT).show();
        tv.setText(new Date().toString());  /// every time we come to this activity time will be set again
    }   // diffrent time of application

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "سلام کس کش", Toast.LENGTH_SHORT).show();
    }   // diffrent time of application

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "برو کونتو بده اوبی", Toast.LENGTH_LONG).show();
    }   // diffrent time of application

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "نده جغی", Toast.LENGTH_SHORT).show();
    }       // diffrent time of application

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu); // --> it synck with xml file when you dont want to code in java (mostly xml is better because you will have better sencec of what is happening right now)

        // If you wish coding in java you can use the code below to create menu option
        /*menu.add("MyItem1");
        menu.add("MyItem2");
        SubMenu submenu=menu.addSubMenu("MyItem3");
        submenu.add("submenu1");
        submenu.add("submenu2");*/
        return super.onCreateOptionsMenu(menu);
    } // for showing the menu bar in the application

    /*public boolean itemClick(MenuItem item){                      // one way to respond menu click (not the good one) in the menu.xml in each item you should type <android:onClick="itemClick">
        Toast.makeText(this ,item.getTitle() , Toast.LENGTH_SHORT).show();
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {       //better way of responding to menu click
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }// If we wish to have specific action for each item we use if and item.getID().....   and in the menu.xml each item should have their own id




}
