package com;

/**
 * @author Roman Kostenko
 */
public class View {
    public static final String INPUT = "Guess the mystery number! Please input the int value from %d to %d:";
    public static final String LAST_TRIES = "User's tries: ";
    public static final String DELIMITER = ", ";

    public static final String NON_INT = "Wrong input! Non int value was input. ";
    public static final String NOT_IN_BOUNDS = "Wrong input! The input value isn't in bounds from %d to %d.";

    public static final String NOT_GUESS = "Sorry, but you didn't guess the number. The mystery number is %s %d.";
    public static final String BIGGER = "bigger then";
    public static final String SMALLER = "smaller then";

    public static final String WIN_MESSAGE = "Congratulation! The mystery number is %d!";
    public static final String USER_STATISTIC = "Statistic: the user guess the mystery number with %d tries.";

    public void printlnMessage(String message){
        System.out.println(message);
    }

    public void printfMessage(String message, Object... args){
        System.out.printf(message, args);
        System.out.println();
    }

    /**
     * This method prints last guesses with user-friendly interphase.
     * @param guesses - the iterable set of guesses to display.
     */
    public void printLastTries(Iterable<Integer> guesses){
        StringBuilder message = new StringBuilder(LAST_TRIES);
        for(int guess:guesses){
            message.append(guess).append(DELIMITER);
        }
        message.delete(message.length()-DELIMITER.length(), message.length());
        printlnMessage(message.toString());
    }

}
