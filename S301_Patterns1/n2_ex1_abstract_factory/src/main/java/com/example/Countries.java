package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.example.exceptions.NonExistantCountryException;

public enum Countries {
	SPAIN("com.example.factory.ESFactory"),
	USA("com.example.factory.USAFactory"),
	UK("com.example.factory.UKFactory");
	
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
				Constructor<AbstractFactory> constructor = factoryClass.getConstructor();
				this.factory = constructor.newInstance();
				return this.factory ;
			} catch (IllegalArgumentException e) {
				throw new NonExistantCountryException();
			} catch (ClassNotFoundException | NoSuchMethodException e) {
				throw new NonExistantCountryException("country is not fully implemented");
			} catch (InvocationTargetException | IllegalAccessException | InstantiationException  e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
