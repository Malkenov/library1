package com.example.university.library.exception;

public class CoursNotFoundException extends RuntimeException {
    public CoursNotFoundException(String message) {
        super(message);
    }
}
