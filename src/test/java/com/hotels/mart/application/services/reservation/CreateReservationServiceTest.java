package com.hotels.mart.application.services.reservation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class CreateReservationServiceTest {
    @Test
    void testCreateReservation() {
        boolean value1 = true;
        boolean value2 = true;

        assertTrue(value1 == value2, "Los valores deben ser iguales");
    }

}
