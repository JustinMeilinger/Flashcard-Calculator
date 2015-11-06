package com.example.justinmeilinger.flashcardcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
// Name: Justin Meilinger
// Course: CSC 415
// Semester: Fall 2015
// Instructor: Dr. Pulimood
// Project name: FlashcardCalculator
// Description: This project allows the user to enter an equation and then solves that equation
// storing the equation and answer in a flashcard inside of a deck and allow the user to
// then view and study from said flashcard
// Filename: showCardsActivity.java
// Description: This class prompts the user to pick a deck of cards either all cards of just the
// regular equation cards
// Last modified on: November 6, 2015

public class showCardsActivity extends ActionBarActivity {

    //onCreate set up the activity on the screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cards);

    }
    //onCreateOptionsMenu just creates an options menu for the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_cards, menu);
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
    //  Function: showAllCards(View v)
    //
    //    Parameters:
    //    input View: the current view of the screen
    //
    //    Pre-condition: the all flashcards button was clicked
    //    Post-condition: switches activities to the flashcard screen passing a string
    //          value named "type".
    //-----------------------------------------------------------------------------------------
    public void showAllCards(View view) {
        Intent i = new Intent(this, viewCardsActivity.class);
        i.putExtra("type", "all");
        startActivity(i);
    }
    //-----------------------------------------------------------------------------------------
    //
    //  Function: regCards(View v)
    //
    //    Parameters:
    //    input View: the current view of the screen
    //
    //    Pre-condition: the regular flashcards button was clicked
    //    Post-condition: switches activities to the flashcard screen passing a string
    //          value named "type".
    //-----------------------------------------------------------------------------------------
    public void regCards(View v){
        Intent i = new Intent(this, viewCardsActivity.class);
        i.putExtra("type", "reg");
        startActivity(i);
    }
    //-----------------------------------------------------------------------------------------
    //
    //  Function: goEquations(View v)
    //
    //    Parameters:
    //    input View: the current view of the screen
    //
    //    Pre-condition: the go to equations button was clicked
    //    Post-condition: switches activities to the equation entry screen aka MainActivity
    //-----------------------------------------------------------------------------------------
    public void goEquations(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
