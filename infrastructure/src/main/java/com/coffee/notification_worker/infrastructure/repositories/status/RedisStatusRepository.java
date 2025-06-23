package com.coffee.notification_worker.infrastructure.repositories.status;

import com.coffee.notification_worker.domain.entities.Status;
import com.coffee.notification_worker.domain.repositories.StatusRepository;
import com.coffee.notification_worker.domain.value_objects.NotificationId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RedisStatusRepository implements StatusRepository {

    private final RedisRepository repository;

    public RedisStatusRepository(final RedisRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Status status) {
        var model = StatusModel.fromEntity(status);

        repository.save(model);
    }

    @Override
    public Optional<Status> get(NotificationId id) {
        var optionalModel = repository.findById(id.value());

        return optionalModel.map(StatusModel::toEntity);
    }
}



