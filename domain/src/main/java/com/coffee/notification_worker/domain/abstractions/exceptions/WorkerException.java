package com.coffee.notification_worker.domain.abstractions.exceptions;

public class WorkerException extends RuntimeException {

    public WorkerException(String message) {
        super(message);
    }

}
