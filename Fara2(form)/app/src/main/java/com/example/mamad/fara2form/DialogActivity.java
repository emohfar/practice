package com.example.mamad.fara2form;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
    }
    // back symbol
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
        }
        return super.onOptionsItemSelected(item);
    }
    // **** onclick dialog
    public void showProgressDialog(View view){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);       // posibility of cancelling a dialog is taken
        progressDialog.setTitle("Please Wait...");      // dialog title
        progressDialog.setMessage(" we're taking care of your phone");      //dialog message
        //Dialog Style
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); <-- default
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //progressDialog.setIndeterminate(true); <-- unknown time waiting like when you should wait to connect to server
        progressDialog.setProgress(15); // iniate value of progress
        progressDialog.show();      //showing dialog
        // prosess simulation 2
        new Timer().scheduleAtFixedRate(new TimerTask() {       // timer --> (task at hand, delay, time unit)
            @Override
            public void run() {
                if (progressDialog == null)
                    return;
                if (progressDialog.getProgress() < progressDialog.getMax()){
                    progressDialog.incrementProgressBy(1);
                }else {
                    progressDialog.dismiss();
                }
            }
        },0,100);

        new Timer().scheduleAtFixedRate(new TimerTask() {       // secondaryProgressDialog is like when you see a movie
            @Override
            public void run() {
                if (progressDialog == null)
                    return;
                if (progressDialog.getSecondaryProgress() < progressDialog.getMax()){
                    progressDialog.incrementSecondaryProgressBy(1);
                }
            }
        }, 0, 70);

        /*// prosess simulation 1
        new Handler().postDelayed(new Runnable() {      //giving delay to somthing
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 3000l);*/
    }

    public void showAlertDialog(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Alert!!!");
        builder.setMessage("Do you want to see GOD ?");
        builder.setCancelable(false);
        builder.setIcon(android.R.drawable.ic_lock_idle_alarm);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "GOD is busy right now. Please try later", Toast.LENGTH_LONG).show();
            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "You are Doomed", Toast.LENGTH_LONG).show();
                    }
                });
        //builder.setNeutralButton("cancel",null);
        builder.show();

    }
    public void showAlertDialog2(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Question?");
        builder.setCancelable(false);
        builder.setIcon(android.R.drawable.ic_secure);
        builder.setSingleChoiceItems(new String[]{"A: lion", "B: Rabbit", "C: Horse", "D: Cow"}, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "which = " + which, Toast.LENGTH_SHORT).show();
            }
        })
                .setPositiveButton("Ok",null);
        builder.show();

    }

    public void showAlertDialog3(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Your Choices?");
        builder.setCancelable(true);
        builder.setIcon(android.R.drawable.ic_menu_help);
        builder.setMultiChoiceItems(new String[]{"Item0", "Item1", "Item2", "Item3", "Item4"}, new boolean[]{false, true, false, true, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(DialogActivity.this, "Item "+ which +" :" +isChecked, Toast.LENGTH_SHORT).show();
            }
        })
                .setPositiveButton("Ok",null);
        builder.show();

    }
    public void showDialog(View view){
        Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog);   // ++****** showing another activity in dialog but it should have it's functions*****++
        dialog.show();

    }
}
