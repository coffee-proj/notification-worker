package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationTypeException;
import com.coffee.notification_worker.domain.types.SendingType;

public record NotificationType(SendingType value) {

    public NotificationType {
        if (value == null) {
            throw new EmptyNotificationTypeException();
        }
    }

}
