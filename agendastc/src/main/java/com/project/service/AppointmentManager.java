package com.project.service;

import com.project.model.CTScanAppointment;
import com.project.model.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {

    private final List<CTScanAppointment> appointments;  // Lista de todas las citas
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    }

    public boolean addAppointment(Patient patient, LocalDate date, LocalTime time, String studyType) {
        if (patient == null || date == null || time == null || studyType == null || studyType.isEmpty()) {
            System.out.println("Error: Datos invalidos para agenda.");
            return false;
        }

        for (CTScanAppointment appt : appointments) {
            if (appt.getDate().equals(date) && appt.getTime().equals(time)) {
                System.out.println("Error: Ese horario ya esta ocupado.");
                return false;
            }
        }

        CTScanAppointment newAppointment = new CTScanAppointment(patient, date, time, studyType);
        appointments.add(newAppointment);
        System.out.println("Paciente agendado con exito.");
        return true;
    }

    public void listAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No hay pacientes agendados.");
        } else {
            System.out.println("Agenda de tomografia:");
            for (CTScanAppointment appt : appointments) {
                System.out.println(
                    "Paciente: " + appt.getPatient().getFullName() +
                    ", Documento: " + appt.getPatient().getDocumentId() +
                    ", Edad: " + appt.getPatient().getAge() +
                    ", Fecha: " + appt.getDate().format(DATE_FMT) +
                    ", Hora: " + appt.getTime() +
                    ", Tipo de estudio: " + appt.getStudyType()
                );
            }
        }
    }

    public boolean cancelAppointment(String documentId, LocalDate date, LocalTime time) {
        for (CTScanAppointment appt : appointments) {
            if (appt.getPatient().getDocumentId().equals(documentId) &&
                appt.getDate().equals(date) &&
                appt.getTime().equals(time)) {
                appointments.remove(appt);
                System.out.println("Cita cancelada con éxito.");
                return true;
            }
        }
        System.out.println("No se encontró una cita con esos datos.");
        return false;
    }
}
