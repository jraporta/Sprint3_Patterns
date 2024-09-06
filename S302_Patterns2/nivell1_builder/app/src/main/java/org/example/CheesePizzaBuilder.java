package org.example;

public class CheesePizzaBuilder implements PizzaBuilder{

    private Pizza pizza;

    public CheesePizzaBuilder() {
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
        this.pizza.setTopping(Topping.GOAT_CHEESE);
        this.pizza.setTopping(Topping.CHEDDAR_CHEESE);
        this.pizza.setTopping(Topping.GORGONZOLA_CHEESE);
        this.pizza.setTopping(Topping.MOZZARELLA_CHEESE);
    }

    @Override
    public Pizza build() {
        return this.pizza;
    }
}
