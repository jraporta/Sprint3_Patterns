package com.example;

public class Car extends Vehicle{
	
	private final int SPEED_UP_RATE = 20;
	private final int SLOW_DOWN_RATE = 15;
	
	
	
	public Car() {
		super();
		System.out.println("New car created.");
	}

	@Override
	public void start() {
		System.out.println(this.isOn() ? "The car is already on." : "The car has been started." );
		super.start();
	}

	@Override
	public void speedUp() {
		if (super.isOn()) {
			super.setSpeed(super.getSpeed() + SPEED_UP_RATE);
			System.out.printf("The car has accelerated, it's new speed is %d.%n", super.getSpeed());
		} else {
			System.out.println("The car has to be on to speed up.");
		}
	}

	@Override
	public void slowDown() {
		int newSpeed = super.getSpeed() - SLOW_DOWN_RATE;
		newSpeed = newSpeed < 0 ? 0 : newSpeed;
		super.setSpeed(newSpeed);
		System.out.printf("The car has braked, it's new speed is %d.%n", super.getSpeed());
	}
	
	

	

}
