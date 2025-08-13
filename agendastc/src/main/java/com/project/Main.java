package com.project;

import com.project.model.Patient;
import com.project.service.AppointmentManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentManager manager = new AppointmentManager();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menu de Gestion para Tomografias ---");
            System.out.println("1. Agendar tomografia");
            System.out.println("2. Ver agenda");
            System.out.println("3. Cancelar agenda");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    try {
                        System.out.print("Nombre completo del paciente: ");
                        String name = sc.nextLine();

                        System.out.print("Documento del paciente: ");
                        String documentId = sc.nextLine();

                        System.out.print("Edad del paciente: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Fecha para el estudio (dd-MM-yyyy): ");
                        LocalDate date = LocalDate.parse(sc.nextLine(), DATE_FMT);

                        System.out.print("Hora para el estudio (HH:mm): ");
                        LocalTime time = LocalTime.parse(sc.nextLine());

                        System.out.print("Tipo de estudio: ");
                        String studyType = sc.nextLine();

                        Patient patient = new Patient(name, documentId, age);
                        manager.addAppointment(patient, date, time, studyType);

                    } catch (DateTimeParseException dtpe) {
                        System.out.println("OJO!!!! El formato de fecha u hora no es valido. Use dd-MM-yyyy y HH:mm.");
                    } catch (NumberFormatException nfe) {
                        System.out.println("OJO!!! La edad debe ser numerica.");
                    } catch (Exception e) {
                        System.out.println("OJO!!! Error al agendar paciente. Verifique los datos ingresados.");
                    }
                    break;

                case "2":
                    manager.listAppointments();
                    break;

                case "3":
                    try {
                        System.out.print("Documento del paciente: ");
                        String documentId = sc.nextLine();

                        System.out.print("Fecha de agenda a cancelar (dd-MM-yyyy): ");
                        LocalDate date = LocalDate.parse(sc.nextLine(), DATE_FMT);

                        System.out.print("Hora de agenda a cancelar (HH:mm): ");
                        LocalTime time = LocalTime.parse(sc.nextLine());

                        manager.cancelAppointment(documentId, date, time);
                    } catch (DateTimeParseException dtpe) {
                        System.out.println("OJO!!! El formato de fecha u hora no es valido. Use dd-MM-yyyy y HH:mm.");
                    } catch (Exception e) {
                        System.out.println("Error al cancelar la agenda. Verifique los datos.");
                    }
                    break;

                case "4":
                    System.out.println("Saliendo del sistema. ¡Gracias por utilizar Bios-Soft!");
                    exit = true;
                    break;

                default:
                    System.out.println("Opcion no valida!!!!");
            }
        }

        sc.close();
    }
}
