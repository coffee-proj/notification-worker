package com.coffee.notification_worker.infrastructure.services.exceptions;

import com.coffee.notification_worker.domain.abstractions.exceptions.WorkerException;

public class EmptySubjectException extends WorkerException {

    public EmptySubjectException() {
        super("Subject can`t be empty.");
    }

}
