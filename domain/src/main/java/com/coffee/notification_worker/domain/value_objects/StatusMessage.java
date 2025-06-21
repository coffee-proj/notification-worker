package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyStatusMessageException;

public record StatusMessage(String value) {

    public StatusMessage {
        if (value == null) {
            throw new EmptyStatusMessageException();
        }
    }

}
