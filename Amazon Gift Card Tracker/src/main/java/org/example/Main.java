package org.example;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    MemberService memberService = new MemberService();
    Map<String, Person> family = memberService.getFamilyList();
    MainMenu mainMenu = new MainMenu(family);

    Scanner scanner = new Scanner(System.in);

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main app = new Main();
        app.run();
    }

    public void run() throws FileNotFoundException {

        int menuSelection = -1;
        while (menuSelection != 0) {
            mainMenu.printMenu();
            menuSelection = mainMenu.promptForMenuSelection();
            if (menuSelection == 1) {
                handleGetTotalBalance();
            } else if (menuSelection == 2) {
                handleDisplayMembers();
            } else if (menuSelection == 3) {
                handleGetPersonByName();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
            }
        }
        memberService.recordChanges(family);
    }

    private void handleGetTotalBalance(){
        System.out.println("Total Balance: " + mainMenu.getTotalBalance());
    }

    private void handleDisplayMembers(){
        System.out.println("----Members----");
        mainMenu.printMembers();
        System.out.println("---------------");
    }

    private void handleGetPersonByName(){
        System.out.println("Who would you like to select?");
        String userInput = scanner.nextLine();
        mainMenu.selectMember(userInput);
    }
}