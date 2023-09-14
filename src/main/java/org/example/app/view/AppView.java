package org.example.app.view;

import java.util.Scanner;

public class AppView {

    Scanner scanner = new Scanner(System.in);

    public String chooseOption() {
        getMenu();
        return scanner.nextLine();
    }

    private static void getMenu() {
        System.out.println(""" 
                                                   
                ___________ MENU ___________
                1 - Get all posts.
                2 - Get post by ID.
                3 - Get all posts by User ID.
                0 - Close the application.
                """);
    }

    public void getOutput(String output, String choice) {
        if (choice.equals("0")) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
