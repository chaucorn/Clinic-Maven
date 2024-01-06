package org.example;//package Role;

import java.util.Scanner;

public class Receptionist {
    private final DataStorage dataBasePatient;
//    private final DataStorage dataStorageMedInterne;
//    private final DataStorage dataStorageChirurgie;
//    private final DataStorage dataStorageObstetrique;

    public Receptionist(DataStorage dataBasePatient) {
        this.dataBasePatient = dataBasePatient;
//        this.dataStorageMedInterne = dataStorageMedInterne;
//        this.dataStorageChirurgie = dataStorageChirurgie;
//        this.dataStorageObstetrique = dataStorageObstetrique;
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
        System.out.println("1. Chirurgie");
        System.out.println("2. Medicine Interne");
        System.out.println("3. Obstetrique");
        int choice = scanner.nextInt();

        String diagnosis = "";
        switch (choice) {
            case 1:
                diagnosis = "Chirurgie";
                break;
            case 2:
                diagnosis = "Medicine Interne";
                break;
            case 3:
                diagnosis = "Obstetrique";
                break;
            default:
                System.out.println("Invalid choice");
        }



        Patient patient = new Patient(name, familyName, age, diagnosis);
        patient.setAddress(address);
        patient.setPhoneNumber(phoneNumber);
        patient.setDiagnosis(diagnosis);
        //patient.setDateOfBirth(dateOfBirth);

//        switch (diagnosis) {
//            case "Chirurgie":
//                dataStorageChirurgie.addPatient(patient);
//                break;
//            case "Medicine Interne":
//                dataStorageMedInterne.addPatient(patient);
//                break;
//            case "Obstetrique":
//                dataStorageObstetrique.addPatient(patient);
//                break;
//        }
        dataBasePatient.addPatient(patient);

        System.out.println("src.Role.Patient registered successfully!");
    }
    public DataStorage getDataBasePatient() {
        return dataBasePatient;
    }

//    public DataStorage getDataStorageMedInterne() {
//        return dataStorageMedInterne;
//    }
//
//    public DataStorage getDataStorageChirurgie() {
//        return dataStorageChirurgie;
//    }
//
//    public DataStorage getDataStorageObstetrique() {
//        return dataStorageObstetrique;
//    }
}
