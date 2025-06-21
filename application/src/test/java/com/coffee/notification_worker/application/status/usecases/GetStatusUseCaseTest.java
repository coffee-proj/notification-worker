package com.coffee.notification_worker.application.status.usecases;

import com.coffee.notification_worker.domain.entities.Status;
import com.coffee.notification_worker.domain.exceptions.EmptyNotificationIdException;
import com.coffee.notification_worker.domain.repositories.StatusRepository;
import com.coffee.notification_worker.domain.types.SendingConditionType;
import com.coffee.notification_worker.domain.value_objects.NotificationId;
import com.coffee.notification_worker.domain.value_objects.StatusMessage;
import com.coffee.notification_worker.domain.value_objects.StatusType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GetStatusUseCaseTest {

    @Test
    void execute_With_Existing_Status() {
        // Given
        var id = new NotificationId(UUID.randomUUID());
        var status = new Status(id, new StatusType(SendingConditionType.SUCCESS), new StatusMessage("test"));

        var repository = Mockito.mock(StatusRepository.class);
        Mockito.when(repository.get(id)).thenReturn(Optional.of(status));

        var getStatusUseCase = new GetStatusUseCase(repository);

        // When
        var optionalStatus = getStatusUseCase.execute(id);

        // Then
        assertTrue(optionalStatus.isPresent());
        assertEquals(status, optionalStatus.get());
        Mockito.verify(repository).get(id);
    }

    @Test
    void execute_With_Non_Existing_Status() {
        // Given
        var id = new NotificationId(UUID.randomUUID());

        var repository = Mockito.mock(StatusRepository.class);
        Mockito.when(repository.get(id)).thenReturn(Optional.empty());

        var getStatusUseCase = new GetStatusUseCase(repository);

        // When
        var optionalStatus = getStatusUseCase.execute(id);

        // Then
        assertTrue(optionalStatus.isEmpty());
        Mockito.verify(repository).get(id);
    }

    @Test
    void execute_With_Null_Id() {
        // Given
        var repository = Mockito.mock(StatusRepository.class);
        var getStatusUseCase = new GetStatusUseCase(repository);

        // When & Then
        assertThrows(EmptyNotificationIdException.class, () -> getStatusUseCase.execute(null));
    }
}