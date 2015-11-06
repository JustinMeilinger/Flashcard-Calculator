package com.example.justinmeilinger.flashcardcalculator;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
// Name: Justin Meilinger
// Course: CSC 415
// Semester: Fall 2015
// Instructor: Dr. Pulimood
// Project name: FlashcardCalculator
// Description: This project allows the user to enter an equation and then solves that equation
// storing the equation and answer in a flashcard inside of a deck and allow the user to
// then view and study from said flashcard
// Filename: MainActivity.java
// Description: this file creates and runs the equation screen
// Last modified on: November 6, 2015

public class MainActivity extends ActionBarActivity {


    private static Deck deck = new Deck();
    private static int numOfCards = 0;
    @Override

    //onCreate set up the activity on the screen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //-----------------------------------------------------------------------------------------
    //
    //  Function: getDeck()
    //
    //    Parameters:
    //    none
    //
    //    Pre-condition: none
    //    Post-condition: returns the static deck variable
    //-----------------------------------------------------------------------------------------
    public static Deck getDeck(){
        return deck;
    }

    //onCreateOptionsMenu just creates an options menu for the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    //  Function: sendInfo(View v)
    //
    //    Parameters:
    //    input View; current view of the xml screen
    //
    //    Pre-condition: The solve and add button must be click
    //    Post-condition: The String in the text field is taken and sent to the RegularEquations
    //            class solveProblem method. It contains appropriate error handling if the text
    //            has an incorrect character in it
    //-----------------------------------------------------------------------------------------
    public void sendInfo(View v){
        RegularEquations reg = new RegularEquations();

        EditText e = (EditText) findViewById(R.id.inputEquationEditText);
        TextView out = (TextView) findViewById(R.id.outputTextView);

       try{
           out.setTextColor(Color.BLACK);
           reg.solveProblem(e.getText().toString());
           numOfCards++;
           out.setText("Flashcard created: you have (" + numOfCards + ") cards");
       }catch(NullPointerException error){
           out.setTextColor(Color.RED);
           out.setText("Incorrect input please try again, please enter all negatives inside parenthesis");
       }catch (NumberFormatException error){
           out.setTextColor(Color.RED);
           out.setText("Incorrect input. Found character that is not a number or a function sign." +
                   " Please Note: negatives should be (-3) and signs are: + - * /");
       }


    }

    //-----------------------------------------------------------------------------------------
    //
    //  Function: goDeck(View v)
    //
    //    Parameters:
    //    input View; current view of the xml screen
    //
    //    Pre-condition: The go to decks button must be click
    //    Post-condition: Switches the activity to the showCardsActivity that show the card decks
    //-----------------------------------------------------------------------------------------
    public void goDeck(View v){
        Intent intent = new Intent(this, showCardsActivity.class);
        startActivity(intent);
    }
}
