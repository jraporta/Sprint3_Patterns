package com.example;


public class App {

	
	public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        Vehicle airplane = new Airplane();
        Vehicle boat = new Boat();
        
        Invoker invoker = new Invoker();
        
        invoker.setCommand(new StartCommand(car));
        invoker.setCommand(new StartCommand(bicycle));
        invoker.setCommand(new StartCommand(airplane));
        invoker.setCommand(new StartCommand(boat));
        
        invoker.setCommand(new SpeedUpCommand(car));
        invoker.setCommand(new SpeedUpCommand(bicycle));
        invoker.setCommand(new SpeedUpCommand(airplane));
        invoker.setCommand(new SpeedUpCommand(boat));

        invoker.setCommand(new SlowDownCommand(car));
        invoker.setCommand(new SlowDownCommand(bicycle));
        invoker.setCommand(new SlowDownCommand(airplane));
        invoker.setCommand(new SlowDownCommand(boat));
        
        System.out.println("Launching commands:");
        invoker.executeCommands();
        
    }
	
	
}
