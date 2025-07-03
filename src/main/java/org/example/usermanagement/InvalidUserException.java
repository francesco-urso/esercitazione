package org.example.usermanagement;

public class InvalidUserException extends Exception{
    public InvalidUserException(String message) {
        super(message);
    }
}
