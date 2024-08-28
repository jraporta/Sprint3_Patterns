package com.example;

import util.Entrada;

public class App {
    public static void main(String[] args) {
        
    	String s = null;
    	Undo undo = Undo.getInstance();
        
        do {
        	s = Entrada.llegirString(">"); 
        	undo.execute(s);
        }while (true);
        
    }
}
