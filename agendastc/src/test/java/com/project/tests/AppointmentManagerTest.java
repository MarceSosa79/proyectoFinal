package com.project.tests;

import com.project.model.Patient;
import com.project.service.AppointmentManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Tag("regression")
public class AppointmentManagerTest {

    private AppointmentManager manager;
    private final DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @BeforeEach
    void setUp() {
        manager = new AppointmentManager();
    }

    @Test
    void addValidAppointment_returnsTrue() {
        Patient p = new Patient("Ana Perez", "12345678", 30);
        LocalDate date = LocalDate.parse("05-08-2025", dateFmt);
        boolean result = manager.addAppointment(p, date, LocalTime.of(10, 0), "simple");
        Assertions.assertTrue(result);
    }

    @Test
    void addingAppointmentOnSameDateTime_returnsFalse() {
        Patient p1 = new Patient("Carlos", "111", 50);
        Patient p2 = new Patient("Maria", "222", 45);

        LocalDate date = LocalDate.parse("06-08-2025", dateFmt);
        boolean first = manager.addAppointment(p1, date, LocalTime.of(10, 0), "simple");
        boolean second = manager.addAppointment(p2, date, LocalTime.of(10, 0), "con-contraste");

        Assertions.assertTrue(first);
        Assertions.assertFalse(second);
    }

    @Test
    void addAppointment_withNullsOrEmptyStudyType_returnsFalse() {
        boolean res1 = manager.addAppointment(null, null, null, "");
        boolean res2 = manager.addAppointment(
                new Patient("Test", "999", 20),
                LocalDate.parse("07-08-2025", dateFmt),
                LocalTime.NOON,
                null
        );
        Assertions.assertFalse(res1);
        Assertions.assertFalse(res2);
    }
}
