package com.example;

public class SlowDownCommand implements Command{
	
	private Vehicle vehicle;

	public SlowDownCommand(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public void execute() {
		vehicle.slowDown();		
	}

}
