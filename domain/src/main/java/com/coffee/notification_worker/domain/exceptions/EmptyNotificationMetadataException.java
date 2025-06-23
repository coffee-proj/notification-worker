package com.coffee.notification_worker.domain.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptyNotificationMetadataException extends WorkerException {

    public EmptyNotificationMetadataException() {
        super("Notification metadata can`t be empty.");
    }

}
