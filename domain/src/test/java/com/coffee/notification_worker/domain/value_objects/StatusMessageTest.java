package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyStatusMessageException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusMessageTest {
    @Test
    void should_Create_StatusMessage_With_Valid_Value() {
        // Given
        String validContent = "test";

        // When
        StatusMessage message = new StatusMessage(validContent);

        // Then
        assertNotNull(message);
        assertEquals(validContent, message.value());
    }

    @Test
    void should_Throw_Exception_When_Value_Is_Null() {
        // When & Then
        assertThrows(EmptyStatusMessageException.class, () -> new StatusMessage(null));
    }
}