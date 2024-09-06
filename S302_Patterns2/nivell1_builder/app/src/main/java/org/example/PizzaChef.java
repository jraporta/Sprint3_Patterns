package org.example;

public class PizzaChef {
    private PizzaBuilder pizzabuilder;

    public PizzaChef(PizzaBuilder pizzabuilder) {
        this.pizzabuilder = pizzabuilder;
        this.pizzabuilder.configureToppings();
    }

    public PizzaChef dough(Pizza.Dough dough){
        this.pizzabuilder.configureDough(dough);
        return this;
    }

    public PizzaChef size(Pizza.Size size){
        this.pizzabuilder.configureSize(size);
        return this;
    }

    public Pizza make(){
        return this.pizzabuilder.build();
    }

}
