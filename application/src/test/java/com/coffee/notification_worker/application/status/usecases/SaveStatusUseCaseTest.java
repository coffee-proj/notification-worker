package com.coffee.notification_worker.application.status.usecases;

import com.coffee.notification_worker.application.status.exceptions.EmptyStatusException;
import com.coffee.notification_worker.domain.entities.Status;
import com.coffee.notification_worker.domain.repositories.StatusRepository;
import com.coffee.notification_worker.domain.types.SendingConditionType;
import com.coffee.notification_worker.domain.value_objects.NotificationId;
import com.coffee.notification_worker.domain.value_objects.StatusMessage;
import com.coffee.notification_worker.domain.value_objects.StatusType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SaveStatusUseCaseTest {

    @Test
    void execute_With_Valid_Status() {
        // Given
        var status = new Status(
                new NotificationId(UUID.randomUUID()),
                new StatusType(SendingConditionType.SUCCESS),
                new StatusMessage("test")
        );

        var repository = Mockito.mock(StatusRepository.class);
        var saveStatusUseCase = new SaveStatusUseCase(repository);

        // When
        saveStatusUseCase.execute(status);

        // Then
        Mockito.verify(repository).save(status);
    }

    @Test
    void execute_With_Null_Status() {
        // Given
        var repository = Mockito.mock(StatusRepository.class);
        var saveStatusUseCase = new SaveStatusUseCase(repository);

        // When & Then
        assertThrows(EmptyStatusException.class, () -> saveStatusUseCase.execute(null));
    }
}