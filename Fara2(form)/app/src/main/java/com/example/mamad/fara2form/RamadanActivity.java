package com.example.mamad.fara2form;

import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RamadanActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    ImageView ivRamadan, ivRamadan2;
    RelativeLayout imageViewLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
        imageViewLayout = (RelativeLayout) findViewById(R.id.imageViewLayout);
        ivRamadan= (ImageView) findViewById(R.id.iv_Ramadan);
        ivRamadan2= (ImageView) findViewById(R.id.iv_Ramadan2);
        ivRamadan2.setOnClickListener(this);
        ivRamadan.setOnClickListener(this);
        ivRamadan2.setOnLongClickListener(this);
        ivRamadan.setOnLongClickListener(this);
        ivRamadan.animate().alpha(1f).setDuration(2000); // it should be in float ***
        Toast.makeText(this, "click on image after that long click", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
                    }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ivRamadan.getId()){
            animation();
        }else {
            if (v.getId() == ivRamadan2.getId()){
                animation();
            }
        }

    }


    private void animation() {

        ivRamadan.animate().rotationX(5f).setDuration(2000);
        ivRamadan.animate().rotationY(5f).setDuration(2000);
        // translationby means moving object but translation means displacing
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId()==ivRamadan2.getId()){
            longClick();
            }else if (v.getId()==ivRamadan.getId()){
            longClick();
        }
        return false;
           }

    private void longClick() {
        ivRamadan.animate().alpha(1f - ivRamadan.getAlpha()).setDuration(3000);   // **** each time you long click picture will change
        ivRamadan2.animate().alpha(1f - ivRamadan2.getAlpha()).setDuration(3000); // it should be in float
    }
}



