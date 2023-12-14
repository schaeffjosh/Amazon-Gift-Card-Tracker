package org.example;

import java.math.BigDecimal;

public class Person {
    private String name;
    private int id;
    private BigDecimal gcBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getGcBalance() {
        return gcBalance;
    }

    public void setGcBalance(BigDecimal gcBalance) {
        this.gcBalance = gcBalance;
    }

    public Person(String name, int id, BigDecimal gcBalance){
        this.name = name;
        this.id = id;
        this.gcBalance = gcBalance;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nGift Card Balance: " + this.gcBalance + "\n";
    }
}
