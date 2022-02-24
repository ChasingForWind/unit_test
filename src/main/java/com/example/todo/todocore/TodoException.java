package com.example.todo.todocore;

public class TodoException extends RuntimeException {
    public TodoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
