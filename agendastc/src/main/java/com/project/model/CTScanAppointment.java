package com.project.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CTScanAppointment {

    private Patient patient;
    private LocalDate date;
    private LocalTime time;
    private String studyType;

    public CTScanAppointment(Patient patient, LocalDate date, LocalTime time, String studyType) {
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.studyType = studyType;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }


    @Override
    public String toString() {
        return "CTScanAppointment{" +
                "Paciente=" + patient.getFullName() +
                ", CI=" + patient.getDocumentId() +
                ", Fecha=" + date +
                ", Hora=" + time +
                ", TipoEstudio='" + studyType + '\'' +
                '}';
    }
}
