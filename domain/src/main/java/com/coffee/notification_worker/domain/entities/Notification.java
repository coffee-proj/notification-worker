package com.coffee.notification_worker.domain.entities;

import com.coffee.notification_worker.domain.abstractions.entities.AggregateRoot;
import com.coffee.notification_worker.domain.value_objects.*;

public class Notification extends AggregateRoot {

    private final NotificationId id;
    private final NotificationAddress address;
    private final NotificationType type;
    private final NotificationContent content;
    private final NotificationMetadata metadata;

    public Notification(NotificationId id, NotificationAddress address, NotificationType type, NotificationContent content, NotificationMetadata metadata) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.content = content;
        this.metadata = metadata;
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

    public NotificationMetadata getMetadata() {
        return metadata;
    }
}
