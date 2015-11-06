package com.example.justinmeilinger.flashcardcalculator;

import android.text.Editable;

import java.util.*;

/**
 * Created by justinmeilinger on 10/31/15.
 */

public class RegularEquations {
    private double answer = 0;
    private String equation;

    //this method takes in a string of an equation and computes the answer and adds it to the deck
    // of flashcards
    public double solveProblem(String equation, Deck deck) {
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
        deck.addFlashcard(equation, answer);
        return answer;
    }

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


    //takes null values off the end of the array
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
