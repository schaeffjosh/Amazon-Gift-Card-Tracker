package org.example;

import java.util.Scanner;

public abstract class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public abstract void printMenu();

    public int promptForMenuSelection() {
        int menuSelection;
        System.out.print("Please choose an option: ");
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }
}
