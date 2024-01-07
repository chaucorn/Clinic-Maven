package org.example;//package Role;

import java.util.Scanner;

public class Receptionist {
    private final DataStorage dataBasePatient;
    public Receptionist(DataStorage dataBasePatient) {
        this.dataBasePatient = dataBasePatient;
    }

    public void registerPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Family Name: ");
        String familyName = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Date of Birth yyyy-MM-dd: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Select diagnosis type: ");
        System.out.println("1. Surgery");
        System.out.println("2. Internal Medicine");
        System.out.println("3. Obstetrics");
        int choice = scanner.nextInt();

        String diagnosis = "";
        switch (choice) {
            case 1:
                diagnosis = "Surgery";
                break;
            case 2:
                diagnosis = "Internal Medicine";
                break;
            case 3:
                diagnosis = "Obstetrics";
                break;
            default:
                System.out.println("Invalid choice");
        }
        Patient patient = new Patient(name, familyName, age, diagnosis);
        patient.setAddress(address);
        patient.setPhoneNumber(phoneNumber);
        patient.setDiagnosis(diagnosis);
        dataBasePatient.addPatient(patient);

        System.out.println("src.Role.Patient registered successfully!");
    }
    public DataStorage getDataBasePatient() {
        return dataBasePatient;
    }

}
