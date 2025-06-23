package com.coffee.notification_worker.application.notification.usecases;

import com.coffee.notification_worker.application.notification.exceptions.EmptyNotificationException;
import com.coffee.notification_worker.application.notification.services.EmailSender;
import com.coffee.notification_worker.application.notification.services.PushSender;
import com.coffee.notification_worker.application.notification.services.SmsSender;
import com.coffee.notification_worker.domain.entities.Notification;
import com.coffee.notification_worker.domain.types.SendingType;
import com.coffee.notification_worker.domain.value_objects.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Hashtable;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SendUseCaseTest {

    @Test
    void execute_Email_Sender() {
        // Given
        var notification = new Notification(
                new NotificationId(UUID.randomUUID()),
                new NotificationAddress("test@example.com"),
                new NotificationType(SendingType.EMAIL),
                new NotificationContent("test"),
                new NotificationMetadata(new Hashtable<>())
        );

        var emailSender = Mockito.mock(EmailSender.class);
        var pushSender = Mockito.mock(PushSender.class);
        var smsSender = Mockito.mock(SmsSender.class);

        var sendUseCase = new SendUseCase(emailSender, pushSender, smsSender);

        // When
        sendUseCase.execute(notification);

        // Then
        Mockito.verify(emailSender).send(notification);
        Mockito.verify(pushSender, Mockito.never()).send(notification);
        Mockito.verify(smsSender, Mockito.never()).send(notification);
    }

    @Test
    void execute_Push_Sender() {
        // Given
        var notification = new Notification(
                new NotificationId(UUID.randomUUID()),
                new NotificationAddress("test@example.com"),
                new NotificationType(SendingType.PUSH),
                new NotificationContent("test"),
                new NotificationMetadata(new Hashtable<>())
        );

        var emailSender = Mockito.mock(EmailSender.class);
        var pushSender = Mockito.mock(PushSender.class);
        var smsSender = Mockito.mock(SmsSender.class);

        var sendUseCase = new SendUseCase(emailSender, pushSender, smsSender);

        // When
        sendUseCase.execute(notification);

        // Then
        Mockito.verify(pushSender).send(notification);
        Mockito.verify(emailSender, Mockito.never()).send(notification);
        Mockito.verify(smsSender, Mockito.never()).send(notification);
    }

    @Test
    void execute_Sms_Sender() {
        // Given
        var notification = new Notification(
                new NotificationId(UUID.randomUUID()),
                new NotificationAddress("test@example.com"),
                new NotificationType(SendingType.SMS),
                new NotificationContent("test"),
                new NotificationMetadata(new Hashtable<>())
        );

        var emailSender = Mockito.mock(EmailSender.class);
        var pushSender = Mockito.mock(PushSender.class);
        var smsSender = Mockito.mock(SmsSender.class);

        var sendUseCase = new SendUseCase(emailSender, pushSender, smsSender);

        // When
        sendUseCase.execute(notification);

        // Then
        Mockito.verify(smsSender).send(notification);
        Mockito.verify(emailSender, Mockito.never()).send(notification);
        Mockito.verify(pushSender, Mockito.never()).send(notification);
    }

    @Test
    void execute_Null_Notification() {
        // Given
        var emailSender = Mockito.mock(EmailSender.class);
        var pushSender = Mockito.mock(PushSender.class);
        var smsSender = Mockito.mock(SmsSender.class);

        var sendUseCase = new SendUseCase(emailSender, pushSender, smsSender);

        // When & Then
        assertThrows(EmptyNotificationException.class, () -> sendUseCase.execute(null));
    }
}