package com.coffee.notification_worker.application.status.usecases;

import com.coffee.notification_worker.application.status.exceptions.EmptyStatusException;
import com.coffee.notification_worker.domain.entities.Status;
import com.coffee.notification_worker.domain.repositories.StatusRepository;

public class SaveStatusUseCase {

    private final StatusRepository repository;

    public SaveStatusUseCase(StatusRepository repository) {
        this.repository = repository;
    }

    public void execute(Status status) {
        if (status == null) {
            throw new EmptyStatusException();
        }

        repository.save(status);
    }
}
