package com.coffee.notification_worker.domain.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyStatusTypeException extends WorkerException {

    public EmptyStatusTypeException() {
        super("Status type can`t be empty.");
    }

}
