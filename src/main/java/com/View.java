package com;

/**
 * @author Roman Kostenko
 */
public class View {
    public static final String INPUT = "Guess the number! Diapason is (%d, %d):";
    public static final String LAST_ATTEMPTS = "The attempts: ";

    public static final String NON_INT = "Wrong input! Non int value.";
    public static final String NOT_IN_BOUNDS = "Wrong input! Out of diapason (%d, %d).";

    public static final String NOT_GUESS = "Guessed wrong. The number is %s than %d.";
    public static final String MORE = "more";
    public static final String LESS = "less";

    public static final String WIN_MESSAGE = "Congratulation! The number is %d!";
    public static final String COUNT_GUESSES = "The number was guessed for %d attempts.";

    protected void printMessage(String message){
        System.out.println(message);
    }

    public void printfMessage(String message, Object... args){
        System.out.printf(message, args);
        System.out.println();
    }
}