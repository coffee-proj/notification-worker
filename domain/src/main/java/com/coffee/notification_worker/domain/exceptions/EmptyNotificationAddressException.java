package com.coffee.notification_worker.domain.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyNotificationAddressException extends WorkerException {

    public EmptyNotificationAddressException() {
        super("Notification address can`t be empty.");
    }

}
