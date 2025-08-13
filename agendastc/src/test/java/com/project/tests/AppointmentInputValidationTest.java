package com.project.tests;

import com.project.model.Patient;
import com.project.service.AppointmentManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Tag("smoke")
public class AppointmentInputValidationTest {

    private AppointmentManager manager;
    private final DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @BeforeEach
    void init() {
        manager = new AppointmentManager();
    }

    @Test
    void emptyStudyType_shouldFail() {
        Patient p = new Patient("Juan Gomez", "444", 40);
        boolean result = manager.addAppointment(
                p, LocalDate.parse("10-08-2025", dateFmt), LocalTime.of(11, 0), "");
        Assertions.assertFalse(result);
    }

    @Test
    void nullPatient_shouldFail() {
        boolean result = manager.addAppointment(
                null, LocalDate.parse("10-08-2025", dateFmt), LocalTime.of(11, 0), "simple");
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({
        "12-08-2025,09,00",
        "12-08-2025,10,30",
        "12-08-2025,14,15"
    })
    void parameterized_validDifferentTimes_shouldSucceed(
            String dateStr, String hourStr, String minuteStr) {

        int hour = Integer.parseInt(hourStr, 10);
        int minute = Integer.parseInt(minuteStr, 10);

        Patient p = new Patient("Laura", "555", 28);
        LocalDate date = LocalDate.parse(dateStr, dateFmt);
        boolean result = manager.addAppointment(
                p, date, LocalTime.of(hour, minute), "simple");
        Assertions.assertTrue(result);
    }
}
