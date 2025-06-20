package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationAddressException;

public record NotificationAddress(String value) {

    public NotificationAddress {
        if (value == null) {
            throw new EmptyNotificationAddressException();
        }
    }

}
