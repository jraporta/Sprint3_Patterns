package org.example;

public class VegetarianPizzaBuilder implements PizzaBuilder{

    private Pizza pizza;

    public VegetarianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void configureSize(Pizza.Size size) {
        this.pizza.setSize(size);
    }

    @Override
    public void configureDough(Pizza.Dough dough) {
        this.pizza.setDough(dough);
    }

    @Override
    public void configureToppings() {
        this.pizza.setTopping(Topping.TOMATO_SAUCE);
        this.pizza.setTopping(Topping.ONION);
        this.pizza.setTopping(Topping.SPINACH);
        this.pizza.setTopping(Topping.MUSHROOMS);
    }

    @Override
    public Pizza build() {
        return this.pizza;
    }
}
