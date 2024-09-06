package org.example;

public interface PizzaBuilder {
    public void configureSize(Pizza.Size size);
    public void configureDough(Pizza.Dough dough);
    public void configureToppings();
    public Pizza build();
}
