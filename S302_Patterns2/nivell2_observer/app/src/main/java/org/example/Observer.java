package org.example;

@FunctionalInterface
public interface Observer {

    public void update(String notification);

}
