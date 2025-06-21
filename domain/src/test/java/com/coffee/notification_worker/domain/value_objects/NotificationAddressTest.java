package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyNotificationAddressException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationAddressTest {

    @Test
    void should_Create_NotificationAddress_With_Valid_Value() {
        // Given
        String validValue = "test@example.com";

        // When
        NotificationAddress address = new NotificationAddress(validValue);

        // Then
        assertNotNull(address);
        assertEquals(validValue, address.value());
    }

    @Test
    void should_Throw_Exception_When_Value_Is_Null() {
        // When & Then
        assertThrows(EmptyNotificationAddressException.class, () -> new NotificationAddress(null));
    }
}