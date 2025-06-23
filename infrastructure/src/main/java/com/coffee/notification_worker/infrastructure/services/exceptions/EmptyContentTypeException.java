package com.coffee.notification_worker.infrastructure.services.exceptions;

public class EmptyContentTypeException extends RuntimeException {

    public EmptyContentTypeException() {
        super("Content-Type can`t be empty.");
    }

}
