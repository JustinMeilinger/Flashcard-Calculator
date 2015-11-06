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

    //creates and adds the regular flashcards to the regular and 'all' decks
    public void addFlashcard(String equation, double answer){

        if(regSub <= 20) {
            Flashcard temp = new Flashcard(equation, answer);
            regFlashcards[regSub] = temp;
            allFlashcards[allSub] = temp;
            allSub++;
            regSub++;
        }

    }

    //returns the array of all frashcards
    public Flashcard[] getAllFlashcards(){
        return allFlashcards;
    }

    //returns the array of the regular equations flashcards
    public Flashcard[] getRegFlashcards(){
        return regFlashcards;
    }
}
