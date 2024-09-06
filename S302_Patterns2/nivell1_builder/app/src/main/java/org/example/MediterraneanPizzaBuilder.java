package org.example;

public class MediterraneanPizzaBuilder implements PizzaBuilder{

    private Pizza pizza;

    public MediterraneanPizzaBuilder() {
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
        this.pizza.setTopping(Topping.TUNA);
        this.pizza.setTopping(Topping.BLACK_OLIVE);
        this.pizza.setTopping(Topping.BASIL);
        this.pizza.setTopping(Topping.MOZZARELLA_CHEESE);
    }

    @Override
    public Pizza build() {
        return this.pizza;
    }
}
