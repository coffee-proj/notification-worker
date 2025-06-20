package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationContentException;

public record NotificationContent(String value) {

    public NotificationContent {
        if (value == null) {
            throw new EmptyNotificationContentException();
        }
    }

}
