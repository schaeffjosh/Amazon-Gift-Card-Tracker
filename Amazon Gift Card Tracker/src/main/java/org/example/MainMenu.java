package org.example;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class MainMenu extends Menu{
    Map<String, Person> family;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(Map<String, Person> family){
        this.family = family;
    }

    public void printMenu(){
        System.out.println();
        System.out.println("----Gift Card Balance Calculator----");
        System.out.println("1: Show total balance");
        System.out.println("2: List member balances");
        System.out.println("3: Select member");
        System.out.println("0: Exit");
        System.out.println();
    }

    public BigDecimal getTotalBalance(){
        BigDecimal balance = new BigDecimal(0.00);
        for(Map.Entry<String, Person>  member : family.entrySet()){
            Person p = member.getValue();
            balance = balance.add(p.getGcBalance());
        }
        return balance;
    }

    public void printMembers(){
        for(Map.Entry<String, Person>  member : family.entrySet()){
            System.out.println(member.getValue().toString());
        }
    }

    public void selectMember(String person){
        Person p = getPersonByName(person, family);
        SelectMenu selectMenu = new SelectMenu(p);
        int menuSelection = -1;
        while (menuSelection != 0) {
            selectMenu.printMenu();
            menuSelection = selectMenu.promptForMenuSelection();
            if (menuSelection == 1) {
                //TODO
            } else if (menuSelection == 2) {
                //TODO
            } else if (menuSelection == 3) {
                System.out.println(p.getName() + " has " + p.getGcBalance() + " in their account");
            } else if (menuSelection == 4) {
                BigDecimal newBalance = selectMenu.addToBalance();
                System.out.println(p.getName() + "'s new balance is: $" + newBalance);
            } else if (menuSelection == 5){
                BigDecimal newBalance = selectMenu.subtractFromBalance();
                System.out.println(p.getName() + "'s new balance is: $" + newBalance);
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
            }
        }
    }

    private Person getPersonByName(String name, Map<String, Person> family){
        for(Map.Entry<String, Person> member : family.entrySet()){
            if(member.getKey().equals(name)){
                return member.getValue();
            }
        }
        return null;
    }
}
