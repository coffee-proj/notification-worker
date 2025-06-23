package com.coffee.notification_worker.infrastructure.services.push;

import com.coffee.notification_worker.application.notification.services.PushSender;
import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;
import com.coffee.notification_worker.domain.entities.Notification;
import org.springframework.stereotype.Service;

@Service
public class PushService implements PushSender {

    @Override
    public void send(Notification notification) {
        throw new WorkerException("Sending push messages is currently unavailable.");
    }

}
