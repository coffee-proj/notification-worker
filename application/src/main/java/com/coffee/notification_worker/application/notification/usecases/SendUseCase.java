package com.coffee.notification_worker.application.notification.usecases;

import com.coffee.notification_worker.application.notification.exceptions.EmptyNotificationException;
import com.coffee.notification_worker.application.notification.exceptions.InvalidNotificationTypeException;
import com.coffee.notification_worker.application.notification.services.EmailSender;
import com.coffee.notification_worker.application.notification.services.PushSender;
import com.coffee.notification_worker.application.notification.services.SmsSender;
import com.coffee.notification_worker.domain.entities.Notification;

public class SendUseCase {

    private final EmailSender emailSender;
    private final PushSender pushSender;
    private final SmsSender smsSender;

    public SendUseCase(final EmailSender emailSender, final PushSender pushSender, final SmsSender smsSender) {
        this.emailSender = emailSender;
        this.pushSender = pushSender;
        this.smsSender = smsSender;
    }

    public void execute(Notification notification) {
        if (notification == null) {
            throw new EmptyNotificationException();
        }

        switch (notification.getType().value()) {
            case EMAIL -> emailSender.send(notification);
            case PUSH -> pushSender.send(notification);
            case SMS -> smsSender.send(notification);
            default -> throw new InvalidNotificationTypeException();
        }
    }
}
