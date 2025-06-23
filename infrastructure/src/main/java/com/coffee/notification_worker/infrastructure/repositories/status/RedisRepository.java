package com.coffee.notification_worker.infrastructure.repositories.status;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RedisRepository extends CrudRepository<StatusModel, UUID> {
}
