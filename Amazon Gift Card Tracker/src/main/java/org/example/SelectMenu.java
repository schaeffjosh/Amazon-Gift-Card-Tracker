package org.example;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class SelectMenu extends Menu{
    private Person person;
    private final Scanner scanner = new Scanner(System.in);

    public SelectMenu(Person person) {
        this.person = person;
    }


    public void printMenu(){
        System.out.println();
        System.out.println("----Select Menu----");
        //TODO: figure out how to record transactions
        System.out.println("1: Show transactions");
        System.out.println("2: Record transaction");
        System.out.println("3: Show balance");
        System.out.println("4: Add to balance");
        System.out.println("5: Subtract from balance");
        System.out.println("0: Exit");
        System.out.println();
    }

    public BigDecimal addToBalance(){
        System.out.println("Amount added: ");
        String userInput = scanner.nextLine();
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(userInput));
        BigDecimal newBalance = this.person.getGcBalance().add(amount);
        this.person.setGcBalance(newBalance);
        return this.person.getGcBalance();
    }

    public BigDecimal subtractFromBalance(){
        System.out.println("Amount spent: ");
        String userInput = scanner.nextLine();
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(userInput));
        BigDecimal newBalance = this.person.getGcBalance().subtract(amount);
        this.person.setGcBalance(newBalance);
        return this.person.getGcBalance();
    }



}
