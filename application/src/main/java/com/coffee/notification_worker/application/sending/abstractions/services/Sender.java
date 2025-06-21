package com.coffee.notification_worker.application.sending.abstractions.services;

import com.coffee.notification_worker.domain.entities.Notification;

public interface Sender {
    void send(Notification notification);
}
