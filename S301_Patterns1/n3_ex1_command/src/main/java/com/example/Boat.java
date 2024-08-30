package com.example;

public class Boat extends Vehicle{
	
	private final int SPEED_UP_RATE = 10;
	private final int SLOW_DOWN_RATE = 2;
	
	
	
	public Boat() {
		super();
		System.out.println("New boat created.");
	}

	@Override
	public void start() {
		System.out.println(this.isOn() ? "The boat is already on." : "The boat has been started." );
		super.start();
	}

	@Override
	public void speedUp() {
		if (super.isOn()) {
			super.setSpeed(super.getSpeed() + SPEED_UP_RATE);
			System.out.printf("The boat has accelerated, it's new speed is %d.%n", super.getSpeed());
		} else {
			System.out.println("The boat has to be on to speed up.");
		}
	}

	@Override
	public void slowDown() {
		int newSpeed = super.getSpeed() - SLOW_DOWN_RATE;
		newSpeed = newSpeed < 0 ? 0 : newSpeed;
		super.setSpeed(newSpeed);
		System.out.printf("The boat has braked, it's new speed is %d.%n", super.getSpeed());
	}
	
	

	

}
