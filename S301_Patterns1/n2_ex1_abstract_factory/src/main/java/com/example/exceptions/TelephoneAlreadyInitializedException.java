package com.example.exceptions;

public class TelephoneAlreadyInitializedException extends RuntimeException{

    public TelephoneAlreadyInitializedException(){
        super("A telephone can only be initialized once.");
    }
}
