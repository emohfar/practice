package com.example.mamad.fara2form;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CODE = 128;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Info_Form formInfo= new Info_Form(this,R.id.form_info_layout);
        formInfo.getEmail_info().setTextColor(0xffff0510); //gettermethod && in java for coloring you use 0x (alpha,red,green,blue)
        formInfo.getSubmit_btn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=formInfo.getName_info().getText().toString().trim();
                String phone=formInfo.getPhn_info().getText().toString().trim();
                String email=formInfo.getEmail_info().getText().toString().trim();
                if (formInfo.isValidInput(name,phone,email)){
                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("email",name);
                    if (formInfo.getCheckBox().isChecked())
                        intent.putExtra("phone",phone);
                    startActivityForResult(intent,REQ_CODE);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode== RESULT_OK){
            Toast.makeText(this, data.getStringExtra("message") , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu intentSubmenu = menu.addSubMenu("About us");
        intentSubmenu.add("Open Browser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://touristMind"));
                startActivity(intent);
                return false;
            }
        });
        intentSubmenu.add("Open SMS").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:09021303331"));
                intent.putExtra("sms_body","با سلام ممنون از زحمات بی شائبه ی آقای فرخ هستیم");
                startActivity(intent);
                return false;
            }
        });
        intentSubmenu.add("Open dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:09021303331"));
                startActivity(intent);
                return false;
            }
        });
        SubMenu mediaSubmenu = menu.addSubMenu("media");
        mediaSubmenu.add("Ramadan").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this , RamadanActivity.class));
                return false;
            }
        });
        mediaSubmenu.add("Cartoon").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, CartoonActivity.class));
                return false;
            }
        });
        mediaSubmenu.add("Tic Tac Toe").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,Cross3Activity.class));
                return false;
            }
        });
        mediaSubmenu.add("Video").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,VideoActivity.class));
                return false;
            }
        });
        mediaSubmenu.add("Music").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,MusicActivity.class));
                return false;
            }
        });
        SubMenu listSub = menu.addSubMenu("List view");
        listSub.add("Simple list").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,SimpleListActivity.class));
                return false;
            }
        });
        listSub.add("Custom list").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,CustomListActivity.class));
                return false;
            }
        });
        menu.add("Dialog").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,DialogActivity.class));
                return false;
            }
        });
        menu.add("Rating Bar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,RatingBarActivity.class));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
