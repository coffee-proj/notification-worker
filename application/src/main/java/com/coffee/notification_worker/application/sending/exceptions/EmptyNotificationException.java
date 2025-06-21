package com.coffee.notification_worker.application.sending.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyNotificationException extends WorkerException {

    public EmptyNotificationException() {
        super("Notification can`t be empty.");
    }

}
