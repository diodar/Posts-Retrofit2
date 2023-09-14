package org.example.app.controller;

import org.example.app.model.AppModel;
import org.example.app.utils.Constants;
import org.example.app.view.AppView;

public class AppController {

    AppModel model;
    AppView view;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        try {
            filterChoice(Integer.parseInt(view.chooseOption()));
        } catch (IllegalStateException ise) {
            System.out.println(">> Unexpected value. Try again ...");
            runApp();
        } catch (NullPointerException npe) {
            System.out.println(Constants.NO_DATA_MSG);
            runApp();
        }
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> model.readUsers();
            case 2 -> model.readUserById();
            case 3 -> model.readAllPostsByUserId();
            case 0 -> {
                String output = Constants.APP_CLOSED_MSG;
                view.getOutput(output, Integer.toString(choice));
            }
            default -> throw new IllegalStateException(">> Unexpected value: " + choice);
        }
    }
}
