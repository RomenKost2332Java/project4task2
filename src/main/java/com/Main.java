package com;

public class Main {

    /**
     * Start method to initialize Model, View and Controller and starting app.
     */
    public static void main(String... args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}
