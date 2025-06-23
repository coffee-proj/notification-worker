package com.coffee.notification_worker.infrastructure.repositories.status;

import com.coffee.notification_worker.domain.entities.Status;
import com.coffee.notification_worker.domain.types.SendingConditionType;
import com.coffee.notification_worker.domain.value_objects.NotificationId;
import com.coffee.notification_worker.domain.value_objects.StatusMessage;
import com.coffee.notification_worker.domain.value_objects.StatusType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("status")
public class StatusModel {
    @Id
    private final UUID id;
    private final SendingConditionType status;
    private final String message;

    public StatusModel(UUID id, SendingConditionType status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public static StatusModel fromEntity(Status entity) {
        return new StatusModel(
                entity.getNotificationId().value(),
                entity.getType().value(),
                entity.getMessage().value()
        );
    }

    public Status toEntity() {
        return new Status(new NotificationId(this.id), new StatusType(this.status), new StatusMessage(this.message));
    }
}
