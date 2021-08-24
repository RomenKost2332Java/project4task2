package com;

import java.util.Scanner;

/**
 * @author Roman Kostenko
 */
public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * this method runs the app.
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        int userInt, comparing;
        do {
            userInt = getValidationUserInput(sc);
            comparing = model.guessNumber(userInt);
            processComparing(comparing, userInt);
        } while (comparing != Model.EQUALS);
    }

    /**
     * this method prepare message to view depending comparing.
     * @param comparing - comparing of user the number and the mystery number.
     * @param userInt - the user's attempt to guess the mystery number.
     */
    private void processComparing(int comparing, int userInt){
        switch (comparing){
            case Model.SMALLER: {
                view.printfMessage(View.NOT_GUESS, View.SMALLER, userInt);
                break;
            }
            case Model.BIGGER: {
                view.printfMessage(View.NOT_GUESS, View.BIGGER, userInt);
                break;
            }
            case Model.OUT_OF_BOUNDS:{
                view.printfMessage(View.NOT_IN_BOUNDS, model.getMinBoundInt(), model.getMaxBoundInt());
                break;
            }
            case Model.EQUALS:{
                view.printfMessage(View.WIN_MESSAGE, userInt);
                view.printfMessage(View.USER_STATISTIC, model.guessesSize());
                view.printLastTries(model.getGuesses());
                break;
            }
        }
    }

    /**
     * This method validates input of the user to get a int value
     * @param sc - the scanner that connects to the user to get an information.
     * @return the int value that user has input.
     */
    private int getValidationUserInput(Scanner sc){
        preprocessLastTriesMessage();
        view.printfMessage(View.INPUT, model.getMinBoundInt(), model.getMaxBoundInt());
        while (!sc.hasNextInt()){
            preprocessLastTriesMessage();
            view.printlnMessage(View.NON_INT);
            view.printfMessage(View.INPUT, model.getMinBoundInt(), model.getMaxBoundInt());
            sc.next();
        }
        return sc.nextInt();
    }

    private void preprocessLastTriesMessage(){
        if (model.guessesSize() != 0){
            view.printLastTries(model.getGuesses());
        }
    }
}
