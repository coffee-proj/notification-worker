package com.coffee.notification_worker.infrastructure.services.email;

import com.coffee.notification_worker.application.notification.services.EmailSender;
import com.coffee.notification_worker.domain.entities.Notification;
import com.coffee.notification_worker.infrastructure.services.exceptions.EmptyContentTypeException;
import com.coffee.notification_worker.infrastructure.services.exceptions.EmptySubjectException;
import com.coffee.notification_worker.infrastructure.services.exceptions.FailedEmailSendingException;
import jakarta.mail.MessagingException;
import org.springframework.lang.NonNull;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SmtpService implements EmailSender {

    private final JavaMailSender mailSender;

    public SmtpService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(@NonNull Notification notification) {
        var metadata = notification.getMetadata().value();
        var subject = metadata.get("subject");
        var contentType = metadata.get("content-type");

        if (subject == null) {
            throw new EmptySubjectException();
        }

        if (contentType == null) {
            throw new EmptyContentTypeException();
        }

        try {
            var msg = this.mailSender.createMimeMessage();
            var helper = new MimeMessageHelper(msg);

            helper.setTo(notification.getAddress().value());
            helper.setSubject(subject);
            helper.setText(notification.getContent().value(), contentType.equals("text/html"));

            this.mailSender.send(msg);
        } catch (MessagingException ex) {
            throw new FailedEmailSendingException();
        }
    }
}
