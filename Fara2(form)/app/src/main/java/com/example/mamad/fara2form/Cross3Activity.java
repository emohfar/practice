package com.example.mamad.fara2form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class Cross3Activity extends AppCompatActivity {
    public static final int CIRCLE_CODE = 0;
    public static final int CROSS_CODE = 1;
    public static final int NOT_PLAYED = 2;
    private static final int NO_WINNER = -1;
    int winner = NO_WINNER;
    int[] status= {NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED};
    int[][] winningPsition = {{0,1,2},{3,4,5},{6,7,8},
                                {0,3,6},{1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};
    int turn = CIRCLE_CODE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
        }
        return super.onOptionsItemSelected(item);
    }
    public void dropIn(View v){
        int tag= Integer.parseInt((String) v.getTag()); // parse somthing to somthing *****
        if (winner != NO_WINNER || status[tag]!= NOT_PLAYED){
            return;
        }
        ImageView pawn= (ImageView) v;
        pawn.setAlpha(0f);
        if (turn==CIRCLE_CODE){
            pawn.setImageResource(R.drawable.circle1);
            turn=CROSS_CODE;
            status[tag]=CIRCLE_CODE;
        }else if(turn==CROSS_CODE){
                pawn.setImageResource(R.drawable.cross1);
                turn=CIRCLE_CODE;
                status[tag]=CROSS_CODE;
            }
        pawn.animate().alpha(1f).setDuration(500);
        //check winner
        winner= checkWinner();
        if (winner != NO_WINNER || filled()){
            Toast.makeText(this, "Winner: " + ((winner == CIRCLE_CODE) ? "Cross" : "Circle"), Toast.LENGTH_SHORT).show();
        }
    }

    public int checkWinner(){
        for (int[] positions : winningPsition){
            if (    status[positions[0]] == status[positions[1]] &&
                    status[positions[1]] == status[positions[2]]&&
                    status[positions[0]] != NOT_PLAYED){
                return status[positions[0]];
            }
        }
        return NO_WINNER;
    }
    public boolean filled(){
        for (int i =0 ; i < status.length; i++){
            if (status[i]== NOT_PLAYED){
                return false;
            }
        }
        return true;
    }
    public void reset(){
        //Active player
        turn= CIRCLE_CODE;
        //winner
        winner= NO_WINNER;
        //game State
        for (int i=0 ; i< status.length ; i++){
            status[i]= NOT_PLAYED;
        }
        //Play ground
        GridLayout pgLayout = (GridLayout) findViewById(R.id.pg_Layout);
        for (int i=0 ; i< pgLayout.getChildCount();i++){

        }
    }



}
