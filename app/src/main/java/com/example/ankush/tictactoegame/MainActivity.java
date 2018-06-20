package com.example.ankush.tictactoegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlay=0;  //0= yellow, 1= red
    int [] gameState={2,2,2,2,2,2,2,2,2}; //2 means nothing int the slot
    int [][]winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}}; // winnig poistions


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void dropIn(View view){

        ImageView counter= (ImageView) view;

        counter.setTranslationY(1000f);



        int tappedCounter= Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter]==2) {

            gameState[tappedCounter] = activePlay;        // alloting the clicked slot the to appropriate user

            if (activePlay == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlay = 1;
            } else {
                counter.setImageResource(R.drawable.yellow);
                activePlay = 0;
            }


        }

        counter.animate().translationY(1000f).rotation(360).setDuration(300);

        for(int []WinningPositions: winningPositions){   // taking the wiining poisiton one ata time e.g {0,1,2}

            if(gameState[WinningPositions[0]]==gameState[WinningPositions[1]]&& gameState[WinningPositions[2]]==gameState[WinningPositions[0]]){


            }

        }

    }



}
