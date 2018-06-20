package com.example.ankush.tictactoegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlay=0;  //0= yellow, 1= red
    int [] gameState={2,2,2,2,2,2,2,2,2}; //2 means nothing int the slot
    int [][]winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}}; // winnig poistions


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void playAgain(View view){


        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.playAgainLayout);

        linearLayout.setVisibility(View.INVISIBLE);
        activePlay=0;
        int [] DefaultgameState={2,2,2,2,2,2,2,2,2};
        gameState=DefaultgameState; // reseting tne game state again to 0


        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayout);

        for(int i=0; i< gridLayout.getChildCount();i++){

            ImageView imageView =(ImageView) gridLayout.getChildAt(i);
            imageView.setImageResource(0);
        }


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

            if(gameState[WinningPositions[0]]==gameState[WinningPositions[1]]&&
                    gameState[WinningPositions[2]]==gameState[WinningPositions[0]]&&
                    gameState[WinningPositions[0]]!=2){ // this one is because blanks are filled with 2

                    // someone has one
                String winner="Red";

                if(gameState[WinningPositions[0]]==0){
                    winner="yellow";
                }

                TextView messsage=(TextView) findViewById(R.id.winMessage);
                messsage.setText(winner+ "has won  ");


                LinearLayout linearLayout= (LinearLayout) findViewById(R.id.playAgainLayout);

                linearLayout.setVisibility(View.VISIBLE);



            }

        }

    }



}
