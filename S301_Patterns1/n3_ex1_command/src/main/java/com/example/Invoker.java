package com.example;

import java.util.ArrayList;

public class Invoker {
	
	ArrayList<Command> commands;
	
	public Invoker() {
		this.commands = new ArrayList<>();
	}
	
	public void setCommand(Command command) {
		this.commands.add(command);
	}
	
	public void executeCommands() {
		this.commands.forEach(x -> x.execute());
		this.commands.clear();
	}

}
