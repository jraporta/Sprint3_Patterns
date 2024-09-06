package org.example;

import java.util.ArrayList;
import java.util.Optional;

public class StockBroker {

    private class Stock{
        String name;
        double price;

        public Stock(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return this.name;
        }

        public boolean setPrice(double price) {
            boolean changed = this.price != price;
            this.price = price;
            return changed;
        }

        @Override
        public String toString() {
            return this.name + "@" + this.price + '$';
        }
    }

    private ArrayList<Observer> observers;
    private ArrayList<Stock> stocks;

    public StockBroker() {
        this.observers = new ArrayList<>();
        this.createStocks();
    }

    private void createStocks() {
        this.stocks = new ArrayList<>();
        this.stocks.add(new Stock("Nvidia", 102.65));
        this.stocks.add(new Stock("Alphabet", 154.09));
        this.stocks.add(new Stock("Microsoft", 403.36));
        this.stocks.add(new Stock("Apple", 221.68));
        this.stocks.add(new Stock("Amazon", 172.58));
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyObservers(String notification){
        observers.forEach(x -> {x.update(notification);});
    }

    public void setStockPrice(String name, double price){
        Optional<Stock> foundStock = stocks.stream()
                .filter(stock -> stock.getName().equalsIgnoreCase(name))
                .findFirst();
        if (foundStock.isPresent()){
            if (foundStock.get().setPrice(price)){
                notifyObservers(foundStock.get().toString());
            }
        }
    }

}
