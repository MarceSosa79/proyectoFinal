package com.project.model;

public class Patient {

    private String fullName;
    private String documentId;
    private int age;

    public Patient(String fullName, String documentId, int age) {
        this.fullName = fullName;
        this.documentId = documentId;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public int getAge() {
        return age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "Nombre='" + fullName + '\'' +
                ", CI='" + documentId + '\'' +
                ", Edad=" + age +
                '}';
    }
}
