package com.coffee.notification_worker.domain.value_objects;

import com.coffee.notification_worker.domain.exceptions.EmptyStatusTypeException;
import com.coffee.notification_worker.domain.types.SendingConditionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTypeTest {
    @Test
    void should_Create_Status_Type_With_Valid_Value() {
        // Given
        SendingConditionType validCondition = SendingConditionType.SUCCESS;

        // When
        StatusType statusType = new StatusType(validCondition);

        // Then
        assertNotNull(statusType);
        assertEquals(validCondition, statusType.value());
    }

    @Test
    void should_Throw_Exception_When_Value_Is_Null() {
        // When & Then
        assertThrows(EmptyStatusTypeException.class, () -> new StatusType(null));
    }
}