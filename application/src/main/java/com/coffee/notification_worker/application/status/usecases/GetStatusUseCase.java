package com.coffee.notification_worker.application.status.usecases;

import com.coffee.notification_worker.domain.entities.Status;
import com.coffee.notification_worker.domain.exceptions.EmptyNotificationIdException;
import com.coffee.notification_worker.domain.repositories.StatusRepository;
import com.coffee.notification_worker.domain.value_objects.NotificationId;

import java.util.Optional;

public class GetStatusUseCase {

    private final StatusRepository repository;

    public GetStatusUseCase(StatusRepository repository) {
        this.repository = repository;
    }

    public Optional<Status> execute(NotificationId id) {
        if (id == null) {
            throw new EmptyNotificationIdException();
        }

        return repository.get(id);
    }
}
