package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationMetadataException;

import java.util.Dictionary;

public record NotificationMetadata(Dictionary<String, String> value) {

    public NotificationMetadata {
        if (value == null) {
            throw new EmptyNotificationMetadataException();
        }
    }

}
