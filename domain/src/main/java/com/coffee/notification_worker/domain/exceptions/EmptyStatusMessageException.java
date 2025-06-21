package com.coffee.notification_worker.domain.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyStatusMessageException extends WorkerException {

    public EmptyStatusMessageException() {
        super("Status message can`t be empty.");
    }

}
