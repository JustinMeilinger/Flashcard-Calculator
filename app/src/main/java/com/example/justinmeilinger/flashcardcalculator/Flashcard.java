package com.example.justinmeilinger.flashcardcalculator;

// Name: Justin Meilinger
// Course: CSC 415
// Semester: Fall 2015
// Instructor: Dr. Pulimood
// Project name: FlashcardCalculator
// Description: This project allows the user to enter an equation and then solves that equation
// storing the equation and answer in a flashcard inside of a deck and allow the user to
// then view and study from said flashcard
// Filename: Flashcard.java
// Description: this file is the flashcard object that holds the front and back of a flashcard as
// strings and contains get methods for them
// Last modified on: November 6, 2015
public class Flashcard {
    private String front, back;

    //-----------------------------------------------------------------------------------------
    //
    //  Constructor: Flashcard(String equation, double answer)
    //
    //    Parameters:
    //    input String; the equation from the solveEquation method
    //    input double; the answer to the question after being solved in the solveEquation
    //
    //    Pre-condition: The solveEquation method must have been run without errors
    //    Post-condition: A new flashcard object is created and ready for display
    //-----------------------------------------------------------------------------------------
    public Flashcard(String equation, double answer){
        front = equation;
        back = "" + answer;
    }

    //-----------------------------------------------------------------------------------------
    //
    //  Function: getFront()
    //
    //    Parameters:none
    //
    //    Pre-condition: none
    //    Post-condition: returns a String of the front of the flashcard (the equation side)
    //-----------------------------------------------------------------------------------------
    public String getFront(){
        return front;
    }

    //-----------------------------------------------------------------------------------------
    //
    //  Function: getBack()
    //
    //    Parameters:none
    //
    //    Pre-condition: none
    //    Post-condition: returns a String of the back of the flashcard (the answer side)
    //-----------------------------------------------------------------------------------------
    public String getBack(){
        return back;
    }

}
