package com.example;

public class Airplane extends Vehicle{
	
	private final int SPEED_UP_RATE = 50;
	private final int SLOW_DOWN_RATE = 15;
	
	
	
	public Airplane() {
		super();
		System.out.println("New airplane created.");
	}

	@Override
	public void start() {
		System.out.println(this.isOn() ? "The airplane is already on." : "The airplane has been started." );
		super.start();
	}

	@Override
	public void speedUp() {
		if (super.isOn()) {
			super.setSpeed(super.getSpeed() + SPEED_UP_RATE);
			System.out.printf("The airplane has accelerated, it's new speed is %d.%n", super.getSpeed());
		} else {
			System.out.println("The airplane has to be on to speed up.");
		}
	}

	@Override
	public void slowDown() {
		int newSpeed = super.getSpeed() - SLOW_DOWN_RATE;
		newSpeed = newSpeed < 0 ? 0 : newSpeed;
		super.setSpeed(newSpeed);
		System.out.printf("The airplane has braked, it's new speed is %d.%n", super.getSpeed());
	}
	
	

	

}
