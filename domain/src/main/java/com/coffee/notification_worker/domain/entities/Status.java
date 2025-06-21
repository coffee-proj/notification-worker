package com.coffee.notification_worker.domain.entities;

import com.coffee.notification_worker.domain.abstractions.entities.AggregateRoot;
import com.coffee.notification_worker.domain.value_objects.NotificationId;
import com.coffee.notification_worker.domain.value_objects.StatusMessage;
import com.coffee.notification_worker.domain.value_objects.StatusType;

public class Status extends AggregateRoot {

    private final NotificationId notificationId;
    private StatusType type;
    private StatusMessage message;

    public Status(NotificationId notificationId, StatusType type, StatusMessage message) {
        this.notificationId = notificationId;
        this.type = type;
        this.message = message;
    }

    public NotificationId getNotificationId() {
        return notificationId;
    }

    public StatusType getType() {
        return type;
    }

    public void setType(StatusType type) {
        this.type = type;
    }

    public StatusMessage getMessage() {
        return message;
    }

    public void setMessage(StatusMessage message) {
        this.message = message;
    }
}
