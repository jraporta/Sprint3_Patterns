package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Pizza {

    public enum Size{
        MINI,
        MEDIUM,
        LARGE,
        EXTRA_LARGE;
    }

    public enum Dough {
        GLUTEN_FREE,
        THIN_CRUST,
        FLUFFY,
        NY_STYLE;
    }

    private Size size;
    private Dough dough;
    private ArrayList<Topping> toppings;

    public Pizza() {
        this.size = null;
        this.dough = null;
        this.toppings = new ArrayList<>();
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        String toppings = this.toppings.stream().map(Enum::name).collect(Collectors.joining(", "));
        return String.format("This is a %s Pizza with a %s dough and with the toppings: %s",
                this.size, this.dough, toppings);
    }
}
