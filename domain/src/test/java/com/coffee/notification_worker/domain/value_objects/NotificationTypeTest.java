package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationTypeException;
import com.coffee.notification_worker.domain.types.SendingType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTypeTest {
    @Test
    void should_Create_NotificationType_With_Valid_Value() {
        // Given
        SendingType validType = SendingType.EMAIL;

        // When
        NotificationType type = new NotificationType(validType);

        // Then
        assertNotNull(type);
        assertEquals(validType, type.value());
    }

    @Test
    void should_Throw_Exception_When_Value_Is_Null() {
        // When & Then
        assertThrows(EmptyNotificationTypeException.class, () -> new NotificationType(null));
    }
}