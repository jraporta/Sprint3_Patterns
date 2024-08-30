package com.example;

public abstract class Vehicle {
	
	private int speed;
	private boolean start;
	
	public Vehicle() {
		this.speed = 0;
		this.start = false;
	}
	
	protected int getSpeed() {
		return speed;
	}
	
	protected boolean isOn() {
		return this.start;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void start() {
		this.start = true;
	}
	
	public abstract void speedUp();
	
	public abstract void slowDown();

	
	
	
		
	
}
