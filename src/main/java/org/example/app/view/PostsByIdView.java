package org.example.app.view;

import java.util.Scanner;

public class PostsByIdView {

    Scanner scanner = new Scanner(System.in);

    public String getData() {
        System.out.print("Input Post ID: ");
        return scanner.nextLine();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
