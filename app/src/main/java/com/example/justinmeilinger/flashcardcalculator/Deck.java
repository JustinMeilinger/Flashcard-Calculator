package com.example.justinmeilinger.flashcardcalculator;

/**
 * Created by justinmeilinger on 10/31/15.
 */
public class Deck {
    //holds only the regular equations flashcards
    private Flashcard[] regFlashcards = new Flashcard[20];
    private int regSub = 0;
    //holds only the linear matrices flashcards
    private Flashcard[] linearFlashcards = new Flashcard[20];
    private int linearSub = 0;
    //holds all flash cards
    private Flashcard[] allFlashcards = new Flashcard[40];
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
