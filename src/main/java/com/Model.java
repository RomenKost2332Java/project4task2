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

    private static final int MAX_INT = 100;
    private static final int MIN_INT = 0;

    private final int mysteryNumber;

    private int maxBoundInt = MAX_INT;
    private int minBoundInt = MIN_INT;

    private final List<Integer> guesses = new ArrayList<>();

    public Model(){
        mysteryNumber = generateMysteryNumber();
    }

    public Model(int mysteryNumber, int maxBoundInt, int minBoundInt) {
        this.mysteryNumber = mysteryNumber;
        this.minBoundInt = minBoundInt;
        this.maxBoundInt = maxBoundInt;
    }

    private int generateMysteryNumber(){
        return (int) (Math.random() * (MAX_INT - MIN_INT - 1) + 1 + MIN_INT);
    }

    /**
     * Method that gives information about comparing of mystery number and userInt, updates bounds depending of
     * userInt.
     * @param userInt - int that compares with mystery number.
     * @return information about comparing.
     */
    public int guessNumber(int userInt){
        int comparing = Integer.compare(mysteryNumber, userInt);
        guesses.add(userInt);
        switch (comparing){
            case SMALLER: {
                maxBoundInt = userInt;
                break;
            }
            case BIGGER: {
                minBoundInt = userInt;
                break;
            }
        }
        return comparing;
    }

    public boolean isInBounds(int userInt) {
        return minBoundInt < userInt && userInt < maxBoundInt;
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
