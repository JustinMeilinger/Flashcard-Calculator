package com.example.justinmeilinger.flashcardcalculator;

// Name: Justin Meilinger
// Course: CSC 415
// Semester: Fall 2015
// Instructor: Dr. Pulimood
// Project name: FlashcardCalculator
// Description: This project allows the user to enter an equation and then solves that equation
// storing the equation and answer in a flashcard inside of a deck and allow the user to
// then view and study from said flashcard
// Filename: Deck.java
// Description: This file is the deck object that creates and adds flashcards to its flash card arrays
// Last modified on: November 6, 2015

public class Deck {
    //holds only the regular equations flashcards
    private Flashcard[] regFlashcards = new Flashcard[100];
    private int regSub = 0;
    //holds only the linear matrices flashcards
    private Flashcard[] linearFlashcards = new Flashcard[20];
    private int linearSub = 0;
    //holds all flash cards
    private Flashcard[] allFlashcards = new Flashcard[100];
    private int allSub = 0;

    //-----------------------------------------------------------------------------------------
    //
    //  Function: addFlashcard(String equation, double answer)
    //
    //    Parameters:
    //    input String; the equation from the solveEquation method
    //    input double; the answer to the question after being solved in the solveEquation
    //
    //    Pre-condition: The solveEquation method must have been run without errors
    //    Post-condition: The
    //-----------------------------------------------------------------------------------------
    public void addFlashcard(String equation, double answer){

        if(regSub <= 20) {
            Flashcard temp = new Flashcard(equation, answer);
            regFlashcards[regSub] = temp;
            allFlashcards[allSub] = temp;
            allSub++;
            regSub++;
        }

    }

    //-----------------------------------------------------------------------------------------
    //
    //  Function: getAllFlashcards()
    //
    //    Parameters: none
    //
    //    Pre-condition: none
    //    Post-condition: returns a array of all flashcards
    //-----------------------------------------------------------------------------------------
    public Flashcard[] getAllFlashcards(){
        return allFlashcards;
    }

    //-----------------------------------------------------------------------------------------
    //
    //  Function: getRegFlashcards()
    //
    //    Parameters: none
    //
    //    Pre-condition: none
    //    Post-condition: returns an array of only regular flashcards
    //-----------------------------------------------------------------------------------------
    public Flashcard[] getRegFlashcards(){
        return regFlashcards;
    }
}
