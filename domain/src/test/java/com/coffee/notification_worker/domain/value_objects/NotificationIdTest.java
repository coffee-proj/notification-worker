package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationIdException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NotificationIdTest {
    @Test
    void should_Create_NotificationId_With_Valid_Value() {
        // Given
        UUID validUuid = UUID.randomUUID();

        // When
        NotificationId id = new NotificationId(validUuid);

        // Then
        assertNotNull(id);
        assertEquals(validUuid, id.value());
    }

    @Test
    void should_Throw_Exception_When_Value_Is_Null() {
        // When & Then
        assertThrows(EmptyNotificationIdException.class, () -> new NotificationId(null));
    }
}