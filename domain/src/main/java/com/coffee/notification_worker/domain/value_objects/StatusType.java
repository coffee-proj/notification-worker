package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyStatusTypeException;
import com.coffee.notification_worker.domain.types.SendingConditionType;

public record StatusType(SendingConditionType value) {

    public StatusType {
        if (value == null) {
            throw new EmptyStatusTypeException();
        }
    }

}
