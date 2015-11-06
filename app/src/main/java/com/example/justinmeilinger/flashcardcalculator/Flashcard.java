package com.example.justinmeilinger.flashcardcalculator;

/**
 * Created by justinmeilinger on 10/31/15.
 */
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
