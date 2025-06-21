package com.coffee.notification_worker.application.notification.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class InvalidNotificationTypeException extends WorkerException {

    public InvalidNotificationTypeException() {
        super("Invalid notification type.");
    }

}
