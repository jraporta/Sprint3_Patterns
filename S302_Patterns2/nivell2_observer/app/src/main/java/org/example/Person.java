package org.example;

public class Person implements Observer{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(String notification) {
        System.out.println(this.getClass().getSimpleName() + " " + this.name + " gets a notification: " + notification);
    }
}
