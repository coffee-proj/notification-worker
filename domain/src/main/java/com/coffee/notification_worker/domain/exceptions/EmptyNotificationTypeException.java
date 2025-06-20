package com.coffee.notification_worker.domain.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyNotificationTypeException extends WorkerException {

    public EmptyNotificationTypeException() {
        super("Notification type can`t be empty.");
    }

}
