package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationContentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationContentTest {

    @Test
    void should_Create_NotificationContent_With_Valid_Value() {
        // Given
        String validValue = "test";

        // When
        NotificationContent content = new NotificationContent(validValue);

        // Then
        assertNotNull(content);
        assertEquals(validValue, content.value());
    }

    @Test
    void should_Throw_Exception_WhenValue_Is_Null() {
        // When & Then
        assertThrows(EmptyNotificationContentException.class, () -> new NotificationContent(null));
    }
}