package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationIdException;

import java.util.UUID;

public record NotificationId(UUID value) {

    public NotificationId {
        if (value == null) {
            throw new EmptyNotificationIdException();
        }
    }

}
