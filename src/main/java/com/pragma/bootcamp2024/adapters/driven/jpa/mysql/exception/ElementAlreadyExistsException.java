package com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception;

public class ElementAlreadyExistsException extends RuntimeException{
    public ElementAlreadyExistsException(String message){ super(message); }
}

