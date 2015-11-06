package com.example.justinmeilinger.flashcardcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
// Name: Justin Meilinger
// Course: CSC 415
// Semester: Fall 2015
// Instructor: Dr. Pulimood
// Project name: FlashcardCalculator
// Description: This project allows the user to enter an equation and then solves that equation
// storing the equation and answer in a flashcard inside of a deck and allow the user to
// then view and study from said flashcard
// Filename: viewCardsActivity.java
// Description: This file presents the flashcards to the user and and allows the user to flip and
// move onto the next card as well as handle decks with no cards and decks that run out of cards
// Last modified on: November 6, 2015

public class viewCardsActivity extends ActionBarActivity {

    private Flashcard[] flashcards;
    private int sub = -1;
    private boolean noFlashcards = false;

    //onCreate set up the activity on the screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cards);
        Intent intent = getIntent();
        if(intent.getStringExtra("type").equals("reg"))
            flashcards = MainActivity.getDeck().getRegFlashcards();
        else if(intent.getStringExtra("type").equals("all"))
            flashcards = MainActivity.getDeck().getAllFlashcards();

        Button b = (Button) findViewById(R.id.nextButton);
        b.callOnClick();
    }
    //onCreateOptionsMenu just creates an options menu for the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_cards, menu);
        return true;
    }
    //onOptionsItemSelected returns true id the action clicked is in the settings
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //-----------------------------------------------------------------------------------------
    //
    //  Function: goEquations(View v)
    //
    //    Parameters:
    //    input View: the current view of the screen
    //
    //    Pre-condition: the go to equations button was clicked
    //    Post-condition: switches activities to the equations screen aka MainActivity
    //-----------------------------------------------------------------------------------------
    public void goEquations(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //-----------------------------------------------------------------------------------------
    //
    //  Function: goDeck(View v)
    //
    //    Parameters:
    //    input View: the current view of the screen
    //
    //    Pre-condition: the go to deck button was clicked
    //    Post-condition: switches activity to the choose deck activity
    //-----------------------------------------------------------------------------------------
    public void goDeck(View v){
        Intent intent = new Intent(this, showCardsActivity.class);
        startActivity(intent);

    }
    //-----------------------------------------------------------------------------------------
    //
    //  Function: flipAndSwitchCard(View v)
    //
    //    Parameters:
    //    input View: the current view of the screen
    //
    //    Pre-condition: the flip button was clicked
    //    Post-condition: try to set the text of the textView to the back of the current flashcard
    //          if an error occurs show appropriate error message
    //-----------------------------------------------------------------------------------------
    public void flipAndSwitchCard(View v){

        TextView t = (TextView) findViewById(R.id.flashCard);
        try {
            t.setText("The answer is: " + flashcards[sub].getBack());
        }catch(ArrayIndexOutOfBoundsException e){
            if(noFlashcards == true) {
                t.setText("No flashcards created. Go to the equations page and create some!");
            }else
                t.setText("Hit the NEXT button to recycle cards");
        }

    }
    //-----------------------------------------------------------------------------------------
    //
    //  Function: nextCard(View v)
    //
    //    Parameters:
    //    input View: the current view of the screen
    //
    //    Pre-condition: the next button was clicked
    //    Post-condition: try to set the textView to a the next flashcard's front if there is no
    //          flashcard set the correct error message
    //-----------------------------------------------------------------------------------------
    public void nextCard(View v){
        sub++;
        TextView t = (TextView) findViewById(R.id.flashCard);
        try {
            t.setText("" + flashcards[sub].getFront());
            noFlashcards = false;
        }catch(NullPointerException e){
            if (sub <= 0){
                t.setText("No flashcards created. Go to the equations page and create some!");
                noFlashcards = true;
                sub = -1;
            }else {
                t.setText("You have no more flashcards... hit next to recycle cards");
                sub = -1;
            }
        }
    }
}
