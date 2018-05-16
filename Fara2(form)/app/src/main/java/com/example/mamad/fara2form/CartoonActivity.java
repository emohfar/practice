package com.example.mamad.fara2form;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CartoonActivity extends AppCompatActivity {

    ImageView panda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
        panda= (ImageView) findViewById(R.id.panda);
        panda.setTranslationY(-2000f);
        panda.animate().translationYBy(2100).setDuration(1500);
        panda.animate().alpha(1).setDuration(1500);
        panda.animate().rotation(720f).setDuration(1500);
        Toast.makeText(this, "click on me to come down", Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animate(View view){
        panda.animate().alpha(1).setDuration(1000);
        panda.animate().translationYBy(50);




    }


}


