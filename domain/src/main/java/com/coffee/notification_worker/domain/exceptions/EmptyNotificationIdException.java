package com.coffee.notification_worker.domain.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyNotificationIdException extends WorkerException {

    public EmptyNotificationIdException() {
        super("Notification ID can`t be empty.");
    }

}
