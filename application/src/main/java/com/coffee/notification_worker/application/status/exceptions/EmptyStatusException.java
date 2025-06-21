package com.coffee.notification_worker.application.status.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyStatusException extends WorkerException {

    public EmptyStatusException() {
        super("Status can`t be empty.");
    }

}
