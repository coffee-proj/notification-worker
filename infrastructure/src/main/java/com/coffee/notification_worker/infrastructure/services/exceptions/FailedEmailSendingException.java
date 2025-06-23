package com.coffee.notification_worker.infrastructure.services.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class FailedEmailSendingException extends WorkerException {

    public FailedEmailSendingException() {
        super("Email sending failed.");
    }

}