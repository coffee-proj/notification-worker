package com.coffee.notification_worker.infrastructure.services.email;

import com.coffee.notification_worker.application.notification.services.EmailSender;
import com.coffee.notification_worker.domain.entities.Notification;

public class SmtpService implements EmailSender {

    @Override
    public void send(Notification notification) {

    }

}
