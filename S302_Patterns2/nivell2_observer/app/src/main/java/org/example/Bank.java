package org.example;

public class Bank implements Observer{

    private String name;

    public Bank(String name) {
        this.name = name;
    }

    @Override
    public void update(String notification) {
        System.out.println(this.getClass().getSimpleName() + " " + this.name + " gets a notification: " + notification);
    }
}
