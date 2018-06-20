package com.example.ankush.tictactoegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlay=0;  //0= yellow, 1= red

    int [] gameState={2,2,2,2,2,2,2,2,2}; //2 means nothing int the slot

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void dropIn(View view){

        ImageView counter= (ImageView) view;

        counter.setTranslationY(1000f);

        if(activePlay==0) {
            counter.setImageResource(R.drawable.yellow);
            activePlay=1;
        }
        else {
            counter.setImageResource(R.drawable.yellow);
        activePlay=0;
        }
        counter.animate().translationY(1000f).rotation(360).setDuration(300);



    }



}
