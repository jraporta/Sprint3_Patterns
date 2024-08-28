package com.example;

import java.util.ArrayList;
import java.util.List;

import util.Entrada;

public class Undo {
	
	private static Undo instance;
	private List<String> history;
	final private static int SIZE = 10;

	
	private Undo() {
		this.history = new ArrayList<>();
	}
	
	public static Undo getInstance() {
		if (Undo.instance == null) {
			Undo.instance = new Undo();
		}
		return Undo.instance;
	}
	
	public void execute (String s) {
		switch(s) {
		case "help":
			System.out.println("Accepted commands: 'history', 'go', 'delete', 'clear'.");
			break;
		case "history":
			int i = 1;
			for (String element : this.history) {
				System.out.printf("%d. %s%n", i++, element);
			}
			break;
		case "go":
			i = Entrada.llegirInt("select element to revisit: ");
			try {
				s = this.history.get(i - 1);
				add(s);
				System.out.println(s);
			} catch (IndexOutOfBoundsException e) {
				System.out.printf("Element '%d' non-existent in history.%n", i);
			}
			break;
		case "delete":
			i = Entrada.llegirInt("select element to delete: ");
			try {
				s = this.history.remove(i - 1);
				System.out.printf("Element '%s' removed from history.%n", s);
			} catch (IndexOutOfBoundsException e) {
				System.out.printf("Element '%d' non-existent in history.%n", i);
			}
			break;
		case "clear":
			this.history.clear();
			System.out.println("History is empty.");
			break;
		default:
			add(s);
		}
	}

	private void add (String s) {
		this.history.add(s);
		while (this.history.size() > Undo.SIZE) {
			this.history.remove(0);
		}
	}

}
