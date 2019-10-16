package com.agnes.SchoolSystemApplication.exception;

public class NonUniqueResultException extends Exception{
    public  NonUniqueResultException(){
        super("The student already exists");
    }
}
