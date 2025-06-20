package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationTypeException;
import com.coffee.notification_worker.domain.types.SendType;

public record NotificationType(SendType value) {

    public NotificationType {
        if (value == null) {
            throw new EmptyNotificationTypeException();
        }
    }

}
