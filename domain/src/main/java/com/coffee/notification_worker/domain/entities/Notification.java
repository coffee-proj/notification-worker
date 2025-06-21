package com.coffee.notification_worker.domain.entities;

import com.coffee.notification_worker.domain.abstractions.entities.AggregateRoot;
import com.coffee.notification_worker.domain.value_objects.NotificationAddress;
import com.coffee.notification_worker.domain.value_objects.NotificationContent;
import com.coffee.notification_worker.domain.value_objects.NotificationId;
import com.coffee.notification_worker.domain.value_objects.NotificationType;

public class Notification extends AggregateRoot {

    private final NotificationId id;
    private final NotificationAddress address;
    private final NotificationType type;
    private final NotificationContent content;

    public Notification(NotificationId id, NotificationAddress address, NotificationType type, NotificationContent content) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.content = content;
    }

    public NotificationId getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationAddress getAddress() {
        return address;
    }

    public NotificationContent getContent() {
        return content;
    }
}
