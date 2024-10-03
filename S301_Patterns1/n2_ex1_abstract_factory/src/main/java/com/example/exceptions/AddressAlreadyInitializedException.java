package com.example.exceptions;

public class AddressAlreadyInitializedException extends RuntimeException{

    public AddressAlreadyInitializedException(){
        super("An address can only be initialized once.");
    }
}
