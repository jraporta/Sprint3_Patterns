package com.example;

import java.lang.reflect.InvocationTargetException;

import exeptions.NonExistantCountryException;

public enum Countries {
	SPAIN("com.example.ESFactory"),
	USA("USAFactory"),
	UK("UKFactory");
	
	private String factoryClass;
	private AbstractFactory factory;

	Countries(String s) throws RuntimeException {
		this.factoryClass = s;
		this.factory = null;
	}
	
	public AbstractFactory getFactory() throws NonExistantCountryException {
		if (this.factory != null) {
			return this.factory;
		}else {
			try {
				@SuppressWarnings("unchecked")
				Class<AbstractFactory> factoryClass = (Class<AbstractFactory>) Class.forName(this.factoryClass);
				this.factory = (AbstractFactory) (factoryClass.getDeclaredMethod("getInstance").invoke(null));
				return this.factory ;
			} catch (IllegalArgumentException e) {
				throw new NonExistantCountryException();
			} catch (ClassNotFoundException | NoSuchMethodException e) {
				throw new NonExistantCountryException("country is not fully implemented");
			} catch (InvocationTargetException | IllegalAccessException | SecurityException  e) {
				throw new RuntimeException(e.getMessage());
			} 
		}
	}

}
