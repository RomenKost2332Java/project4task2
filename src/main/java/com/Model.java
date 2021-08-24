package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kostenko
 */
public class Model {
    public static final int SMALLER = -1;
    public static final int EQUALS = 0;
    public static final int BIGGER = 1;
    public static final int OUT_OF_BOUNDS = 2;

    private final int MAX_INT = 100;
    private final int MYSTERY_NUMBER;

    private int maxBoundInt = MAX_INT;
    private int minBoundInt = 0;

    private final List<Integer> guesses = new ArrayList<>();

    public Model(){
        MYSTERY_NUMBER = generateMysteryNumber();
    }

    public Model(int mysteryNumber) {
        if (minBoundInt <= mysteryNumber && mysteryNumber <= maxBoundInt){
            MYSTERY_NUMBER = mysteryNumber;
        } else {
            MYSTERY_NUMBER = generateMysteryNumber();
        }
    }

    private int generateMysteryNumber(){
        return (int) (Math.random() * (MAX_INT + 1));
    }

    /**
     * Method that gives information about comparing of mystery number and userInt, updates bounds depending of
     * userInt.
     * @param userInt - int that compares with mystery number.
     * @return information about comparing.
     */
    public int guessNumber(int userInt){
        if (minBoundInt > userInt || userInt > maxBoundInt){
            return OUT_OF_BOUNDS;
        }
        guesses.add(userInt);
        int comparing = Integer.compare(MYSTERY_NUMBER, userInt);
        switch (comparing){
            case SMALLER: {
                maxBoundInt = userInt - 1;
                break;
            }
            case BIGGER: {
                minBoundInt = userInt + 1;
                break;
            }
        }
        return comparing;
    }

    public int getMaxBoundInt() {
        return maxBoundInt;
    }

    public int getMinBoundInt() {
        return minBoundInt;
    }

    public List<Integer> getGuesses(){
        return List.copyOf(guesses);
    }

    public int guessesSize(){
        return guesses.size();
    }
}
