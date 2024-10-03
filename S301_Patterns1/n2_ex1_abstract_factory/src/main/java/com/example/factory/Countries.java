package com.example.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import com.example.exceptions.CountryNotImplementedException;

public enum Countries {
	SPAIN("com.example.factory.implementations.ESFactory", "Spain"),
	USA("com.example.factory.implementations.USAFactory", "the UK"),
	UK("com.example.factory.implementations.UKFactory", "the USA");
	
	private final String factoryClass;
	private AbstractFactory factory;
	private final String name;

	Countries(String factory, String name) throws RuntimeException {
		this.factoryClass = factory;
		this.factory = null;
		this.name = name;
	}

	public static String getList() {
		List<String> countries = Arrays.stream(Countries.values()).map(e -> e.name).toList();
		return String.join(", ", countries.subList(0, countries.size() -1)) +
				" and " + countries.get(countries.size() - 1);
	}

	public AbstractFactory getFactory() throws CountryNotImplementedException {
		if (this.factory != null) {
			return this.factory;
		}else {
			try {
				@SuppressWarnings("unchecked")
				Class<AbstractFactory> factoryClass = (Class<AbstractFactory>) Class.forName(this.factoryClass);
				Constructor<AbstractFactory> constructor = factoryClass.getConstructor();
				this.factory = constructor.newInstance();
				return this.factory ;
			} catch (IllegalArgumentException | ClassNotFoundException | NoSuchMethodException e){
				throw new CountryNotImplementedException();
			} catch (InvocationTargetException | IllegalAccessException | InstantiationException  e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
