package com.coffee.notification_worker.domain.repositories;

import com.coffee.notification_worker.domain.entities.Status;
import com.coffee.notification_worker.domain.value_objects.NotificationId;

import java.util.Optional;

public interface StatusRepository {
    void save(Status status);

    Optional<Status> get(NotificationId id);
}
