package com.example;

public class Bicycle extends Vehicle{
	
	private final int SPEED_UP_RATE = 5;
	private final int SLOW_DOWN_RATE = 7;
	
	
	
	public Bicycle() {
		super();
		System.out.println("New bicycle created.");
	}

	@Override
	public void start() {
		System.out.println("Bycicles don't have a motor and can't be started.");
	}

	@Override
	public void speedUp() {
		super.setSpeed(super.getSpeed() + SPEED_UP_RATE);
		System.out.printf("The bicycle has accelerated, it's new speed is %d.%n", super.getSpeed());
	}


	@Override
	public void slowDown() {
		int newSpeed = super.getSpeed() - SLOW_DOWN_RATE;
		newSpeed = newSpeed < 0 ? 0 : newSpeed;
		super.setSpeed(newSpeed);
		System.out.printf("The bicycle has braked, it's new speed is %d.%n", super.getSpeed());
	}
	
	

	

}
