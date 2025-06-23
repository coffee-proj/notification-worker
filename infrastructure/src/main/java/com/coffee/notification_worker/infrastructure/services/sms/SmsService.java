package com.coffee.notification_worker.infrastructure.services.sms;

import com.coffee.notification_worker.application.notification.services.SmsSender;
import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;
import com.coffee.notification_worker.domain.entities.Notification;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements SmsSender {

    @Override
    public void send(Notification notification) {
        throw new WorkerException("Sending SMS is currently unavailable.");
    }

}
