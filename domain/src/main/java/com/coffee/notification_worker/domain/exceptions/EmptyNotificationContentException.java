package com.coffee.notification_worker.domain.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyNotificationContentException extends WorkerException {

    public EmptyNotificationContentException() {
        super("Notification content can`t be empty.");
    }

}
