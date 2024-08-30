package com.example;

public class SpeedUpCommand implements Command{
	
	private Vehicle vehicle;

	public SpeedUpCommand(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public void execute() {
		vehicle.speedUp();		
	}

}
