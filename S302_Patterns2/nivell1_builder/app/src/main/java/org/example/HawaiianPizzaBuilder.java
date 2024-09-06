package org.example;

public class HawaiianPizzaBuilder implements PizzaBuilder{

    private Pizza pizza;

    public HawaiianPizzaBuilder() {
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
        this.pizza.setTopping(Topping.HAM);
        this.pizza.setTopping(Topping.PINEAPPLE);
        this.pizza.setTopping(Topping.MOZZARELLA_CHEESE);
    }

    @Override
    public Pizza build() {
        return this.pizza;
    }
}
