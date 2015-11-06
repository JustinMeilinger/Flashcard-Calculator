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

    //Creates a flashcard for equations
    public Flashcard(String equation, double answer){
        front = equation;
        back = "" + answer;
    }

    //returns the front of the card
    public String getFront(){
        return front;
    }

    //returns the back of the card
    public String getBack(){
        return back;
    }

}
