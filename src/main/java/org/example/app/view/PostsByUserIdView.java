package org.example.app.view;

import java.util.Scanner;

public class PostsByUserIdView {

    Scanner scanner = new Scanner(System.in);

    public String getData() {
        System.out.print("Input User ID: ");
        return scanner.nextLine();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
