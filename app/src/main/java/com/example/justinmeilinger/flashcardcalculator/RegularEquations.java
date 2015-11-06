package com.example.justinmeilinger.flashcardcalculator;

import android.text.Editable;

import java.util.*;

// Name: Justin Meilinger
// Course: CSC 415
// Semester: Fall 2015
// Instructor: Dr. Pulimood
// Project name: FlashcardCalculator
// Description: This project allows the user to enter an equation and then solves that equation
// storing the equation and answer in a flashcard inside of a deck and allow the user to
// then view and study from said flashcard
// Filename: RegularEquations.java
// Description: this file contains the main algorithm to parse the string entry into a form that
// executes the correct function and stores the results into the deck with the other cards
// Last modified on: November 6, 2015

public class RegularEquations {
    private double answer = 0;
    private String equation;

    //-----------------------------------------------------------------------------------------
    //
    //  Function: solveProblem(String equation)
    //
    //    Parameters:
    //    input String; string of the equation that is sent from the MainActivity class
    //
    //    Pre-condition: the string must be a string
    //    Post-condition: The String is taken and all spaces are taken out of it. If errors occur
    //            they propagate out of the method to the try catch in the MainActivity's sendInfo
    //            method. After the spaces are taken out of the string method looks for negatives
    //            and rewrites them to a readable value. then the method cycles through the equation
    //            and calculates the multiplication and division first resizing the array in the
    //            process the program then finally compute the remaining addition and subtraction,
    //            places the answer in the first position in the array and then adds it to the deck
    //            as a new flashcard.
    //-----------------------------------------------------------------------------------------
    public double solveProblem(String equation) {
        this.equation = equation;
        String[] numbers = new String[20];
        int numSub = 0;
        double temp;
        String[] tokens = formatString(equation);

        for (int i = 0; i < tokens.length; i++) {

            if (i % 2 == 0) {
                if (tokens[i].charAt(0) == '(') {
                    String tempNum = tokens[i].substring(1, tokens[i].indexOf(")"));
                    if (tempNum.charAt(0) == '-') {
                        temp = Double.parseDouble(tempNum.substring(1));
                        temp = temp * (-1);
                        numbers[numSub] = "" + temp;
                        numSub++;
                    }else
                        throw new NullPointerException();
                }else{
                    numbers[numSub] = tokens[i];
                    numSub++;
                }

            } else {
                numbers[numSub] = tokens[i];
                numSub++;
            }
        }


        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            if(numbers[i].equals("*")) {
                numbers[i-1] = "" + (Double.parseDouble(numbers[i-1]) * Double.parseDouble(numbers[i+1]));
                numbers[i] = null;
                numbers[i+1] = null;
                length -= 2;
                i--;
            }else if(numbers[i].equals("/")) {
                numbers[i-1] = "" + (Double.parseDouble(numbers[i-1]) / Double.parseDouble(numbers[i+1]));
                numbers[i] = null;
                numbers[i+1] = null;
                length -= 2;
                i--;
            }
            shrinkArr(numbers);
        }

        int i = 1;
        while(i < length){

            if(numbers[i].equals("+")) {
                numbers[i - 1] = "" + (Double.parseDouble(numbers[i - 1]) + Double.parseDouble(numbers[i + 1]));
                numbers[i] = null;
                numbers[i+1] = null;
                length -= 2;

            }else if(numbers[i].equals("-")) {

                numbers[i - 1] = "" + (Double.parseDouble(numbers[i - 1]) - Double.parseDouble(numbers[i + 1]));
                numbers[i] = null;
                numbers[i+1] = null;
                length -= 2;

            }
            shrinkArr(numbers);
            if(numbers[i] == null){
                break;
            }
        }
        answer =  Double.parseDouble(numbers[0]);
        MainActivity.getDeck().addFlashcard(equation, answer);
        return answer;
    }

    //-----------------------------------------------------------------------------------------
    //
    //  Function: shrinkArr(String[] arr)
    //
    //    Parameters:
    //    input String[]; array of the current string numbers and functions
    //
    //    Pre-condition: the string[] must have a length of 1
    //    Post-condition: Takes a String[] and takes all of the nulls inside the array and moves
    //              them to the end of the array. Returns the resulting array
    //-----------------------------------------------------------------------------------------
    public String[] shrinkArr(String[] arr){

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null){
                for(int j = i; j < arr.length; j++){
                    if(arr[j] != null){
                        arr[i] = arr[j];
                        arr[j] = null;
                        break;
                    }
                }
            }
        }
        return arr;
    }
    //-----------------------------------------------------------------------------------------
    //
    //  Function: formatString(String str)
    //
    //    Parameters:
    //    input String; the original string the solveEquation method is given
    //
    //    Pre-condition: non
    //    Post-condition: cycles through the string and creates a new string that is then split into
    //              an array of strings that is then returned
    //-----------------------------------------------------------------------------------------
    public String[] formatString(String str){
        String[] arr;
        int j = 0;
        boolean hitSign = true;
        String equate = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                equate += str.charAt(i);
            }
        }
        arr = new String[equate.length()];
        for(int i = 0; i < equate.length(); i++){
            switch (equate.charAt(i)){
                case '+':
                    j++;
                    arr[j] = "+";
                    j++;
                    hitSign = true;
                    break;
                case '*':
                    j++;
                    arr[j] = "*";
                    j++;
                    hitSign = true;
                    break;
                case '/':
                    j++;
                    arr[j] = "/";
                    j++;
                    hitSign = true;
                    break;
                case '-':
                    j++;
                    arr[j] = "-";
                    j++;
                    hitSign = true;
                    break;
                case '(':
                    arr[j] = equate.substring(i, equate.indexOf(")")+1);
                    i += equate.indexOf(")") - i;
                    j++;
                    break;
                default:
                    if(hitSign == true){
                        arr[j] = "" + equate.charAt(i);
                        hitSign = false;
                    }else
                        arr[j] += equate.charAt(i);
                    break;

            }
        }
        arr = cleanArr(arr);
        return arr;
    }


    //-----------------------------------------------------------------------------------------
    //
    //  Function: sendInfo(View v)
    //
    //    Parameters:
    //    input View; current view of the xml screen
    //
    //    Pre-condition: The array has null values at the end
    //    Post-condition: deletes all null values from the array and returns it
    //-----------------------------------------------------------------------------------------
    public String[] cleanArr(String[] arr){
        //finds the size of the array
        int j = 0;
        while(j < arr.length && arr[j] != null){
            j++;
        }

        //creates the new array without the null values
        String[] arr2 = new String[j];
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }
}
