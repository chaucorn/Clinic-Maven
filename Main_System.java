package org.example;//package Role;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class Main_System {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        DataStorage dataStorage = new DataStorage();
//        Receptionist receptionist = new Receptionist(dataStorage);
//        receptionist.registerPatient();
//        System.out.println("\nPatient Database:");
//        List<Patient> patientDatabase = dataStorage.getPatients();
//        CSVWriter.writePatientToCSVs(patientDatabase, "Patient_DataBase.csv","DatabaseMedInterne.csv", "DatabaseChirurgie.csv", "DatabaseObstertrique.csv");Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a role:");
        System.out.println("1. Receptionist");
        System.out.println("2. Doctor");
        int choice = scanner.nextInt();
        if (choice == 1) {
            // Receptionist
            DataStorage dataStorage = new DataStorage();
            Receptionist receptionist = new Receptionist(dataStorage);
            receptionist.registerPatient();
            System.out.println("\nPatient Database:");
            List<Patient> patientDatabase = dataStorage.getPatients();
            CSVWriter.writePatientToCSVs(patientDatabase, "Patient_DataBase.csv",
                    "DatabaseMedInterne.csv", "DatabaseChirurgie.csv",
                    "DatabaseObstertrique.csv" );
        } else if (choice == 2) {
            // Doctor
            String specialization = promptForDoctorSpecialization();
            Doctor doctor = new Doctor(specialization);

            // Choose the appropriate data storage based on the doctor's specialization
            DataStorage doctorDataStorage = new DataStorage();
            switch (specialization) {
                case "Chirurgie":
                    doctor.addDiagnosisFromCSV("DatabaseChirurgie.csv", doctorDataStorage);
                    break;
                case "Medicine Internet":
                    doctor.addDiagnosisFromCSV("DatabaseMedInterne.csv", doctorDataStorage);
                    break;
                case "Obstetrique":
                    doctor.addDiagnosisFromCSV("DatabaseObstertrique.csv", doctorDataStorage);
                    break;
                default:
                    System.out.println("Invalid specialization. Exiting...");
                    return;
            }
            doctor.addDiagnosis(doctorDataStorage);
            List<Patient> patientDatabase = doctorDataStorage.getPatients();

            DiagnosisUpdater.writePatientToCSVs(patientDatabase, "DiagnosedMedIn.csv",
                    "DiagnosedChirurgie.csv", "DiagnosedObstertrique.csv");

        } else {
            System.out.println("Invalid choice. Exiting...");
        }
    }

    private static String promptForDoctorSpecialization() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose doctor specialization:");
        System.out.println("1. Chirurgie");
        System.out.println("2. Medicine Internet");
        System.out.println("3. Obstetrique");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "Chirurgie";
            case 2:
                return "Medicine Internet";
            case 3:
                return "Obstetrique";
            default:
                System.out.println("Invalid choice. Exiting...");
                System.exit(0);
                return ""; // This line will never be reached, but required for compilation
        }

    }
}
